# Importing necessary libraries
from flask import Flask, request, jsonify, render_template
import numpy as np
import pandas as pd
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.metrics.pairwise import cosine_similarity

# Initializing Flask app
app = Flask(__name__)

# Loading datasets
netflix = pd.read_csv('netflix_titles.csv')
imdb_titles = pd.read_csv('imdb-movies-dataset.csv', usecols=['Title','Year','Genre','Rating'])
imdb_titles = imdb_titles.drop_duplicates(subset='Title', keep='first')
joint_data = imdb_titles.merge(netflix, left_on='Title', right_on='title', how='inner')
joint_data = joint_data.drop(['title','Year','show_id','type','country','date_added','release_year','rating','duration'], axis=1)

# Cleaning data
joint_data = joint_data[joint_data['Rating'] >= 5.0]
filledna = joint_data.fillna('')

def clean_data(x):
    return str.lower(x.replace(" ", ""))

features = ['Title', 'director', 'cast', 'listed_in', 'description','Genre']
for feature in features:
    filledna[feature] = filledna[feature].apply(clean_data)

def create_soup(x):
    return x['Title'] + ' ' + x['director'] + ' ' + x['cast'] + ' ' + x['listed_in'] + ' ' + x['description'] + ' ' + x['Genre']

filledna['soup'] = filledna.apply(create_soup, axis=1)
count = CountVectorizer(stop_words='english')
count_matrix = count.fit_transform(filledna['soup'])
cosine_sim2 = cosine_similarity(count_matrix, count_matrix)
filledna = filledna.reset_index()
indices = pd.Series(filledna.index, index=filledna['Title'])

# Function to get recommendations
def get_recommendation_new(Title, cosine_sim=cosine_sim2):
    Title = Title.replace(' ', '').lower()
    idx = indices[Title]
    sim_scores = list(enumerate(cosine_sim[idx]))
    sim_scores = sorted(sim_scores, key=lambda x: x[1], reverse=True)
    sim_scores = sim_scores[1:11]
    movie_indices = [i[0] for i in sim_scores]
    recommendations = joint_data[['Title', 'Rating', 'Genre']].iloc[movie_indices]
    recommendations = recommendations[joint_data['Rating'] >= 5.0]
    recommendations = recommendations.sort_values(by='Rating', ascending=False)
    return recommendations

# Flask routes
@app.route('/')
def home():
    return render_template('index.html')

@app.route('/recommend', methods=['GET', 'POST'])
def recommend():
    if request.method == 'POST':
        Title = request.form['title']
        recommendations = get_recommendation_new(Title)
        return render_template('recommend.html', recommendations=recommendations.to_dict(orient='records'))
    return render_template('recommend.html')

if __name__ == '__main__':
    app.run(debug=True)

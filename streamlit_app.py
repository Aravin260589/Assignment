import streamlit as st
import pandas as pd
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.metrics.pairwise import cosine_similarity

# Load and prepare the dataset
netflix = pd.read_csv('netflix_titles.csv')
imdb_titles = pd.read_csv('imdb-movies-dataset.csv', usecols=['Title', 'Year', 'Genre', 'Rating'])
imdb_titles = imdb_titles.drop_duplicates(subset='Title', keep='first')
joint_data = imdb_titles.merge(netflix, left_on='Title', right_on='title', how='inner')
joint_data = joint_data.drop(['title', 'Year', 'show_id', 'type', 'country', 'date_added', 'release_year', 'rating', 'duration'], axis=1)

# Clean data
joint_data = joint_data[joint_data['Rating'] >= 5.0]
filledna = joint_data.fillna('')

def clean_data(x):
    return str.lower(x.replace(" ", ""))

features = ['Title', 'director', 'cast', 'listed_in', 'description', 'Genre']
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

# Streamlit app
st.title('Movie Recommendation System')

st.write("""
Enter a movie title to get recommendations.
""")

movie_title = st.text_input('Enter a movie title:', '')

if st.button('Get Recommendations'):
    recommendations = get_recommendation_new(movie_title)
    st.write('Recommended Movies:')
    st.write(recommendations)

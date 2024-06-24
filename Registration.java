public class Registration 
{
    public static void main(String[] args) 
    {
    	// Create New Faculty and Program
    	Id Faculty = new Id ("FSKTM","Masters in Computer Science");
    	
        // Create courses
        Course Course1 = new Course("SSK5090","Research Methods in Computer Science");
        Course Course2 = new Course("SSK5212","Big Data Technology");
        Course Course3 = new Course("SSK5221","Internet of Things");
        
        //Configure Course in Faculty
        Faculty.ConfigCourse(Course1);
        Faculty.ConfigCourse(Course2);
        Faculty.ConfigCourse(Course3);
        
        //Create Groups
        Id Group1 = new Id (1);  

    	// Create students
        Student Student1 = new Student("Aravin","GS69203");
        Student Student2 = new Student("Siva","GS69321");
        
        // Create supervisors	
        Supervisor Supervisor1 = new Supervisor("DrErzam","LS101");
        Supervisor Supervisor2 = new Supervisor("DrThina","LS102");
   
        // Enroll students in courses
        Student1.enrollInCourse(Course1);
        Student1.enrollInCourse(Course2);
        Student1.enrollInCourse(Course3);
        Student2.enrollInCourse(Course1);
        Student2.enrollInCourse(Course2);
        Student1.enrollInCourseList();
        Student2.enrollInCourseList();

        // Assign students to group
        Group1.ConfigGroup(Student1);
        Group1.ConfigGroup(Student2);
        
        // Supervise students
        Supervisor1.enrollstudent(Student1);
        Supervisor2.enrollstudent(Student2);
        
    }
}
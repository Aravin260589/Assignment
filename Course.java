//import java.util.ArrayList;
//import java.util.List;
public class Course
{
	String CourseCode;
	String CourseName;
	//String FacultyId;
	//int GroupId;
	//List<Student> enrolledStudents;
	
public Course(String CourseCode, String CourseName) 
		{
	        this.CourseName = CourseName;
	        this.CourseCode = CourseCode;
	        //this.enrolledStudents = new ArrayList<>();
	    }

///////////////////	
public  String getCourseCode()
{
	return CourseCode;
}
////////////////////
public  String getCourseName()
{
	return CourseName;
}
//////////
	public String toString()
	{	
		return this.getCourseCode();		
	}

}




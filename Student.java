
import java.util.Arrays;
public class Student 
{
	String StudentName;
	String MatricNo;
	Course[] RegcourseList;

	//Student constructor to initialize the data fields.
    public Student(String StudentName, String MatricNo ) 
    {
    	this.StudentName = StudentName;	
        this.MatricNo = MatricNo;
        RegcourseList = new Course [3];
    }

    public String getMatricNo() 
    {
     return MatricNo;
    }

    public String getStudentName() {
        return StudentName;
    }
	
    public void enrollInCourse(Course course) 
    {	
    	{	
    	for (int i = 0; i<RegcourseList.length;)
    	{
    		if (RegcourseList[i] == null)
    		{
    		RegcourseList[i] = course;
            System.out.println(StudentName +" ("+MatricNo+") registered for : "+ course.getCourseName()+" ("+ course.getCourseCode()+ ")");
            break;
    		}
    		else i = i+1;
    	}
    	}
    }
    
    public void enrollInCourseList() 
    {	
 
    	System.out.println(StudentName+"'s Current Registered Course List: "+(Arrays.toString(RegcourseList)));
    }
      
}
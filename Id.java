public class Id 
{
	String FacultyId;
	String ProgramName;
	int GroupId;
	Course[] SubjectList;
	Student[] GroupList;
	
    public Id(String FacultyId,String ProgramName) 
    {
    	this.FacultyId = FacultyId;
    	this.ProgramName = ProgramName;
    	SubjectList = new Course [3];
    	System.out.println("Faculty selected is: "  + this.getFacultyId());

    }
    
    public Id(int GroupId) 
    {
    	this.GroupId = GroupId; 
    	GroupList = new Student [3];
    }


	public String getFacultyId() 
    {
        return FacultyId;
    }
	public String getProgramName() 
    {
        return ProgramName;
    }
    
    public void ConfigCourse(Course course) 
    {	

    	for (int i = 0; i<SubjectList.length;)
    	{
    		if (SubjectList[i] == null)
    		{
    			SubjectList[i] = course;
            System.out.println(course.CourseName+" ("+ course.getCourseCode()+") is offered under " +getProgramName()+" Program");
            break;
    		}
    		else i = i+1;
    	}
    }
    
    public void ConfigGroup(Student student) 
    {	

    	for (int i = 0; i<GroupList.length;)
    	{
    		if (GroupList[i] == null)
    		{
    			GroupList[i] = student;
    			System.out.println(student.getStudentName() +" ("+student.getMatricNo()+") succesfully placed in group: " +GroupId);
            break;
    		}
    		else i = i+1;
    	}
    }
}
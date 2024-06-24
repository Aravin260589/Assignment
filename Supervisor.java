
public class Supervisor
{
	String StaffNo;
	String SupervisorName;
	String FacultyId;
	Student[] RegStudentList;


    public Supervisor(String SupervisorName, String StaffNo) 
    {
    	this.StaffNo = StaffNo;
    	this.SupervisorName = SupervisorName;
        RegStudentList = new Student [2];
    }

    
    public void enrollstudent(Student student) 
    {	

    	for (int i = 0; i<RegStudentList.length;)
    	{
    		if (RegStudentList[i] == null)
    		{
    			RegStudentList[i] = student;
    			//System.out.println(Arrays.(RegStudentList));

            System.out.println(SupervisorName +" ("+StaffNo+") is supervising: " + student.getStudentName()+" ("+student.getMatricNo()+")");
            break;
    		}
    		else i = i+1;
    	}
    }
}
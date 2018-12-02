
public class Request implements Comparable<Request> {
	private String studentName;
	private String studentDept;
	private String studentLevel;
	private String courseDept;
	private int courseNumber;
	private double [][] GPA_ARRAY;
	// Constructor
	public Request(String studentName, String studentDept, String studentLevel,
				String courseDept, int courseNumber, double[][] GPA_ARRAY)
	{
		this.studentName = studentName;
		this.studentDept = studentDept;
		this.studentLevel = studentLevel;
		this.courseDept = courseDept;
		this.courseNumber = courseNumber;
		this.GPA_ARRAY = GPA_ARRAY;
	}
	@Override
	public int compareTo(Request o) 
	{
		Request req1 = this;
		Request req2 = o;
		if(req1.studentDept.equals(req1.courseDept))
		{
			if(!(req2.studentDept.equals(req1.courseDept)))
			{
				return 0;
			}
		}
		if(yearsFromGraduation(req1.studentLevel) != yearsFromGraduation(req2.studentLevel))
		{
			if(yearsFromGraduation(req1.studentLevel) > yearsFromGraduation(req2.studentLevel))
			{
				return 0;
			}
			else
			{
				return 1;
			}
		}
		if()
		return 0;
	}

	// Returns number of years to graduation (0 for seniors, 1 for juniors etc.). This is determined from the 
	// student’s level – senior, junior, etc.
	public int yearsFromGraduation(String level)
	{
		if(level.equals("Senior"))
		{
			return 0;
		}
		else if(level.equals("Junior"))
		{
			return 1;
		}
		else if(level.equals("Sophomore"))
		{
			return 2;
		}
		else
		{
			return 3;
		}
	}

	// Calculate the GPA for a particular student.
	private double GPA_Cal(int student)
	{
		double GPA = 0;
		double GPA_hours = 0;
		for(int i = 0; i < 8; i+= 2)
		{
			GPA += GPA_ARRAY[student][i] * GPA_ARRAY[student][i + 1];
			GPA_hours = GPA_ARRAY[student][i+1];
		}
		GPA = GPA / GPA_hours;
		return GPA;
	}

	// Getters for a student’s name and department, and the department and number of a course 
	public String getName()
	{
		return studentName;
	}
	public String getDepartment()
	{
		return studentDept;
	}
	public String getCourseDept()
	{
		return courseDept;
	}
	public int getCourseNumber()
	{
		return courseNumber;
	}
}

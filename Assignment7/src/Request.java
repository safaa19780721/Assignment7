
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
			if(!(req2.studentDept.equals(req2.courseDept)))
			{
				return 0;
			}
		}
		if(req2.studentDept.equals(req2.courseDept))
		{
			if(!(req1.studentDept.equals(req1.courseDept)))
			{
				return 1;
			}
		}
		if(yearsFromGraduation(req1.studentLevel) != yearsFromGraduation(req2.studentLevel))
		{
			if(yearsFromGraduation(req1.studentLevel) < yearsFromGraduation(req2.studentLevel))
			{
				return 0;
			}
			else
			{
				return 1;
			}
		}
		Double GPA1 = new Double(GPA_Cal(req1.GPA_ARRAY));
		Double GPA2 = new Double(GPA_Cal(req2.GPA_ARRAY));
		if(GPA1.compareTo(GPA2) != 0) 
		{
			System.out.println("HERE2");
			if(GPA1.compareTo(GPA2) > 0) 
			{
				return 0;
			}
		}
		return 1;
	}

	// Returns number of years to graduation (0 for seniors, 1 for juniors etc.). This is determined from the 
	// student’s level – senior, junior, etc.
	public int yearsFromGraduation(String level)
	{
		if((level.replaceAll(" ", "")).equalsIgnoreCase("Senior"))
		{
			return 0;
		}
		else if((level.replaceAll(" ", "")).equalsIgnoreCase("Junior"))
		{
			return 1;
		}
		else if((level.replaceAll(" ", "")).equalsIgnoreCase("Sophomore"))
		{
			return 2;
		}
		else
		{
			return 3;
		}
	}

	// Calculate the GPA for a particular student.
	private double GPA_Cal(double[][] GPA_Array)
	{
		double GPA = 0;
		double GPA_hours = 0;
		for(int i = 0; i < 4; i++)
		{
			GPA += GPA_ARRAY[0][i] * GPA_ARRAY[1][i];
			GPA_hours += GPA_ARRAY[1][i];
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

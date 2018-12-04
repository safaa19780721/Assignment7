
public class Request implements Comparable<Request> {
	private String studentName;
	private String studentDept;
	private String studentLevel;
	private String courseDept;
	private int courseNumber;
	private double [][] GPA_ARRAY;
	private double GPA;

	/**
	 * @param studentName the name of the student requesting a course
	 * @param studentDept the department that the student requesting a course is in
	 * @param studentLevel the grade level of the student
	 * @param courseDept the department the requested course is in
	 * @param courseNumber the number of the requested course
	 * @param GPA_ARRAY an array containing the last 4 grades received and credit hours of those courses
	 */
	public Request(String studentName, String studentDept, String studentLevel,
				String courseDept, int courseNumber, double[][] GPA_ARRAY)
	{
		this.studentName = studentName;
		this.studentDept = studentDept;
		this.studentLevel = studentLevel;
		this.courseDept = courseDept;
		this.courseNumber = courseNumber;
		this.GPA_ARRAY = GPA_ARRAY;
		this.GPA = this.GPA_Cal(GPA_ARRAY);
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
		double GPA1 = req1.GPA;
		double GPA2 = req2.GPA;
		if(GPA1 > GPA2) 
		{
			return 0;
		}
		return 1;
	}

	/**
	 * Returns number of years to graduation (0 for seniors, 1 for juniors etc.). This is determined from the 
	// student’s level – senior, junior, etc.
	 * @param level the current grade level of the student
	 * @return number of years to graduation
	 */
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

	/**
	 * Calculate the GPA for a particular student.
	 * @param GPA_Array a 2d array containing the last 4 grades received and credit hours of those courses row 0 should be grades and row 1 should be credit hours
	 * @return the GPA for the given student
	 */
	public double GPA_Cal(double[][] GPA_Array)
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

	/**
	 * @return the name of the student
	 */
	public String getName()
	{
		return studentName;
	}
	
	/**
	 * @return the department of the student
	 */
	public String getDepartment()
	{
		return studentDept;
	}
	
	/**
	 * @return the department of the requested course
	 */
	public String getCourseDept()
	{
		return courseDept;
	}
	
	/**
	 * @return the number of the requested course
	 */
	public int getCourseNumber()
	{
		return courseNumber;
	}
}

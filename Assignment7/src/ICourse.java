public interface ICourse {

	/**
	 * @return true if the capacity for this course has been reached.
	 */
	boolean isFull();
	
	/**
	 * Add this student to the arraylist for enrolled students for this course.
	 * @param name the name of the student to be enrolled in the course
	 */
	void addStudent(String name);
	
	/**
	 * Print the classlist for this course.
	 */
	void printClassList();
	
	// 
	/**
	 * Determines if this course object is the same as the object received as parameter.
	 * @param arg0 course to compare it to
	 * @return true if the 2 courses are the same
	 */
	boolean equals(Object arg0);
}
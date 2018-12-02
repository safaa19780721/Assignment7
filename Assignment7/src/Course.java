import java.util.*;
import java.util.function.Consumer;

public class Course implements ICourse{
	
	private String dept;
	private int number;
	private int capacity;
	private int enrollment;
	private ArrayList<String> students;

	public String getDept() {
		return this.dept;
	}

	public int getNumber() {
		return this.number;
	}

	public Course(String dept, int number, int capacity) {
		
		this.dept = dept;
		this.number = number;
		this.capacity = capacity;
		students = new ArrayList<>();
		
	}

	public boolean isFull() {
		
		return (this.enrollment == this.capacity);
	}

	public void addStudent(String name) {
		
		this.students.add(name);
		this.enrollment++;
		
		System.out.println(name + " successfully registered "
				+ this.dept + " " + this.number);
		
	}

	Consumer<String> action = x -> {
		
		System.out.println(x);
		
	};

	public void printClassList() {
		
		System.out.println("Class List for " + this.dept
				+ " " + this.number);
		
		ListIterator<String> rollCall = students.listIterator();
		
		rollCall.forEachRemaining(action);
		
	}
	
	public boolean thisCourse(String dept, int number) {
		
		boolean found = false;
		
		if( this.dept.equalsIgnoreCase(dept) && (this.number == number) ) {
			found = true;
		}
		
		return found;
		
	}

	public String toString() {
		
		return (this.dept + "," + this.number + "," + this.capacity);
		
	}

}
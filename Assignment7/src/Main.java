import java.util.*;
import java.io.*;
/*
 * Tyler Henniges and Richard Graziano
 * 12/05/18
 * CS1120-550 LA7
 * This program manages course requests and determines whether a student can get into a class
 * based off their priority on the list
 */
public class Main {

	public static void main(String[] args) throws IOException{
		
		PriorityQueue<Request> requestQueue = new PriorityQueue<Request>();
		ArrayList<Course> courses = new ArrayList<Course>();
		BufferedReader fileIn = new BufferedReader(new FileReader("course.txt"));
		BufferedReader fileIn1 = new BufferedReader(new FileReader("request.txt"));
		IController control = new Controller(requestQueue, courses, fileIn, fileIn1);
		control.readCourseFile();
		control.readRequestFile();
		control.processRequests();
		control.printClassList();
	}
}
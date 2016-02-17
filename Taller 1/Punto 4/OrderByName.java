

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class OrderByName implements IComparisonStrategy {

	@Override
	public void Order(ArrayList<Student> students){
		Collections.sort(students, new Comparator<Student>() {
	        public int compare(Student s1, Student s2) {
	           return (s1.getName()).compareTo(s2.getName());
	        }
		});	
	}
}


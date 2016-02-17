

import java.util.Comparator;


public class AgeComparator implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		return Integer.valueOf(s1.getAge()).compareTo(s2.getAge());
	}



}

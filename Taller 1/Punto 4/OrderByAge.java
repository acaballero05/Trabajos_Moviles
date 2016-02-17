

import java.util.ArrayList;
import java.util.Collections;

public class OrderByAge implements IComparisonStrategy{

	@Override
	public void Order(ArrayList<Student> students){
		Collections.sort(students, new AgeComparator());
	}

}
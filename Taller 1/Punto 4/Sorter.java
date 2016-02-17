

import java.util.ArrayList;


public class Sorter {
	
	private ArrayList<Student> students;
	
	public Sorter() {
		this.students = new ArrayList<Student>();
		this.students.add(new Student(1, "Javier", "Sistemas", 21));
		this.students.add(new Student(2, "Efrain", "Industrial", 19));
		this.students.add(new Student(3, "Lucas", "Medicina", 20));
		this.students.add(new Student(4, "Marcos", "Electronica", 18));
		this.students.add(new Student(5, "Roco", "Comunicacion", 18));
		this.students.add(new Student(6, "Andres", "Sistemas", 19));
		this.students.add(new Student(9, "Alberto", "Comunicacion", 28));
		this.students.add(new Student(22, "Geraldine", "Musica", 22));
		this.students.add(new Student(12, "Amanda", "Administracion", 19));
		this.students.add(new Student(19, "Lucinda", "Administracion", 22));
		this.students.add(new Student(20, "Angie", "Quimica", 23));
		this.students.add(new Student(18, "Luciana", "Comunicacion", 21));
	}	
	
	public void Order(IComparisonStrategy orderBy) {
		orderBy.Order(students);
	}
	
	public Student get(int i){
		return this.students.get(i);
	}
}
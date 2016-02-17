

public class Student {
	
	private int code;
	private String name;
	private String career;
	private int age;
	
	public Student(int code, String name, String career, int age) {
		this.name=name;
		this.code=code;
		this.career=career;
		this.age=age;
	}
	
	public String getName(){
		return name;
	}
	
	public int getCode(){
		return code;
	}
	
	public String getCareer(){
		return career;
	}
	
	public int getAge(){
		return age;
	}
}

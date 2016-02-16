package Punto5;

public class Circle extends GeometricFigure{
	private float pi;
	private float ratio;
	
	
	public Circle(float pi,float ratio) {
		super();
		this.name = "Circle";
		this.description = "No se que poner";
		this.pi = pi;
		this.ratio = ratio;
	}
	
	public void setPi(float pi){
		this.pi=pi;
	}
	
	public void setRatio(float ratio){
		this.ratio=ratio;
	}
	
	public float getPi(){
		return this.pi;
	}
	
	public float getRatio(){
		return this.ratio;
	}
	
	public float calculatePerimeter(){
		return (float) 2*this.pi*this.ratio;
		
	}
	public float calculateArea(){
		return (float) (this.pi*(Math.pow(this.ratio,2)));
	}
	
	public float calculateArea(float pi) {
		return (float) (pi*(Math.pow(this.ratio,2)));
	}
}

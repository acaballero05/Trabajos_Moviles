package Punto5;

public class Rectangular extends GeometricFigure{
	private float height;
	private float width;

	public Rectangular(float height,float width) {
		super();
		this.name = "Rectangular";
		this.description = "No se que poner";
		this.height = height;
		this.width = width;
	}
	
	public void setHeight(float height){
		this.height=height;
	}
	
	public void setRatio(float width){
		this.width=width;
	}
	
	public float getHeight(){
		return this.height;
	}
	
	public float getWidth(){
		return this.width;
	}
		
	public float calculatePerimeter(){
		return (float) ((2*this.height)+(2*this.width));
		
	}
	public float calculateArea(){
		return (float) (this.width*this.height);
	}

}

package Punto5;

public class Square extends GeometricFigure {
	private float edge;

	public Square(float edge) {
		super();
		this.name = "Square";
		this.description = "No se que poner";
		this.edge = edge;
	}
	
	public void setEdge(float edge){
		this.edge=edge;
	}
	
	public float getEdge(){
		return this.edge;
	}
	
	public float calculatePerimeter(){
		return (float) (4*this.edge);
		
	}
	public float calculateArea(){
		return (float) (Math.pow(this.edge,2));
	}
}

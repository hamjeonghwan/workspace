package kr.or.ddit.creational.factory;

public class FactoryPatternDemo {
	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();
		
		// get an Object fo Circle and Call its draw method.
		Shape shape1 = factory.getShape("CIRCLE");
		shape1.draw();
		
		Shape shape2 = factory.getShape("RECTANGLE");
		shape2.draw();
		
		Shape shape3 = factory.getShape("SQUARE");
		shape3.draw();
				
	}
	
}

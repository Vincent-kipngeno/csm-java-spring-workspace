package tech.csm.firstproject;
import java.util.*;

public class Rectangle {
	private int width;
	private int height;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int returnArea() {
		return width * height;
	}
	
	public int returnPerimeter() {
		return (width + height) * 2;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter width: ");
		int width = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter height: ");
		int height = sc.nextInt();
		sc.nextLine();
		
		Rectangle r = new Rectangle(width, height);
		System.out.println("Area: " + r.returnArea());
		System.out.println("Perimeter: " + r.returnPerimeter());
	}

}

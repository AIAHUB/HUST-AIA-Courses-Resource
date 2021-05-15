import java.util.*;

//����Shape��
class Shape {
  void draw() {}
  void erase() {}
}

//����Circle��
class Circle extends Shape {
  void draw() {
    System.out.println("Calling Circle.draw()");
  }
  void erase() {
    System.out.println("Calling Circle.erase()");
  }
}

//����Square��
class Square extends Shape {
  void draw() {
    System.out.println("Calling Square.draw()");
  }
  void erase() {
    System.out.println("Calling Square.erase()");
  }
}

//����Triangle��
class Triangle extends Shape {
  void draw() {
    System.out.println("Calling Triangle.draw()");
  }
  void erase() {
    System.out.println("Calling Triangle.erase()");
  }
}

//����Pentagon��
class Pentagon extends Shape{
	void draw() {
    	System.out.println("Calling Pentagon.draw()");
  	}
  	void erase() {
    	System.out.println("Calling Pentagon.erase()");
  	}
 }


//����main()�Ĳ�����
public class Shapes_2 {
  
  static void drawOneShape(Shape s){
  	s.draw();
  }
  
  static void drawShapes(Shape[] ss){
  	 for(int i = 0; i < ss.length; i++){
        ss[i].draw();
    }
  }
  	
 public static void main(String[] args) {
  	Random rand = new Random();
    Shape[] s = new Shape[9];
   
    for(int i = 0; i < s.length; i++){
       switch(rand.nextInt(4)) {
       		case 0: s[i] = new Circle();break;
      		case 1: s[i] = new Square();break;
      		case 2: s[i] = new Triangle();break;
      		case 3: s[i] = new Pentagon();break;
       }
	}
            
    drawShapes(s);
   
  }
  
} 

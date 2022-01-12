package Polymorphism.Shapes;

public class Main {
    public static void main(String[] args) {


        Shape shape = new Circle(4);
        Shape shape2 = new Rectangle(13,27);
                
                printFigure(shape);
                printFigure(shape2);
    }

    private static void printFigure(Shape shape) {

        System.out.println(shape.calculateArea());
        System.out.println(shape.calculatePerimeter());
    }
}

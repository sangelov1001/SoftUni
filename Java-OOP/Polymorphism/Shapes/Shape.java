package Polymorphism.Shapes;

public abstract class Shape {

    protected Double perimeter;
    protected Double area;


    public abstract double calculatePerimeter();
    public abstract double calculateArea();


    public Double getPerimeter() {
        return perimeter;
    }

    public Double getArea() {
        return area;
    }
}
package Polymorphism.Shapes;

public class Circle extends Shape {

        private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double calculatePerimeter() {
        if (super.perimeter == null) {
            super.perimeter = 2 * Math.PI * this.radius;
        }
        return super.perimeter;
    }

    @Override
    public double calculateArea() {
        if (super.area == null) {
            super.area = Math.PI * this.radius * this.radius;
        }
        return super.area;
    }
}


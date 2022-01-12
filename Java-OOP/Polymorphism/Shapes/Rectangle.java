package Polymorphism.Shapes;

public class Rectangle extends Shape {

    // правим си променливите final за да може да си гарантираме че винаги ще получаваме стойност за тях и няма да са 0
    private final double width;
    private final double height;

     public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double calculatePerimeter() {
         if (super.perimeter == null) {
             super.perimeter = this.width * 2 + this.height * 2;
         }
        return super.perimeter;
    }

    @Override
    public double calculateArea() {
         if (super.area == null) {
             super.area = this.width * this.height;
         }
        return super.area;
    }
}

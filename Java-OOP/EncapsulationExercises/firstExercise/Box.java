package EncapsulationExercises.firstExercise;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        // тук може с if else да си подсигурим винаги тези полета да НЕ са 0
        // другия вариант е да си направим setter-и в там да им сетваме стойностите
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw  new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    public double calculateVolume() {
        return height * width * length;
    }

    public double calculateLateralSurfaceArea() {
        return  2 * length * height + 2 * width * height;
    }

    public double calculateSurfaceArea() {
        return 2 * (length * width + length * height + width * height);
    }
}

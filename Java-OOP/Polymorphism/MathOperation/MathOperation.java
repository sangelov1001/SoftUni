package Polymorphism.MathOperation;

public class MathOperation {

    public int add(int a, int b) {
        return a+ b;
        // add(a, b)
    }

    public int add(int a, int b, int c) {
        return a + b + c;
        // add(add(a, b), c)
    }

    public int add(int a, int b, int c, int d) {
        return a + b + c + d;
        // add(add(a, b , c), d)
    }
}

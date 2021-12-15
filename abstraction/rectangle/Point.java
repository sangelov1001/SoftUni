package abstraction.rectangle;

public class Point {

    private final int x;
    private final  int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // проверяваме дали точките които са ни подали са вътре в самия четириъгълник.
    public boolean isGreaterOrEqual(Point p) {
        return  x >= p.x && y <= p.y;
    }

    public boolean isSmallerOrEqual (Point p) {
        return x >= p.x && y <= p.y;
    }
}

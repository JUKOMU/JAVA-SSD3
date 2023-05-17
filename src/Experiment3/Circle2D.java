public class Circle2D {
    double x, y, radius;

    public Circle2D() {
        this.x = 0;
        this.y = 0;
        this.radius = 1;
    }

    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public static void main(String[] args) {
        Circle2D c1 = new Circle2D(2, 2, 5.5);
        System.out.println("The area of c1 is " + c1.getArea());
        System.out.println("The getPerimeter of c1 is " + c1.getPerimeter());
        System.out.println("c1.contains(3, 3) is " + c1.contains(3, 3));
        System.out.println("c1.contains(new Circle2D(4, 5, 10.5)) is " + c1.contains(new Circle2D(4, 5, 10.5)));
        System.out.println("c1.overlaps(new Circle2D(3, 5, 2.3)) is " + c1.overlaps(new Circle2D(3, 5, 2.3)));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        double area = radius * radius * Math.PI;
        return area;
    }

    public double getPerimeter() {
        double perimeter = radius * 2 * Math.PI;
        return perimeter;
    }

    public boolean contains(double x, double y) {
        double len = Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
        return len <= radius;
    }

    public boolean contains(Circle2D circle) {
        double len = Math.sqrt((this.x - circle.getX()) * (this.x - circle.getX()) + (this.y - circle.getY()) * (this.y - circle.getY()));
        double s = this.x - circle.getX();
        if (s < 0) {
            s = -s;
        }
        return len <= s;
    }

    public boolean overlaps(Circle2D circle) {
        double len = Math.sqrt((this.x - circle.getX()) * (this.x - circle.getX()) + (this.y - circle.getY()) * (this.y - circle.getY()));
        double s = this.x + circle.getX();
        if (!contains(circle)) {
            return len < s;
        } else {
            return true;
        }
    }
}

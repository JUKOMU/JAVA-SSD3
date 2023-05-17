package Experiment4;

public class Triangle extends GeometricObject{
    private static final double Triangle_side = 1.0;
    private double side1 = Triangle_side;
    private double side2 = Triangle_side;
    private double side3 = Triangle_side;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getArea() {
        double p = (side1 + side2 + side3)/2;
        double area;
        area = Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
        return area;
    }

    public double getPerimeter() {
        return (side1 + side2 + side3);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                ", Perimeter=" + getPerimeter() +
                ", Area=" + getArea() +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                ", dateCreated=" + dateCreated +
                '}';
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        System.out.println(triangle.toString());
        Triangle triangle2 = new Triangle(1,1.5,1);
        triangle2.setColor("yellow");
        triangle2.setFill(true);
        System.out.println(triangle2.toString());
    }
}

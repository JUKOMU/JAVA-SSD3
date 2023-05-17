import java.util.Scanner;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("a=");
        double a = scanner.nextDouble();
        System.out.print("b=");
        double b = scanner.nextDouble();
        System.out.print("c=");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        quadraticEquation.judgeIfHasRoots(a, b, c);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        double discriminant = b * b - 4 * a * c;
        return discriminant;
    }

    public double getRoot1() {
        if (getDiscriminant() < 0) {
            return 0;
        } else {
            double root1 = (Math.sqrt(b * b - 4 * a * c) - b) / (2 * a);
            return root1;
        }
    }

    public double getRoot2() {
        if (getDiscriminant() < 0) {
            return 0;
        } else {
            double root2 = (-(Math.sqrt(b * b - 4 * a * c)) - b) / (2 * a);
            return root2;
        }
    }

    public void judgeIfHasRoots(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if (getDiscriminant() > 0) {
            System.out.println("The discriminant value is " + getDiscriminant());
            System.out.println("root1 = " + getRoot1());
            System.out.println("root2 = " + getRoot2());
        } else if (getDiscriminant() == 0.0) {
            System.out.println("The discriminant value is 0");
            System.out.println("root1 = root2 =" + getRoot1());
        } else {
            System.out.println("The equation has no roots");
        }
    }


}



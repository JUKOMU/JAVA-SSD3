package Practice;

public class Rational extends Number implements Comparable<Rational> {
    long numerator;
    long denominator;

    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Rational(long numerator, long denominator) {
        if (denominator == 0) {
            System.out.println("Invalid denominator");
            return;
        }
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public static long gcd(long n, long d) {
        if (n == 0) return d;
        if (n < d) {
            return gcd(d - n, n);
        }
        return gcd(n - d, d);
    }

    public static void main(String[] args) {
        long r = Rational.gcd(102400, 56);
        System.out.println(r);
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public Rational add(Rational secondRational) {
        Rational result;
        // 分母相同，分子直接相加
        if (this.denominator == secondRational.getDenominator()) {
            result = new Rational(this.numerator + secondRational.getNumerator(), this.denominator);
        } else {
            long newNumerator = this.numerator * secondRational.getDenominator() + this.denominator * secondRational.getNumerator();
            long newDenominator = this.denominator * secondRational.getDenominator();
            result = new Rational(newNumerator, newDenominator);
        }
        return result;
    }

    public Rational subtract(Rational secondRational) {
        Rational result;
        // 分母相同，分子直接相加
        if (this.denominator == secondRational.getDenominator()) {
            result = new Rational(this.numerator - secondRational.getNumerator(), this.denominator);
        } else {
            long newNumerator = this.numerator * secondRational.getDenominator() - this.denominator * secondRational.getNumerator();
            long newDenominator = this.denominator * secondRational.getDenominator();
            result = new Rational(newNumerator, newDenominator);
        }
        return result;
    }

    public Rational multiply(Rational secondRational) {
        Rational result = new Rational(this.numerator * secondRational.getNumerator(), this.denominator * secondRational.getDenominator());
        return result;
    }

    public Rational divide(Rational secondRational) {
        Rational result = new Rational(this.numerator * secondRational.getDenominator(), this.denominator * secondRational.getNumerator());
        return result;
    }

    @Override
    public String toString() {
        if (this.denominator == 1) {
            return "" + this.numerator;
        } else if (this.numerator == this.denominator) {
            return "" + 1;
        } else {
            long n = gcd(this.numerator, this.denominator);
            return "" + this.numerator / n + "/" + this.denominator / n;
        }
    }

    @Override
    public int compareTo(Rational o) {
        if (subtract(o).getNumerator() > 0) {
            return 1;
        } else if (subtract(o).getDenominator() < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public int intValue() {
        int value = (int) (this.getNumerator() / this.getDenominator());
        return value;
    }

    @Override
    public long longValue() {
        long value = (long) (this.getNumerator() / this.getDenominator());
        return value;
    }

    @Override
    public float floatValue() {
        float value = (float) (this.getNumerator() / this.getDenominator());
        return value;
    }

    @Override
    public double doubleValue() {
        double value = (double) (this.getNumerator() / this.getDenominator());
        return value;
    }
}


package istiklal.edu.tr;

public class Rational extends Number implements Comparable<Rational> {
    private long numerator;
    private long denominator;

    public Rational() {
        this(0, 1);
    }

    public Rational(long numerator, long denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Payda sifir olamaz");
        }
        long gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        long sign = denominator > 0 ? 1 : -1;
        this.numerator = sign * numerator / gcd;
        this.denominator = Math.abs(denominator) / gcd;
    }

    private static long gcd(long n, long d) {
        long a = n;
        long b = d;
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a == 0 ? 1 : a;
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public Rational add(Rational secondRational) {
        long n = numerator * secondRational.denominator + denominator * secondRational.numerator;
        long d = denominator * secondRational.denominator;
        return new Rational(n, d);
    }

    public Rational subtract(Rational secondRational) {
        long n = numerator * secondRational.denominator - denominator * secondRational.numerator;
        long d = denominator * secondRational.denominator;
        return new Rational(n, d);
    }

    public Rational multiply(Rational secondRational) {
        long n = numerator * secondRational.numerator;
        long d = denominator * secondRational.denominator;
        return new Rational(n, d);
    }

    public Rational divide(Rational secondRational) {
        long n = numerator * secondRational.denominator;
        long d = denominator * secondRational.numerator;
        return new Rational(n, d);
    }

    @Override
    public int compareTo(Rational o) {
        Rational diff = this.subtract(o);
        if (diff.numerator > 0) {
            return 1;
        } else if (diff.numerator < 0) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Rational)) {
            return false;
        }
        return this.subtract((Rational) other).numerator == 0;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(numerator) * 31 + Long.hashCode(denominator);
    }

    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return numerator + "";
        }
        return numerator + "/" + denominator;
    }
}
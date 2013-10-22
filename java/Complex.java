/**
 * A place holder immutable class
 *
 * - final class
 * - final fields
 * - no mutators
 * - functional: methods return new objects
 * - no need to make defensive copies
 * - no need to provide clone() method or copy constructor
 * - well known immutable instances can be shared freely as public static final constant or
 *   through static factories that caches frequently requested instances
 * - instead of public constructors, we could also have provided private or package-private
 *   constructors with public static factories that returned immutable instances
 *   public static Complex valueOf(double re, double im) {
 *       return new Complex(re, im);
 *   }
 * - instead of making the class final, we could have made each method of the class, but not
 *   the class itself as final. This would allow us to extend the class by adding new methods
 *   built on top of old ones
 */
public final class Complex {
    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE = new Complex(1, 0);
    public static final Complex I = new Complex(0, 1);

    private final double re;
    private final double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double re() {
        return re;
    }

    public double im() {
        return im;
    }

    public Complex add(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex subtract(Complex c) {
        return new Complex(re - c.re, im - c.re);
    }

    public Complex multiply(Complex c) {
        return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
    }

    public Complex divide(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Complex complex = (Complex) o;

        if (Double.compare(complex.im, im) != 0) return false;
        if (Double.compare(complex.re, re) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(re);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(im);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }
}

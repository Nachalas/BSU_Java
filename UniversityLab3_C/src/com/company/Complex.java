package com.company;

public class Complex {
    public Rational real, imaginary;

    public Complex(Rational a, Rational b) {
        real = a;
        imaginary = b;
    }

    public Complex plus(Complex input) {
        Rational finalReal = input.real.plus(real);
        Rational finalImaginary = input.imaginary.plus(imaginary);
        return new Complex(finalReal, finalImaginary);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append(real);
        sb.append(" + i*").append(imaginary);
        return sb.toString();
    }
}

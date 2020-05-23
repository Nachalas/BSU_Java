package com.company;

import java.util.ArrayList;

public class ComplexArray {
    ArrayList<Complex> array = new ArrayList<>();

    public void Append(Complex input) {
        array.add(input);
    }

    public ComplexArray() {
        array.add(new Complex(new Rational(1,2), new Rational(1,2)));
        array.add(new Complex(new Rational(1,2), new Rational(1,2)));
        array.add(new Complex(new Rational(1,2), new Rational(1,2)));
    }

    public ArrayList<Complex> getArray() {
        return array;
    }

    public Complex getSum() {
        Complex finalComplex = new Complex(new Rational(0,1), new Rational(0,1));
        for(var i : array) {
            finalComplex = finalComplex.plus(i);
        }
        return finalComplex;
    }
}

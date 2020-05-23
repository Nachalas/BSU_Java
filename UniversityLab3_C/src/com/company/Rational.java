package com.company;

import static java.lang.StrictMath.abs;

public class Rational {
    public int numerator;
    public int denominator;

    private int findGCD(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b) {
                a %= b;
            }
            else {
                b %= a;
            }
        }
        return a + b;
    }

    public Rational() {
        numerator = 0;
        denominator = 1;
    }

    public Rational(int inputNumerator, int inputDenominator)
    {
        int GCD = findGCD(abs(inputNumerator), abs(inputDenominator));
        denominator = inputDenominator / GCD;
        numerator = inputNumerator / GCD;
        if ((denominator < 0 && numerator > 0) || (denominator < 0 && numerator < 0))
        {
            denominator *= -1;
            numerator *= -1;
        }
        if (numerator == 0)
            denominator = 1;
    }

    public Rational plus(Rational input)
    {
        if (denominator == input.denominator)
        {
            return new Rational(numerator + input.numerator, denominator);
        }
        else
        {
            int new_den = denominator * input.denominator;
            return new Rational(numerator * (new_den / denominator) + input.numerator * (new_den / input.denominator), new_den);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("(");
        sb.append(numerator);
        sb.append("/").append(denominator);
        sb.append(')');
        return sb.toString();
    }
}

package test;

import istiklal.edu.tr.Rational;

import java.util.Scanner;

public class VertexFormEquations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        long a = input.nextLong();
        long b = input.nextLong();
        long c = input.nextLong();
        input.close();

        Rational h = new Rational(-b, 2 * a);
        Rational k = new Rational(4 * a * c - b * b, 4 * a);

        System.out.println("h is " + h + " k is " + k);
    }
}
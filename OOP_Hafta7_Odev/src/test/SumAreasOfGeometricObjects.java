package test;

import istiklal.edu.tr.Circle;
import istiklal.edu.tr.CircleGeometric;
import istiklal.edu.tr.GeometricObjectComparable;
import istiklal.edu.tr.RectangleGeometric;

public class SumAreasOfGeometricObjects {
    public static void main(String[] args) {
        GeometricObjectComparable[] objects = new GeometricObjectComparable[]{
                new CircleGeometric(1),
                new CircleGeometric(2.5),
                new RectangleGeometric(3, 4),
                new RectangleGeometric(5, 2)
        };

        System.out.println("Total area is " + sumArea(objects));
    }

    public static double sumArea(GeometricObjectComparable[] a) {
        double sum = 0;
        for (GeometricObjectComparable object : a) {
            sum += object.getArea();
        }
        return sum;
    }
}

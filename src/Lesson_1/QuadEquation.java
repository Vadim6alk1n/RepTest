package Lesson_1;

import java.util.Scanner;
import java.lang.Math;
public class QuadEquation {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a:");
        System.out.printf("%d",4);
        String s = scanner.next();

        int a = Integer.parseInt(s);
        System.out.println("Enter b");
        s = scanner.next();
        int b = Integer.parseInt(s);
        System.out.println("Enter c");
        s = scanner.next();
        int c = Integer.parseInt(s);
        double d = b*b - 4 * a * c;
        if (d < 0) System.out.println("No roots");
        else if (d == 0)
        {
            System.out.println("x = " + (-b/2*a));
        }
        else
        {
            double x1 = (-b + Math.sqrt(d)) / (2*a);
            double x2 = (-b - Math.sqrt(d)) / (2*a);
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
    }
}
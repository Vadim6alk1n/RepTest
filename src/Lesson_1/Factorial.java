//my changes
// GIT CHANGES SHOULD BE SEEN HERE
package Lesson_1;
import java.util.Scanner;
public class Factorial {
    public static int Factorial(int n)
    {
        if (n<0)
        {
            throw new ArithmeticException("Factorial from negative");
        }
        int res = 1;
        for (int i=1;i<=n;i++)
        {
            res *= i;
        }
        return res;
    }
    public static void main(String args[]) {
        System.out.println("Enter number");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = Integer.parseInt(s);
        int res = 0;
        try {
            res = Factorial(n);
            System.out.println("Factorial of " + n + " is " + res);
        } catch (ArithmeticException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
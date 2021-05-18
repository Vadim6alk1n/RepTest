package tictac;

import java.util.Arrays;
import java.util.Scanner;

public class StackString {
    static class Stack {
        int maxelements;
        String[] array;
        int top;

            public Stack(int max){
                maxelements = max;
                array = new String[max];
                top=0;

            }


    }
    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
         System.out.print("How big stack do you want? -");
         int elements = scan.nextInt();
        Stack stack = new Stack(elements);
        int mmm = 0;
        while (mmm < stack.maxelements) {
            System.out.print("Write stack next element (or write delete) - ");
            String f = scan.next();
            if (!f.equals("delete")) {
                Push(f, stack);

            } else {
                Pop(f, stack);
            }
            System.out.println("Stack size - " + stack.maxelements);
            System.out.println("Stack contains - " + Arrays.toString(stack.array));
            System.out.println("Stack top is - " + stack.top);
        }
    }



    public static void Push (String s, Stack stack) {
        stack.array[stack.top]=s;
        stack.top = stack.top + 1;

    }
    public static void Pop (String s, Stack stack) {
        stack.array[stack.top-1]= null;
        stack.top = stack.top - 1;
    }
}

package tictac;

import java.util.Arrays;
import java.util.Scanner;

public class StackStringvol2 {
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
                System.out.print("Write number item which you want delete - ");
                int del = scan.nextInt();
                Pop(f, del, stack);
            }
            System.out.println("Stack size - " + stack.maxelements);
            System.out.println("Stack contains - " + Arrays.toString(stack.array));
            System.out.println("Stack top is - " + stack.top);

        }
    }



    public static void Push (String s, Stack stack) {
        if (stack.top==stack.maxelements) {
            System.out.println("!!!Error stack is full, please delete some elements!!!");
        } else {
            stack.array[stack.top]=s;
            stack.top = stack.top + 1;
        }

    }
    public static void Pop (String s,int del, Stack stack) {
        stack.array[del-1]= null;
            while (stack.array[del] != null) {
                stack.array[del-1]=stack.array[del];
                stack.array[del]=null;
                del++;
                if (del==stack.maxelements){
                    break;
                }
            }

        stack.top = stack.top - 1;
    }
}

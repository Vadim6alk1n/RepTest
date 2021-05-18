package Lesson_7;

import java.util.ArrayList;

public class MyStack <Type1> {
    ArrayList<Type1> stack_array;
    MyStack(){ stack_array = new ArrayList<>();}
    void push(Type1 e)
    {
        stack_array.add(stack_array.size(),e);
    }
    Type1 pop()
    {
        if (stack_array.size() > 0)
            return stack_array.remove(stack_array.size()-1);
        else
            return null;
    }
    MyStack<Type1> reverse()
    {
        MyStack<Type1> reversed_stack = new MyStack<>();
        for (int i=stack_array.size()-1;i>=0;i--)
        {
            reversed_stack.push(stack_array.get(i));
        }
        return reversed_stack;
    }
}

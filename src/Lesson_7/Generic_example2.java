package Lesson_7;
class GenericArithmetic
{
    static <T extends Number> T sum(T a, T b) throws Exception
    {
        if (a instanceof Integer)
        {
            return (T) new Integer(a.intValue() + b.intValue());
        }
        if (a instanceof Double)
        {
            return (T) new Double(a.doubleValue() + b.doubleValue());
        }
        throw new Exception("Unknown type for arithmetics!");
    }
    static <T extends Number> T multiply(T a, T b) throws Exception
    {
        if (a instanceof Integer)
        {
            return (T) new Integer(a.intValue() * b.intValue());
        }
        if (a instanceof Double)
        {
            return (T) new Double(a.doubleValue() * b.doubleValue());
        }
        throw new Exception("Unknown type for arithmetics!");
    }
    static <T extends Number> T sqrt(T a) throws Exception
    {
        if (a instanceof Integer)
        {
            return (T) new Integer((int)Math.sqrt( a.intValue()));
        }
        if (a instanceof Double)
        {
            return (T) new Double(Math.sqrt( a.doubleValue()));
        }
        throw new Exception("Unknown type for arithmetics!");
    }
}

class Vec2<T extends Number> {

    public T x, y;
    Vec2(T x, T y)
    {
        Set(x,y);
    }
    void Set(T x, T y)
    {
        this.x = x;
        this.y = y;
    }

    void Move(T x, T y)
    {
        try {
            this.x = GenericArithmetic.<T>sum(this.x, x);
            this.y = GenericArithmetic.<T>sum(this.y, y);
        } catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    void Move(Vec2<T> v)
    {
        Move(v.x,v.y);
    }

    T Length()
    {
        T l = null;
        try {
            T lx = GenericArithmetic.<T>multiply(x, x);
            T ly = GenericArithmetic.<T>multiply(y, y);
            l = GenericArithmetic.<T>sum(lx,ly);
            return GenericArithmetic.<T>sqrt(l);
        } catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return l;
    }
}

public class Generic_example2 {
    public static void main(String[] args)
    {
        Vec2<Integer> v1 = new Vec2<Integer>(2,3);
        System.out.println(v1.x + " " + v1.y);

        Vec2<Integer> v2 = new Vec2<Integer>(5,5);
        v2.Move(v1);
        System.out.println(v2.x + " " + v2.y + " " + v2.Length());

        Vec2<Double> v3 = new Vec2<Double>(5.0,5.0);
        Vec2<Double> v4 = new Vec2<Double>(2.0,3.0);
        v3.Move(v4);
        System.out.println(v3.x + " " + v3.y + " " + v3.Length());
    }
}

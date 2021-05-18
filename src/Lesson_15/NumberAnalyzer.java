package Lesson_15;
public class NumberAnalyzer {

    public static int greater(float a, float b)
    {
        return (int)((a + b)/2 + Math.abs(a-b)/2);
    }

    public static float quadraticCalculateX1(float a, float b, float c)
    {
        float d = b*b - 4*a*c;
        return (float)(-b - Math.sqrt(d))/(2*a);
    }
    public static float quadraticCalculateX2(float a, float b, float c)
    {
        float d = b*b - 4*a*c;
        return (float)(-b + Math.sqrt(d))/(2*a);
    }
    public static int fact(int n)
    {
        int r = 1;
        for (int i=1; i<=n;i++) r*=i;
        return r;
    }
    public static int reverse(int n)
    {
        int res = 0;
        for (;n>0;n/=10)
        {
             res= res*10 + n%10;
        }
        return res;
    }

}

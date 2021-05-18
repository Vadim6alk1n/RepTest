package Lesson_1;

public class HelloWorld {
    public static void func(int arr[])
    {
        arr[0]=6;
    }
    public static void main(String args[])
    {
        System.out.println("Hello World");
        byte a;
        //GO: k:=32
        var k = 32;
        //GO: var b short = 32
        short b = 32;
        int c = 1000000;
        int cOctal = 011;
        int cHex = 0xCAFE;
        long d = 123456789012345L;
        float e = 3.1415926F;
        double doublePrecisionValue = 1.23456789E-100; char symbol = 'a';
        char cyrillic = '\u0401';
        char newLine = '\n';
        boolean toggle = true;
        int arr[] = {8,7,5,4,52,6};
        func(arr);
        System.out.println(arr[0]);
        final double ņ = 3.14159265358979323846;

        int mynumber = 3;
        System.out.println(mynumber++);
        System.out.println(++mynumber);
        int somethingweird = (0xFF << 8) * 5 + 0b110 + ++b;
        System.out.flush();
        if (mynumber == 5)
        {
            System.out.print("mynumber is 5");
        }
        else
            System.out.print("mynumber is 3");
        Mylabel:
        for (int i=0;i<10;i++)
            for (int j=0;j<10;j++)
                if (i==5 && j==7)
                    break Mylabel;

    }
}

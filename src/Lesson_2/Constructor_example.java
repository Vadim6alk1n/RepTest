package Lesson_2;

public class Constructor_example {
    private String name;
    public static void main(String args[]) {
        Constructor_example h;

        if (args.length > 0)
            h = new Constructor_example(args);
        else
            h = new Constructor_example("World");
    }
    /**
     * Метод выводит "Hello" и имя в стандартный поток
     вывода
     */
    public void sayHello() {
        System.out.println("Hello, " + name + "!");
    }
    /**
     * Конструктор создает объект с заданным именем
     */

    public Constructor_example(String s) {
        name = s;
        sayHello();
    }
    public Constructor_example(String[] args)
    {
        /**
         * Вызываем конструктор, который принимает String
         */
        this(args[0]);
        for (int i=0; i < args.length; i++)
            System.out.println(i + " argument: " + args[i]);
        Constructor_example h;
        if (args.length > 1) {
            //Убираем первый аргумент и создаем новый Constructor_example
            String[] slice = new String[args.length - 1];
            for (int j = 0; j < slice.length; j++)
                slice[j] = args[j + 1];
            h = new Constructor_example(slice);
        }
    }
}

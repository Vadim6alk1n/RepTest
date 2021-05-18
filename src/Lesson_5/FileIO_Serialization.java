package Lesson_5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee implements java.io.Serializable {
    public String name;
    public int age;
    public double salary;
    public String address;
    public transient Employee manager;
}

class Manager extends Employee implements java.io.Serializable
{
    public transient List<Employee> employees;
    public double someValue;
}

public class FileIO_Serialization {
    public static void Serialize()
    {
        Manager boss = new Manager();
        boss.name = "Vasya Pupkin";
        boss.age = 20;
        boss.salary = 1234.56;
        boss.address = "";
        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.age = 40;
        e.salary = 123.45;
        e.address = "Phokka Kuan, Ambehta Peer";
        e.manager = boss;
        boss.employees = new ArrayList<Employee>();
        boss.employees.add(e);
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("employee.ser");
            ObjectOutputStream out = new
                    ObjectOutputStream(fileOut);
            out.writeObject(boss);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public static void Deserialize()
    {
        Employee e = null;
        Manager m = null;
        try {
            FileInputStream fileIn = new
                    FileInputStream("employee.ser");
            ObjectInputStream in = new
                    ObjectInputStream(fileIn);
            m = (Manager) in.readObject();
            System.out.println("Deserialized Manager...");
            System.out.println("Name: " + m.name);
            System.out.println("Address: " + m.address);
            System.out.println("Age: " + m.age);
            System.out.println("Salary: " + m.salary);
            e = (Employee) in.readObject();
            System.out.println("Deserialized Employee...");
            System.out.println("Name: " + e.name);
            System.out.println("Address: " + e.address);
            System.out.println("Age: " + e.age);
            System.out.println("Salary: " + e.salary);
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
                    c.printStackTrace();
            return;
        }
    }
    public static void main(String[] args)
    {
        Serialize();
        Deserialize();
    }
}

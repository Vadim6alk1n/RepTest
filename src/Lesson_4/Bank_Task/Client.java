package Lesson_4.Bank_Task;

import java.util.ArrayList;

public class Client {
    String name;
    String surname;
    ArrayList<Account> acc;
    public Client(String n,String s)
    {
        name = n;
        surname = s;
        acc = new ArrayList<Account>();
    }
    public void AddAccount(Account newacc)
    {
        //accnr must be equal
        for (Account a: acc)
        {
            if (a.accnr.equals(newacc.accnr))
                return;
        }
        acc.add(newacc);
    }
    @Override
    public String toString()
    {
        return name + " " + surname;
    }
}

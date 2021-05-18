package Lesson_4.Bank_Task;

import java.util.Date;

public class Transaction {
    Account from;
    Account to;
    double amount;
    Date date;

    Transaction(Account f,Account t,double amt, Date date)
    {
        from = f;
        to = t;
        amount = amt;
        this.date = date;
    }
    @Override
    public String toString()
    {
        if (from!=null)
            return date.toString() + ": " + amount + " " + from.accnr + " -> " + to.accnr;
        else
            return date.toString() + ": " + amount + " " + " -> " + to.accnr;
    }
}

package Lesson_4.Bank_Task;

public class Account {
    public String accnr;
    public double amount;
    private static String LastAccNr = "1000000000";
    private Account(){}
    public static Account CreateAccount()
    {
        Account acc = new Account();
        acc.amount = 0;
        try
        {
            int accnr = Integer.parseInt(LastAccNr);
            accnr++;
            LastAccNr = new Integer(accnr).toString();
        }catch (Exception e){}
        acc.accnr = LastAccNr;
        return acc;
    }
    @Override
    public String toString()
    {
        return accnr + " " + amount;
    }
}

package Lesson_4.Bank_Task;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Bank_System {
    public static void main(String[] args)
    {
        Bank bank = new Bank();
        Client client;
        client = new Client("Vasya","Pupkin");
        var acc = Account.CreateAccount();
        client.AddAccount(acc);
        client.AddAccount(Account.CreateAccount());
        bank.AddClient(client);
        client = new Client("John","Smith");
        client.AddAccount(Account.CreateAccount());
        bank.AddClient(client);
        bank.ClientList();
        Date date;
        Date date2;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse("22/02/2021");
            date2 = new SimpleDateFormat("dd/MM/yyyy").parse("21/02/2021");
        } catch (Exception e)
        {
            e.printStackTrace();
            return;
        }
        bank.AddTransaction(new Transaction(acc,client.acc.get(0),50,date));
        bank.AddTransaction(new Transaction(null,client.acc.get(0),50,date2));
        bank.ClientTransactionReport(client);
    }
}

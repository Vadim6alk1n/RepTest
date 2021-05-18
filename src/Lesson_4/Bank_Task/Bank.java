package Lesson_4.Bank_Task;

import java.util.ArrayList;

public class Bank {
    ArrayList<Client> clients;
    ArrayList<Transaction> transactions;
    public Bank()
    {
        clients = new ArrayList<Client>();
        transactions = new ArrayList<Transaction>();
    }
    public void AddClient(Client newclient)
    {
        //client must be unique
        for (Client c: clients)
        {
            if (c.name.equals(newclient.name) &&
                    c.surname.equals(newclient.surname))
                return;
        }
        clients.add(newclient);
    }
    public void AddTransaction(Transaction newtr)
    {
        transactions.add(newtr);
    }
    public void ClientTransactionReport(Client c)
    {
        System.out.println("Client Transaction Report: " + c.name + " " + c.surname);
        for (Account a : c.acc)
        {
            ClientAccountReport(a);
        }
    }
    public void ClientAccountReport(Account a)
    {
        String accnr = a.accnr;
        for (Transaction tr : transactions)
        {
            if (tr.to.accnr.equals(accnr) || ((tr.from != null) && (tr.from.accnr.equals(accnr))) )
            {
                System.out.println(tr);
            }
        }
    }
    public void ClientList()
    {
        for (Client c : clients)
        {
            System.out.println(c);
            for (Account a : c.acc)
            {
                System.out.println(a);
            }
        }
    }
}

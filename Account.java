import java.util.*;
public class Account {

    private int id;
    private String customerName;
    private double balance;
    private Date dateCreated;
    private Transactions listOfTransactions;


    // member methods
    public Account(){
        id = 0;
        customerName = "n/a";
        balance = 0;
        dateCreated = new Date();

        listOfTransactions = new Transactions();
    }

    public Account(int i, String n, double b){
        if(!SetId(i)){
            System.out.println("Incorrect value for id, setting to default value (0).");
            id = 0;
        }

        SetName(n);

        if(!SetBalance(b)){
            System.out.println("Incorrect value for balance, setting to default (0).");
            balance = 0;
        }
        dateCreated = new Date();

        listOfTransactions = new Transactions();
    }

    public int GetId(){
        return id;
    }
    public boolean SetId(int newId){
        if(newId >= 0){
            id = newId;
            return true;
        }
        else{
            System.out.println("Id must be non-negative");
            return false;
        }
    }

    public String GetName(){
        return customerName;
    }
    public void SetName(String s){
        customerName = s;
    }

    public double GetBalance(){
        return balance;
    }
    public boolean SetBalance(double newBalance){
        if(newBalance >= 0){
            balance = newBalance;
            return true;
        }
        else{
            System.out.println("Balance cannot be set to a negative amount.");
            return false;
        }
    }

    public Date GetDateCreated(){
        return dateCreated;
    }

    public Transactions GetTransactions(){
        return listOfTransactions;
    }
    public void Withdraw(double amount){
        if(amount <= balance){
            System.out.println("You have successfuly withdrawn $" + amount);
            balance -= amount;

            String s = "\nWithdraw. Transaction Amount: " + amount + ", date: " + new Date() + 
            ". Final balance: $" + balance;

            listOfTransactions.Add(s);
        }
        else{
            System.out.println("Insufficient funds, try again.");
        }
    }

    public void Deposit(double amount){
        if(!IsValidAmount(amount)){
            System.out.println("Invalid amount. Cannot be non-positive. Try again.");
        }
        else{
            System.out.println("Successfully deposited $" + amount + ".");
            balance += amount;

            String s = "\nDeposit. Transaction Amount: " + amount + ", date: " + new Date() + 
            ". Final balance: $" + balance;

            listOfTransactions.Add(s);
        }
    }


    public String toString(){
        String s = "Id: " + id + ", Name: " + customerName +
        ", Balance: $" + balance + ", Date Created: " + GetDateCreated();

        
        return s;
    }

    private boolean IsValidAmount(double amount){
        if(amount >= 0){
            return true;
        }
        else{
            return false;
        }

    }
    
    @Override
    public boolean equals(Object ob){
        if(GetId() == ((Account)ob).GetId()){
            return true;
        }
        else{
            return false;
        }
    }
}

/**
 * CheckingAccount
 */
public class CheckingAccount extends Account {

    // every checking account inherits id, name, balance, dateCreated
    // properties from its parent (Account)

    private final double feePerTransaction;

    public CheckingAccount(){
        super(); // calling the parent class's default constructor
        feePerTransaction = 1.5;
    }

    public CheckingAccount(int _id, String n, double bal){
        super(_id, n, bal); // calling super class's defined constructor
        feePerTransaction = 1.5; 
    }

    public double GetFeePerTransaction(){

        return feePerTransaction;

    }

    @Override
    public String toString(){

        String s = super.toString() + ",\nAccount type: Checking Account, Fee Per Transaction: " +
        feePerTransaction + ".";

        Transactions t = GetTransactions();
        s += t.GetAllTransactions();

        return s;

    }


    @Override
    public void Withdraw(double amount){
        super.Withdraw(amount + feePerTransaction);
    }

    @Override
    public void Deposit(double amount){
        super.Deposit(amount - feePerTransaction);
    }
    
    
}

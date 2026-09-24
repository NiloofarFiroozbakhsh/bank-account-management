public class SavingsAccount extends Account {

    private double annualInterestRate;
    // this is in percentage, for example 2.5% interest rate is set as 2.5
    // for annulaInterestRate

    SavingsAccount(){
        super();
        annualInterestRate = 0.0;        
    }

    SavingsAccount(int _id, String _name, double _balance, double aIR){
        super(_id, _name, _balance);
        if(!SetAnnualInterestRate(aIR)){
            System.out.println("Invalid annual interest rate, setting to default 0.0");
            annualInterestRate = 0.0;
        }
    }

    public boolean SetAnnualInterestRate(double val){
        if(val < 0){
            System.out.println("Annual Interest Rate cannot be negative.");
            return false;
        }
        else{
            annualInterestRate = val;
            return true;
        }
    }

    public double GetAnnualInterestRate(){
        return annualInterestRate / 100;
    }

    public double GetMonthlyInterestRate(){
        return annualInterestRate / 1200;
    }

    public double GetMonthlyInterest(){
        return GetMonthlyInterestRate() * super.GetBalance();
    }

    public double GetAnnualInterest(){
        return GetMonthlyInterest() * 12.0;
    }

    @Override
    public String toString(){
        String s = super.toString() + ".\nAnnual Interest Rate: " + annualInterestRate + 
        "%, Annual Interest: $" + GetAnnualInterest() + ".";

        Transactions t = GetTransactions();
        s += t.GetAllTransactions();


        return s;
    }
    
}

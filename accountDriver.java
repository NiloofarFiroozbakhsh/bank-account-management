public class accountDriver  {

    public static int RandInt(int lowerLimit, int upperLimit) {
        int range;

        range = upperLimit - lowerLimit + 1;

        return (int)(Math.random() * range) + lowerLimit;
    }

    public static Account[] GenerateRandomAccounts(int n){
        // create an array of Accounts of size n
        Account[] arr = new Account[n];

        for(int i = 0; i < arr.length; i++){
            int randomBalance = RandInt(0, 1000);
            arr[i] = new Account(i+1, "abc", randomBalance);
        }

        return arr;
    }


    public static void main(String[] args) {
//or Account-->
        

        // Account[] accounts = new Account[1000000]; // an array of parent type

        // accounts[0] = new CheckingAccount(123, "abc", 100);
        // accounts[1] = new SavingsAccount(45, "de", 100, 2.5);
        // accounts[2] = new Account(678, "some name", 200);
        // ...

        // for(int i = 0; i < accounts.length; i++){
        //     System.out.println("\n---\n"+accounts[i]+"\n---\n");
        // }
        
        // CheckingAccount acc;
        // Account a = new Account(123, "sdsdfdsf", 100);

        // acc = (CheckingAccount)a;

        // System.out.println(acc);

        Account[] arr = new Account[10];

        for(int i = 0; i < arr.length; i++){
            int x = RandInt(0, 1);
            if(x == 0){
                arr[i] = new CheckingAccount(i+1, "abc", 100);
            }
            else{
                arr[i] = new SavingsAccount(i+1, "def", 200, 1.25);
            }
        }

        for(int i  = 0; i < arr.length; i++){
            arr[i].Deposit(100);
            arr[i].Deposit(100);
            arr[i].Withdraw(50);
            arr[i].Deposit(100);
            arr[i].Withdraw(50);
        }

        for(int i  =0; i < arr.length; i++){
            System.out.println("\n---\n");
            System.out.println(arr[i]);
        }

        // for(int i = 0; i < arr.length; i++){
        //     if(arr[i] instanceof SavingsAccount){
        //         SavingsAccount s = (SavingsAccount) arr[i];
        //         s.SetAnnualInterestRate(2.25);
        //     }
        // }

        // System.out.println("AFTER");
        // for(int i  =0; i < arr.length; i++){
        //     System.out.println("\n---\n");
        //     System.out.println(arr[i]);
        // }

        SavingsAccount c1 = new SavingsAccount(100, "abc", 1, 1.25);
        SavingsAccount c2 = new SavingsAccount(100, "abc", 1, 1.25);

        if(c1.equals(c2)){
            System.out.println("same");
        }
        else{
            System.out.println("not same");
        }

    }
    
}

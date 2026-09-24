import java.util.ArrayList;

public class Transactions {

    private ArrayList<String> transactions;

    public Transactions(){
        transactions = new ArrayList<String>();
    }

    public void Add(String newTransaction){
        transactions.add(newTransaction);
    }

    public String GetAllTransactions(){
        String s = "";
        for(int i = 0; i < transactions.size(); i++){
            s += transactions.get(i) + "\n";
        }
        return s;
    }
    
}

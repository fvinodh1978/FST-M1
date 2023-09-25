package activities;

public class BankAccount {
    private int balance;

    public void initialise(int initialBalance){
        balance=initialBalance;
    }

    public String withdraw(int amount){
        if(amount>balance){
            throw new InsufficientFundException(amount, balance);
        }
        balance-=amount;
        return "Withdrawn " + amount + ", Balance : " + balance;
    }

    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        ba.initialise(100);
        String msg="";
        msg= ba.withdraw(5);
        msg= ba.withdraw(95);
        msg= ba.withdraw(95);
        System.out.println(msg);
    }
}

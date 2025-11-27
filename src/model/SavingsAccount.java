package model;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber,double balance){
        super(accountNumber,balance);
    }

    @Override
    public void withdraw(double amount){
        if(balance>=amount){
            balance=balance-amount;
            System.out.println("Transaction successful. New balance: "+balance+"₺");
        }else{
            throw new IllegalArgumentException("Insufficient funds");
        }
    }
    @Override
    public String toString(){
        return "Savings Account -> Balance: "+balance;
    }
}

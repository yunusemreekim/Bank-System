package model;

public abstract class BankAccount {
    protected String accountNumber;
    protected double balance;
    BankAccount(String accountNumber,double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

    public String getAccountNumber(){return accountNumber;}
    public double getBalance(){return balance;}
    public void deposit(double amount){
        balance=balance+amount;
    }
    public abstract void withdraw(double amount);


}

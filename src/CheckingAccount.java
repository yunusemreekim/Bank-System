public class CheckingAccount extends BankAccount{
    double overdraftLimit=500.0;
    CheckingAccount(String accountNumber,double balance){
        super(accountNumber,balance);
    }

    @Override
    public void withdraw(double amount){
        if(balance+overdraftLimit>=amount){
            balance=balance-amount;
            System.out.println("İşlem başarılı. Yeni bakiye: "+balance+"₺");
        }else {
            throw new IllegalArgumentException("Transaction declined! (Overdraft limit exceeded)");
        }
    }
    @Override
    public String toString(){
        return "Checking Account -> Balance: "+balance;
    }
}

package model;

public class Admin extends Person {
    public Admin(String id,String name,String password){
        super(name, id,password);
    }

    public void displayUserReport(User user){
        System.out.println("\n--- ADMIN REPORT: " + user.name + " ---");
        for(BankAccount account: user.getAccounts()){
            System.out.println("Account Number: " + account.getAccountNumber() + " | Balance: " + account.getBalance());
        }
        System.out.println("------------------------------");
    }


    @Override
    public void showRole(){
        System.out.println("Role: ADMIN - "+this.name);
    }
}

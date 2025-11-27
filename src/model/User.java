package model;

import java.util.ArrayList;
import java.util.List;

public class User extends Person {
    private List<BankAccount> myAccounts;
    public User(String name,String id,String password){
        super(name,id,password);
        this.myAccounts=new ArrayList<>();
    }

    public void addAccount(BankAccount account){
        myAccounts.add(account);
        System.out.println("Hesabınız başarı ile eklenmiştir");
    }

    public List<BankAccount> getAccounts(){
        return myAccounts;
    }

    @Override
    public String toString(){
        return "ID: "+id+" - Name: "+name;
    }

    @Override
    public void showRole(){
        System.out.println("Role: USER - "+this.name);
    }
}
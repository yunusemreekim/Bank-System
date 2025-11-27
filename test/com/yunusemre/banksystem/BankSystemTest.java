package com.yunusemre.banksystem;

import model.CheckingAccount;
import model.SavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankSystemTest {

    @Test
    void testSavingsWithdrawSuccess(){
        SavingsAccount savingsAccount=new SavingsAccount("TR-TEST-1",2000);
        savingsAccount.withdraw(500);

        assertEquals(1500,savingsAccount.getBalance(),"Balance should be 1500.0 after withdrawal.");
    }

    @Test
    void testSavingsOverdraftFailure(){
        SavingsAccount savingsAccount=new SavingsAccount("TR-TEST-2",200);
        Exception e=assertThrows(IllegalArgumentException.class,() ->{savingsAccount.withdraw(250);});

        assertTrue(e.getMessage().contains("Insufficient funds"),"Exception message should indicate insufficient funds.");
    }

    @Test
    void testCheckingOverdraftSuccess(){
        CheckingAccount checkingAccount=new CheckingAccount("TR-TEST-2",100);
        checkingAccount.withdraw(200);

        assertEquals(-100,checkingAccount.getBalance(),"Checking account should be able to go into overdraft (negative balance).");
    }

    @Test
    void testDeposit(){
        SavingsAccount savingsAccount=new SavingsAccount("TR-TEST-4",100);
        savingsAccount.deposit(400);

        assertEquals(500,savingsAccount.getBalance(),"Balance should reflect the deposited amount.");
    }
}

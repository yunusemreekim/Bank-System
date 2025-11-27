# 🏦 Console Banking System

A robust, menu-driven banking application developed in Java. This project demonstrates core Object-Oriented Programming (OOP) principles, clean code architecture, and user session management.

## 🚀 Overview

The **Console Banking System** simulates a real-world banking environment where users can open accounts, deposit/withdraw money, and view transaction history. It features a dual-role system (model.Admin & model.User) with distinct functionalities and secure login simulation.

## 🛠️ Tech Stack & Concepts

* **Language:** Java 
* **Testing:** JUnit 5
* **Paradigm:** Object-Oriented Programming (OOP)
* **Key Concepts Used:**
    * **Inheritance:** `model.Person` base class for `model.User` and `model.Admin`. `model.BankAccount` base class for `Checking` and `Savings`.
    * **Polymorphism:** Handling different account types (`model.CheckingAccount`, `model.SavingsAccount`) via a common `model.BankAccount` reference.
    * **Abstraction:** Abstract classes for shared behaviors.
    * **Encapsulation:** Protected/Private fields with controlled access.
    * **Exception Handling:** `try-catch` blocks for robust input validation.
    * **Collections:** `ArrayList` for dynamic data management.

## 📂 Project Structure

he project follows a professional directory structure separating logic, data, and tests:

```text
src
 └── com
      └── yunusemre
           └── banksystem
                ├── Main.java              # Entry Point
                ├── service
                │    └── BankManager.java  # Business Logic
                └── model                  # Data Classes
                     ├── User.java
                     ├── Admin.java
                     ├── BankAccount.java
                     └── ...
test
 └── com
      └── yunusemre
           └── banksystem
                └── BankSystemTest.java    # JUnit Tests
```                
## 🧪 Testing & Quality Assurance
This project includes Unit Tests to ensure the reliability of
financial transactions. Below is a sample from the test suite
demonstrating the withdrawal logic verification:
```  
@Test
void testSavingsOverdraftFailure() {
    // Scenario: Trying to withdraw more than the balance from a Savings Account
    SavingsAccount savings = new SavingsAccount("TR-TEST-1", 100.0);
    
    // Expectation: The system should throw an exception preventing the transaction
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        savings.withdraw(150.0);
    });

    // Verify the error message
    assertTrue(exception.getMessage().contains("Insufficient funds"));
}
```  
## ✨ Features

### 👨‍💼 model.Admin Module
* **Secure Login:** Pre-defined admin credentials.
* **model.User Management:** Create new users with ID, Name, and Password.
* **Reporting:** View detailed reports of specific users (Total balance, account list).
* **System Monitoring:** List all registered users.

### 👤 model.User Module
* **Account Creation:** Open multiple accounts (Checking or Savings).
* **Dynamic Account Numbers:** Automatically generated unique account identifiers (e.g., TR-4521).
* **Transactions:**
    * **Deposit:** Add funds to any selected account.
    * **Withdraw:** Withdraw funds with validation (Savings: No overdraft, Checking: Overdraft limit).
* **Portfolio View:** View all owned accounts and their real-time balances.

## ⚙️ How to Run

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/your-username/banking-system.git](https://github.com/your-username/banking-system.git)
    ```
2.  **Navigate to the project directory:**
    ```bash
    cd banking-system
    ```
3.  **Compile the source code:**
    ```bash
    javac Main.java
    ```
4.  **Run the application:**
    ```bash
    java Main
    ```

## 🔮 Future Improvements

* [ ] Implement **File I/O** or **Database (JDBC)** to persist user data after exit.
* [ ] Add a money transfer feature between users.
* [ ] Implement a graphical user interface (GUI) with JavaFX.

---
## Author
**YUNUS EMRE EKİM**
- Computer Engineering Student at **Istanbul Medeniyet University**
- Focus: Data Structures, Algorithms, and Java Development
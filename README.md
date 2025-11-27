# 🏦 Console Banking System

A robust, menu-driven banking application developed in Java. This project demonstrates core Object-Oriented Programming (OOP) principles, clean code architecture, and user session management.

## 🚀 Overview

The **Console Banking System** simulates a real-world banking environment where users can open accounts, deposit/withdraw money, and view transaction history. It features a dual-role system (Admin & User) with distinct functionalities and secure login simulation.

## 🛠️ Tech Stack & Concepts

* **Language:** Java 
* **Paradigm:** Object-Oriented Programming (OOP)
* **Key Concepts Used:**
    * **Inheritance:** `Person` base class for `User` and `Admin`. `BankAccount` base class for `Checking` and `Savings`.
    * **Polymorphism:** Handling different account types (`CheckingAccount`, `SavingsAccount`) via a common `BankAccount` reference.
    * **Abstraction:** Abstract classes for shared behaviors.
    * **Encapsulation:** Protected/Private fields with controlled access.
    * **Exception Handling:** `try-catch` blocks for robust input validation.
    * **Collections:** `ArrayList` for dynamic data management.

## 📂 Project Structure

* **Main.java:** Entry point of the application.
* **BankManager.java:** Handles the core business logic and UI flow (Facade Pattern approach).
* **Person.java (Abstract):** Base class for all system actors.
* **User.java / Admin.java:** Concrete implementations of actors.
* **BankAccount.java (Abstract):** Base class for financial accounts.
* **CheckingAccount.java / SavingsAccount.java:** Concrete account types with specific withdrawal rules.

## ✨ Features

### 👨‍💼 Admin Module
* **Secure Login:** Pre-defined admin credentials.
* **User Management:** Create new users with ID, Name, and Password.
* **Reporting:** View detailed reports of specific users (Total balance, account list).
* **System Monitoring:** List all registered users.

### 👤 User Module
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
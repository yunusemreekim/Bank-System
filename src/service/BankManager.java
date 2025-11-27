package service;

import model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random; // Rastgele hesap no için eklendi
import java.util.Scanner;

public class BankManager {
    // Değişkenler sınıfın alanları (fields) olarak kalır
    private List<User> userList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Admin admin = new Admin("ADM-001", "admin", "admin123");

    // TÜM MANTIK BU METODUN İÇİNE TAŞINDI
    public void run() {
        while (true) {
            System.out.println("\n------ BANK SYSTEM ------");
            System.out.println("1. model.Admin Login");
            System.out.println("2. model.User Login");
            System.out.println("0. Exit");
            System.out.print("Choose an option between 0-2: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Buffer temizleme

                switch (choice) {
                    case 1: // ADMIN LOGIN
                        handleAdminLogin();
                        break;

                    case 2: // USER LOGIN
                        handleUserLogin();
                        break;

                    case 0:
                        System.out.println("Exiting system. Goodbye!");
                        return; // Metottan çıkar, program biter.
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Invalid input! Please enter a number");
                scanner.nextLine(); // Hatalı girdiyi temizle
            }
        }
    }

    // Kodun okunabilirliği için model.Admin işlemlerini ayrı metoda böldüm
    private void handleAdminLogin() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (username.equals(admin.getName()) && password.equals(admin.getPassword())) {
            boolean adminSession = true;
            while (adminSession) {
                System.out.println("\n--- ADMIN MENU ---");
                System.out.println("1. Create model.User");
                System.out.println("2. Display model.User Report");
                System.out.println("3. Show Role");
                System.out.println("4. Print model.User List");
                System.out.println("0. Back");
                System.out.print("Choose an option: ");

                try {
                    int choice_admin = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice_admin) {
                        case 1:
                            System.out.print("model.User's name: ");
                            String uName = scanner.nextLine();
                            System.out.print("model.User's password: ");
                            String uPass = scanner.nextLine();
                            System.out.print("model.User's ID: ");
                            String uId = scanner.nextLine();
                            userList.add(new User(uName, uId, uPass));
                            System.out.println("model.User created successfully!");
                            break;
                        case 2:
                            System.out.print("Enter model.User ID to report: ");
                            String idInput = scanner.nextLine();
                            boolean found = false;
                            for (User u : userList) {
                                if (u.getId().equals(idInput)) {
                                    admin.displayUserReport(u);
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) System.out.println("model.User not found!");
                            break;
                        case 3:
                            admin.showRole();
                            break;
                        case 4:
                            if (userList.isEmpty()) System.out.println("No users yet.");
                            for (User u : userList) {
                                System.out.println(u);
                            }
                            break;
                        case 0:
                            adminSession = false;
                            break;
                        default:
                            System.out.println("Invalid option.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.nextLine();
                }
            }
        } else {
            System.out.println("Wrong model.Admin credentials!");
        }
    }

    // model.User işlemlerini de ayrı metoda böldüm (Temiz Kod Prensibi)
    private void handleUserLogin() {
        System.out.print("Username: ");
        String usernameI = scanner.nextLine();
        System.out.print("Password: ");
        String passwordI = scanner.nextLine();

        User foundUser = null;
        for (User u : userList) {
            if (u.getName().equals(usernameI) && u.getPassword().equals(passwordI)) {
                foundUser = u;
                break;
            }
        }

        if (foundUser != null) {
            System.out.println("Welcome " + foundUser.getName());
            boolean userSession = true;
            while (userSession) {
                System.out.println("\n--- USER MENU ---");
                System.out.println("1. Add Account");
                System.out.println("2. My Accounts Info");
                System.out.println("3. Deposit Money");
                System.out.println("4. Withdraw Money");
                System.out.println("5. Show Role");
                System.out.println("0. Back");
                System.out.print("Choose an option: ");

                try {
                    int choice_user = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice_user) {
                        case 1:
                            System.out.println("1. Add Checking Account");
                            System.out.println("2. Add Savings Account");
                            String accType = scanner.nextLine();

                            // Rastgele hesap numarası üretimi
                            String randomAccNo = "TR-" + (1000 + new Random().nextInt(9000));

                            if (accType.equals("1")) {
                                foundUser.addAccount(new CheckingAccount(randomAccNo, 0));
                                System.out.println("Checking Account added. No: " + randomAccNo);
                            } else if (accType.equals("2")) {
                                foundUser.addAccount(new SavingsAccount(randomAccNo, 0));
                                System.out.println("Savings Account added. No: " + randomAccNo);
                            } else {
                                System.out.println("Invalid selection.");
                            }
                            break;

                        case 2:
                            for(BankAccount account:foundUser.getAccounts()){
                                System.out.println(account);
                            }
                            break;

                        case 3: // Deposit
                            if (foundUser.getAccounts().isEmpty()) {
                                System.out.println("No accounts found.");
                                break;
                            }
                            foundUser.getAccounts();
                            System.out.print("Select account index (0, 1...): ");
                            int depIdx = scanner.nextInt();
                            if (depIdx >= 0 && depIdx < foundUser.getAccounts().size()) {
                                System.out.print("Amount to deposit: ");
                                double amount = scanner.nextDouble();
                                foundUser.getAccounts().get(depIdx).deposit(amount);
                            } else {
                                System.out.println("Invalid index.");
                            }
                            break;

                        case 4: // Withdraw
                            if (foundUser.getAccounts().isEmpty()) {
                                System.out.println("No accounts found.");
                                break;
                            }
                            foundUser.getAccounts();
                            System.out.print("Select account index (0, 1...): ");
                            int wIdx = scanner.nextInt();
                            if (wIdx >= 0 && wIdx < foundUser.getAccounts().size()) {
                                System.out.print("Amount to withdraw: ");
                                double amount = scanner.nextDouble();
                                foundUser.getAccounts().get(wIdx).withdraw(amount);
                            } else {
                                System.out.println("Invalid index.");
                            }
                            break;

                        case 5:
                            foundUser.showRole();
                            break;

                        case 0:
                            userSession = false;
                            break;
                        default:
                            System.out.println("Invalid option.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("ERROR: Invalid input! Please enter a number");
                    scanner.nextLine();
                }
            }
        } else {
            System.out.println("Username or password is incorrect.");
        }
    }
}

import java.util.Scanner;

class BankApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfAccounts = sc.nextInt();
        Bank[] bankAccounts = new Bank[numberOfAccounts];
        for (int i = 0; i < numberOfAccounts; i++) {
            System.out.println("Enter Bank Name: ");
            String bankName = sc.nextLine();
            System.out.println("Enter User Id: ");
            int userId = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter User Name: ");
            String userName = sc.nextLine();
            System.out.println("Enter Account Number: ");
            long accountNumber = sc.nextLong();
            sc.nextLine();
            System.out.println("Enter Account Type: ");
            String accountType = sc.nextLine();
            System.out.println("Enter Opening Balance: ");
            double openingBalance = sc.nextDouble();

            bankAccounts[i] = new Bank(bankName, userId, userName, accountNumber, accountType, openingBalance);

        }

        do {
            System.out.println();
            System.out.println("===============Menu================");
            System.out.println();
            System.out.println("1. Display Complete Details");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Summary");
            System.out.println("6. Check Minimum Balance");
            System.out.println("0. Exit");
            System.out.println();
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i <= numberOfAccounts - 1; i++) {
                        bankAccounts[i].displayCompleteDetails();
                    }
                    break;
                case 2:
                    System.out.println("Enter Account Number: ");
                    long accountNumber = sc.nextLong();
                    sc.nextLine();
                    Bank selectedAccount = null;
                    for (int i = 0; i <= numberOfAccounts - 1; i++) {
                        if (bankAccounts[i].matchesAccountNumber(accountNumber)) {
                            selectedAccount = bankAccounts[i];
                            break;
                        }
                    }
                    if (selectedAccount == null) {
                        System.out.println("Account not found.");
                        break;
                    }
                    System.out.println("Enter the amount you want to deposit: ");
                    double amount = sc.nextDouble();
                    boolean res = selectedAccount.deposit(amount);
                    if (res) {
                        System.out.println("Amount deposited successfully");
                        System.out.println("Updated Balance:" + selectedAccount.checkBalance());
                    } else {
                        System.out.println("Deposit Failed");
                    }
                    break;
                case 3:
                    System.out.println("Enter Account Number: ");
                    accountNumber = sc.nextLong();
                    sc.nextLine();
                    selectedAccount = null;
                    for (int i = 0; i <= numberOfAccounts - 1; i++) {
                        if (bankAccounts[i].matchesAccountNumber(accountNumber)) {
                            selectedAccount = bankAccounts[i];
                            break;
                        }
                    }
                    if (selectedAccount == null) {
                        System.out.println("Account not found.");
                        break;
                    }
                    System.out.println("Enter the amount you want to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    boolean res2 = selectedAccount.withdraw(withdrawAmount);
                    if (res2) {
                        System.out.println("Amount withdrawn successfully");
                        System.out.println("Updated Balance: " + selectedAccount.checkBalance());
                    } else {
                        System.out.println("Withdrawal Failed");
                    }
                    break;
                case 4:
                    System.out.println("Enter Account Number: ");
                    accountNumber = sc.nextLong();
                    sc.nextLine();
                    selectedAccount = null;
                    for (int i = 0; i <= numberOfAccounts - 1; i++) {
                        if (bankAccounts[i].matchesAccountNumber(accountNumber)) {
                            selectedAccount = bankAccounts[i];
                            break;
                        }
                    }
                    if (selectedAccount == null) {
                        System.out.println("Account not found.");
                        break;
                    }
                    double balance = selectedAccount.checkBalance();
                    System.out.println("Current Balance: " + balance);
                    break;
                case 5:
                    System.out.println("Enter Account Number: ");
                    accountNumber = sc.nextLong();
                    sc.nextLine();
                    selectedAccount = null;
                    for (int i = 0; i <= numberOfAccounts - 1; i++) {
                        if (bankAccounts[i].matchesAccountNumber(accountNumber)) {
                            selectedAccount = bankAccounts[i];
                            break;
                        }
                    }
                    if (selectedAccount == null) {
                        System.out.println("Account not found.");
                        break;
                    }
                    String summary = selectedAccount.createAccountSummary();
                    System.out.println(summary);
                    break;
                case 6:
                    System.out.println("Enter Account Number: ");
                    accountNumber = sc.nextLong();
                    sc.nextLine();
                    selectedAccount = null;
                    for (int i = 0; i <= numberOfAccounts - 1; i++) {
                        if (bankAccounts[i].matchesAccountNumber(accountNumber)) {
                            selectedAccount = bankAccounts[i];
                            break;
                        }
                    }
                    if (selectedAccount == null) {
                        System.out.println("Account not found.");
                        break;
                    }
                    System.out.println("Enter Minimum Balance: ");
                    double minimumBalance = sc.nextDouble();
                    boolean result = selectedAccount.hasMinimumBalance(minimumBalance);
                    if (result == true) {
                        System.out.println("Minimum balance is maintained");
                    } else {
                        System.out.println("Minimum balance is not maintained");
                    }
                    break;
                case 0:
                    System.out.println("Thank you for using our banking service. Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again with a valid number between 1 to 6");
                    break;
            }
            if (choice == 0) {
                break;
            }
        } while (true);

        sc.close();
    }
}

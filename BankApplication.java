
import java.util.Scanner;

class BankApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

        Bank bank = new Bank(bankName, userId, userName, accountNumber, accountType, openingBalance);
        bank.displayBankDetails();
        bank.displayUserDetails();
        bank.displayAccountDetails();
        System.out.println("Account Summary");
        String summary = bank.createAccountSummary();
        System.out.println(summary);
        System.out.println("Enter Minimum Balance: ");
        double minimumBalance = sc.nextDouble();
        boolean result = bank.hasMinimumBalance(minimumBalance);
        if (result == true) {
            System.out.println("Minimum balance is maintained");
        } else {
            System.out.println("Minimum balance is not maintained");
        }
        sc.close();
    }
}

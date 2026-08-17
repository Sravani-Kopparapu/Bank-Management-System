
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
        do {
            System.out.println();
            System.out.println("===============Menu================");
            System.out.println();
            System.out.println("1. Display Bank Details");
            System.out.println("2. Display User Details");
            System.out.println("3. Display Account Details");
            System.out.println("4. Display Account Summary");
            System.out.println("5. Check if Minimum Balance is Maintained");
            System.out.println("6. Exit");
            System.out.println();
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    bank.displayBankDetails();
                    break;
                case 2:
                    bank.displayUserDetails();
                    break;
                case 3:
                    bank.displayAccountDetails();
                    break;
                case 4:
                    String summary = bank.createAccountSummary();
                    System.out.println(summary);
                    break;
                case 5:
                    System.out.println("Enter Minimum Balance: ");
                    double minimumBalance = sc.nextDouble();
                    boolean result = bank.hasMinimumBalance(minimumBalance);
                    if (result == true) {
                        System.out.println("Minimum balance is maintained");
                    } else {
                        System.out.println("Minimum balance is not maintained");
                    }
                    break;
                case 6:
                    System.out.println("Thank you for using our banking service. Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again with a valid number between 1 to 6");
                    break;
            }
            if (choice == 6) {
                break;
            }
        } while (true);

        sc.close();
    }
}

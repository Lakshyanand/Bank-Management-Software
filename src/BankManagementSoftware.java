import java.util.Scanner;

class BankData {

    public int customerId;
    public String name;

    private int accountBalance = 0;

    private int lastTransaction = 0;

    public BankData(String name,int id) {
        this.name = name;
        this.customerId = id;
    }

    public void accountDetails()
    {
        System.out.println("Account Holder Name: "+this.name);
        System.out.println("Customer Id: "+this.customerId);
        System.out.println("Account Balance: "+this.accountBalance);
    }
    public void depositMoney(int amount)
    {
        if(amount > 0)
        {
            this.lastTransaction = amount;
            this.accountBalance = this.accountBalance + amount;
        }

    }

    public void withdrawMoney(int amount)
    {
        if(amount > 0 && amount < this.accountBalance)
        {
            this.lastTransaction = amount;
            this.accountBalance = this.accountBalance - amount;
        }
    }

    public int checkLastTransaction()
    {
        return this.lastTransaction;
    }
}

public class BankManagementSoftware {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.next();
        System.out.println("Enter your customer id: ");
        int customerId = sc.nextInt();

        BankData bank = new BankData(name,customerId);

        while(true) {
            System.out.println();
            System.out.println("What do you want to do: ");
            System.out.println("choose from the below");
            System.out.println("1 for account details");
            System.out.println("2 for depositing money");
            System.out.println("3 for withdrawing money");
            System.out.println("4 for knowing previous transaction");
            System.out.println("5 for exit");

            int choice = sc.nextInt();

            if(choice == 5)
            {
                System.out.println("bye bye");
                break;
            }

            switch (choice) {
                case 1 -> bank.accountDetails();
                case 2 -> {
                    System.out.println("enter the amount: ");
                    int depositAmount = sc.nextInt();
                    bank.depositMoney(depositAmount);
                    System.out.println("Thank you for using our bank services");
                }
                case 3 -> {
                    System.out.println("enter the amount: ");
                    int withdrawAmount = sc.nextInt();
                    bank.withdrawMoney(withdrawAmount);
                    System.out.println("Thank you for using our bank services");
                }
                case 4 -> {
                    System.out.println("Your last transaction amount is " + bank.checkLastTransaction());
                    System.out.println("Thank you for using our bank services");
                }
                default -> System.out.println("Please enter a valid option");
            }
        }
    }
}

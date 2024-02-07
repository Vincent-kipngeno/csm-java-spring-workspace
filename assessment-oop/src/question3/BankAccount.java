package question3;
import java.util.*;

public class BankAccount {
	private String depositorName;
	private String depositorAddress;
	private String accountType;
	private double accountBal;
	private int noTransactions;
	private String accountNo;
	public static int depositorsCount = 1000;
	
	public BankAccount(String name, String address, String accountType, double accountBal) {
		this.accountNo = generateAccNo();
		this.depositorName = name;
		this.depositorAddress = address;
		this.accountType = accountType;
		this.accountBal = accountBal;
		this.noTransactions = 0;
	}
	
	public String generateAccNo() {
		return "BA" + depositorsCount++;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public void displayDepositorInfo() {
		System.out.println(
				"Name: " + depositorName + "\n" +
				"Address: " + depositorAddress + "\n" +
				"Account Type: " + accountType + "\n" +
				"Account number: " + accountNo + "\n" +
				"Account Bal: " + accountBal + "\n" +
				"No. of Transactions: " + noTransactions
				);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(accountBal, accountNo, accountType, depositorAddress, depositorName, noTransactions);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		return Double.doubleToLongBits(accountBal) == Double.doubleToLongBits(other.accountBal)
				&& Objects.equals(accountNo, other.accountNo) && Objects.equals(accountType, other.accountType)
				&& Objects.equals(depositorAddress, other.depositorAddress)
				&& Objects.equals(depositorName, other.depositorName) && noTransactions == other.noTransactions;
	}

	public void deposit(double amount) {
		if(amount <= 0) {
			System.out.println("You cannot deposit -ve amount.");
		}
		else {
			this.accountBal += amount;
			this.noTransactions++;
			System.out.println("Deposit successful.");
		}
	}
	
	public void withdraw(double amount) {
		if((accountBal - amount) < 0) {
			System.out.println("Insufficient funds.");
		}
		else {
			this.accountBal -= amount;
			this.noTransactions++;
			System.out.println("Withdrawal successful.");
		}
	}
	
	public void changeAddress(String address) {
		this.depositorAddress = address;
		System.out.println("Address changed successfully.");
	}
	
	public int getNoOfTransactions() {
		return noTransactions;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of depositors: ");
        int numberOfDepositors = scanner.nextInt();

        BankAccount[] accounts = new BankAccount[numberOfDepositors];

        for (int i = 0; i < numberOfDepositors; i++) {
            scanner.nextLine();
            System.out.println("\nEnter information for depositor " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("Type of Account: ");
            String typeOfAccount = scanner.nextLine();
            System.out.print("Balance: $");
            double balance = scanner.nextDouble();

            accounts[i] = new BankAccount(name, address, typeOfAccount, balance);
        }

        System.out.print("\nEnter the index of the depositor to display information: ");
        int indexToDisplay = scanner.nextInt();
        if (indexToDisplay >= 0 && indexToDisplay < numberOfDepositors) {
            accounts[indexToDisplay].displayDepositorInfo();
        } else {
            System.out.println("Invalid index. No depositor found.");
        }

        System.out.print("\nEnter the index of the depositor to deposit money: ");
        int indexToDeposit = scanner.nextInt();
        if (indexToDeposit >= 0 && indexToDeposit < numberOfDepositors) {
            System.out.print("Enter the amount to deposit: $");
            double depositAmount = scanner.nextDouble();
            accounts[indexToDeposit].deposit(depositAmount);
            accounts[indexToDeposit].displayDepositorInfo();
        } else {
            System.out.println("Invalid index. No depositor found.");
        }

        System.out.print("\nEnter the index of the depositor to withdraw money: ");
        int indexToWithdraw = scanner.nextInt();
        if (indexToWithdraw >= 0 && indexToWithdraw < numberOfDepositors) {
            System.out.print("Enter the amount to withdraw: $");
            double withdrawAmount = scanner.nextDouble();
            accounts[indexToWithdraw].withdraw(withdrawAmount);
            accounts[indexToWithdraw].displayDepositorInfo();
        } else {
            System.out.println("Invalid index. No depositor found.");
        }

        System.out.print("\nEnter the index of the depositor to change the address: ");
        int indexToChangeAddress = scanner.nextInt();
        if (indexToChangeAddress >= 0 && indexToChangeAddress < numberOfDepositors) {
            scanner.nextLine();
            System.out.print("Enter the new address: ");
            String newAddress = scanner.nextLine();
            accounts[indexToChangeAddress].changeAddress(newAddress);
            accounts[indexToChangeAddress].displayDepositorInfo();
        } else {
            System.out.println("Invalid index. No depositor found.");
        }

        System.out.print("\nEnter the number of random processes to repeat: ");
        int numberOfRandomProcesses = scanner.nextInt();
        for (int i = 0; i < numberOfRandomProcesses; i++) {
            int randomIndex = (int) (Math.random() * numberOfDepositors);
            int randomProcess = (int) (Math.random() * 3) + 2;

            switch (randomProcess) {
                case 2:
                    System.out.println("\nRandom Deposit Process:");
                    System.out.print("Enter the amount to deposit: $");
                    double randomDepositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    accounts[randomIndex].deposit(randomDepositAmount);
                    accounts[randomIndex].displayDepositorInfo();
                    break;
                case 3:
                    System.out.println("\nRandom Withdraw Process:");
                    System.out.print("Enter the amount to withdraw: $");
                    double randomWithdrawAmount = scanner.nextDouble();
                    scanner.nextLine();
                    accounts[randomIndex].withdraw(randomWithdrawAmount);
                    accounts[randomIndex].displayDepositorInfo();
                    break;
                case 4:
                    System.out.println("\nRandom Change Address Process:");
                    System.out.print("Enter the new address: ");
                    String randomNewAddress = scanner.nextLine();
                    accounts[randomIndex].changeAddress(randomNewAddress);
                    accounts[randomIndex].displayDepositorInfo();
                    break;
            }
        }

        int totalTransactions = 0;
        for (BankAccount account : accounts) {
            totalTransactions += account.getNoOfTransactions();
        }
        System.out.println("\nTotal Number of Transactions: " + totalTransactions);

        scanner.close();
    }

}

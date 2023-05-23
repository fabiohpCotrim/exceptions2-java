package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {

			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.next();
			String name = sc.nextLine();
			System.out.print("Initial balance: ");
			Double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double limit = sc.nextDouble();
			Account acc = new Account(number, name, balance, limit);

			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();

			acc.withdraw(amount);
			System.out.printf("New balance: %.2f", acc.getBalance());
		} 
		catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} 
		catch (RuntimeException e) {
			System.out.println("An unexpected error has ucurred");
		}

		sc.close();

	}

}

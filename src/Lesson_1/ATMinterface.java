package Lesson_1;

import java.util.Scanner;
import java.text.DecimalFormat;

public class ATMinterface {
	public static void main(String[] args) {
		Scanner ScannerObj = new Scanner(System.in);
		
		printMainMenu();
		
		boolean working = true;

		DecimalFormat df = new DecimalFormat("###.##");
		
		float balance = 500.59f;
		
		while (working){
			String userInput = ScannerObj.nextLine();
			boolean run = true;
			switch (userInput){
			case "a": 
				System.out.println("Your balance is: "+  df.format(balance)+ "$");
				System.out.println("To get back enter \"back\".");			
				break;
				
			case "b": 
				System.out.print("Enter amount how much you want to withdraw: ");
				balance = withdrawing(balance);
				/*	while (run) {
						
						Float withdrawAmount = ScannerObj.nextFloat();
						if (withdrawAmount > balance) {
							System.out.println("Not enough money to withdraw.");
							run = false;
						}else if (withdrawAmount == 0){
							System.out.println("Incorrect amount");
							
						}else {
							balance = balance - withdrawAmount;
							System.out.println("Here you are!");
							run = false;
						}
					}
					System.out.println("To get back enter \"back\".");
				*/
				break;
			
			case "c":
				System.out.print("Enter how much you want to deposit: ");
				
				while (run) {
					Float depositAmount = ScannerObj.nextFloat();
					if (depositAmount == 0) {
						System.out.println("Incorrect amount");
					} else {
						balance = balance + depositAmount;
						System.out.println("You have made a deposit of "+depositAmount + " dollars.");
						run = false;
					}
				}
				System.out.println("To get back enter \"back\".");
				break;
			case "d":
				System.out.println("To get back enter \"back\".");
				break;
				
			case "e": 
				System.out.print("Enter how long do you want to store your money(years): ");
				int years = ScannerObj.nextInt();
				float balanceFuture = balance*0.045f*years + balance; 
				System.out.println("Your balance in "+ years + " years will be "+df.format(balanceFuture) +"$");
				
				System.out.println("To get back enter \"back\".");
				break;
				
			case "f":
				System.out.println("Goodbye!!!");
				return;
				
				
			case "back":printMainMenu();
				break;
				
			}
		} 
		ScannerObj.close();
	}

	public static float withdrawing(float balance)  {

		Scanner ScannerObj = new Scanner(System.in);
		boolean run = true;
		while (run) {

			Float withdrawAmount = ScannerObj.nextFloat();
			if (withdrawAmount > balance) {
				System.out.println("Not enough money to withdraw.");

				run = false;
			}else if (withdrawAmount == 0){
				System.out.println("Incorrect amount");

			}else {
				balance = balance - withdrawAmount;
				System.out.println("Here you are!");
				run = false;
			}
		}
		return balance;
	}
	
	public static void printMainMenu() {
		System.out.println("Choose options:");
		System.out.println("A - View Balance");
		System.out.println("B - Withdraw Funds");
		System.out.println("C - Deposit Funds");
		System.out.println("D - Last Transactions");
		System.out.println("E - Annual Funds");
		System.out.println("F - Exit");
	}
 
}

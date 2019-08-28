package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int numCustomers, numPurchased, numItems;
		double itemCost, totalCost;
		String fname, lname;
		String[] customerTotals;
		
		//Find the number of customers that the program needs 
		//to account for
		numCustomers = scan.nextInt();
		
		//create an appropriately sized array to store the information
		//that will be outputted at the end of the program
		customerTotals = new String[numCustomers];
		
		//totals up the purchase amount for all customers
		for(int i = 0; i < numCustomers; i++) {
			//gets input containing the customer's name and number of items purchased
		
			//stores the first letter of the first name
			fname = Character.toString(scan.next().charAt(0));
			lname = scan.next();
			numItems = scan.nextInt();
			
			totalCost = 0.0;
			
			for(int j = 0; j < numItems; j++) {
				//retrieve and store the number and cost of the items purchased
				numPurchased = scan.nextInt();
				
				//skip over the name of the item since it is not important
				scan.next();
				itemCost = scan.nextDouble();
				
				totalCost += numPurchased * itemCost;
			}
			
			customerTotals[i] = fname + ". " + lname + ": " + String.format("%.2f", totalCost);
			
		}
		
		//print out all of the customer information
		for(String customer : customerTotals) {
			System.out.println(customer);
		}
		
		scan.close();
		
	}
	
	
}

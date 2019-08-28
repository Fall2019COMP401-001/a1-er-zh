package a1;

import java.util.Scanner;
import java.util.HashMap;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int inventorySize, numCustomers, numPurchased;
		HashMap<String, Double> inventory;
		HashMap<String, Double> custTotals;
		String fname, lname, fullname;
		double totalCost;
		
		inventorySize = scan.nextInt();
		
		inventory = new HashMap<String, Double>(inventorySize);
		
		for(int i = 0; i < inventorySize; i++) {
			//store the item name as the key and the price as the value
			//the inventory hashmap is used to calculate the total amount spent
			//by each customer
			inventory.put(scan.next(), scan.nextDouble());
		}

		
		numCustomers = scan.nextInt();
		
		custTotals = new HashMap<String, Double>(numCustomers);
		
		for(int i = 0; i < numCustomers; i++) {
			
			fname = scan.next();
			lname = scan.next();
			
			//combines the first and last name of the customer
			//the customer's fullname will be the key holding their total spent
			fullname = fname + " " + lname;
			numPurchased = scan.nextInt();
			
			//the for loop calculates the total amount spent by each customer
			totalCost = 0.0;
			for(int j = 0; j < numPurchased; j++) {
				//retrieve the cost of the item and multiply it by it cost
				totalCost += scan.nextInt() * inventory.get(scan.next());
			}
			
			custTotals.put(fullname, totalCost);
			
		}
		
		/* find the maximum spent, minimum spent, and the average amount spent 
		 * per customer, by iterating over all keys in the list
		 */
		
		String minkey = null;
		String maxkey = null;
		int numEntries = custTotals.keySet().size();
		double avgSpent = 0;
		
		for(String key : custTotals.keySet()){
			//sets minkey if it is null
			//finds the key associated with the smallest value in the hashmap
			if(minkey == null || 
					custTotals.get(minkey) > custTotals.get(key)) {
				//since java short circuits the or operator, get(minkey) won't
				//be called if minkey is null
				minkey = key;
			}
			
			//sets maxkey if it is null
			//finds the key associated with the largest value in the hashmap
			if(maxkey == null ||
					custTotals.get(maxkey) < custTotals.get(key)) {
				maxkey = key;
			}
			
			avgSpent += custTotals.get(key);
		}
		
		avgSpent = avgSpent / numEntries;
		
		//display the results
		System.out.println("Biggest: " + maxkey + 
				" (" + String.format("%.2f", custTotals.get(maxkey)) + ")");
		System.out.println("Smallest: "+ minkey + 
				" (" + String.format("%.2f", custTotals.get(minkey)) + ")");
		System.out.println("Average: " + String.format("%.2f", avgSpent));
		
		scan.close();
	}
}

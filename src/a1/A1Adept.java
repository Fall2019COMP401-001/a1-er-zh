package a1;

import java.util.Scanner;
import java.util.HashMap;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int inventorySize, numCustomers, numPurchased;
		HashMap<String, Double> inventory;
		HashMap<String, Double> custTotals;
		String custInfo, fname, lname, fullname;
		double totalCost;
		
		inventorySize = scan.nextInt();
		scan.nextLine();
		
		inventory = new HashMap<String, Double>(inventorySize);
		
		for(int i = 0; i < inventorySize; i++) {
			//gets the item's name and price in a line, splits, then stores that
			//information in an array
			String[] itemInfo = scan.nextLine().split("\\s");
			
			inventory.put(itemInfo[0], Double.parseDouble(itemInfo[1]));
		}

		
		numCustomers = scan.nextInt();
		scan.nextLine();
		
		custTotals = new HashMap<String, Double>(numCustomers);
		
		for(int i = 0; i < numCustomers; i++) {
			custInfo = scan.nextLine();
			
			System.out.println(custInfo);
			
			Scanner infostr = new Scanner(custInfo);
			
			fname = infostr.next();
			lname = infostr.next();
			
			fullname = fname + " " + lname;
			numPurchased = infostr.nextInt();
			
			totalCost = 0.0;
			
			for(int j = 0; j < numPurchased; j++) {
				totalCost += infostr.nextDouble() * inventory.get(infostr.next());
			}
			
			custTotals.put(fullname, totalCost);
			
			infostr.close();
		}
		
		System.out.println(inventory.toString());
		System.out.println(custTotals.toString());
		
		scan.close();
	}
}

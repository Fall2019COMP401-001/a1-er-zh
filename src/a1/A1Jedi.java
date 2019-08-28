package a1;

import java.util.HashMap;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int inventorySize, numCustomers;
		
		//store the item name as the key
		//The value associated with it is an array where
		//array[0] = number of customers that purchased the item
		//array[1] = number of items purchased
		HashMap<String, Integer[]> inventory;
		
		//keeps an list of the items in the order that they are inputted
		String[] inventoryOrdered;
		String itemName;
		
		inventorySize = scan.nextInt();
		
		inventory = new HashMap<String, Integer[]>(inventorySize);
		inventoryOrdered = new String[inventorySize];
		
		//initializes a hashmap representing the item inventory with
		//the names of the items and an empty array
		for(int i = 0; i < inventorySize; i++) {
			Integer[] temp = {0, 0};
			itemName = scan.next();
			inventory.put(itemName, temp);
			inventoryOrdered[i] = itemName;
			
			//skip the cost of the item
			scan.nextDouble();
		}
		
		numCustomers = scan.nextInt();
		int numItems, numPurchased;
		String itemKey;
		
		for(int i = 0; i < numCustomers; i++) {
			
			//skip over the first and last name of the customer
			scan.next();
			scan.next();
			
			numItems = scan.nextInt();
			
			//the for loop adds the number of items purchased
			for(int j = 0; j < numItems; j++) {
				numPurchased = scan.nextInt();
				itemKey = scan.next();
				
				Integer[] temp = inventory.get(itemKey);
				temp[0]++;
				temp[1] += numPurchased;
				inventory.put(itemKey, temp);
			}
						
		}
		
		//print the results of the program
		for(String key : inventoryOrdered) {
			if (inventory.get(key)[0] == 0) {
				System.out.print("No");
			}
			else {
				System.out.print(inventory.get(key)[0]);
			}
			
			System.out.print(" customers bought ");
			
			if(inventory.get(key)[1] != 0) {
				System.out.print(inventory.get(key)[1] + " ");
			}
			
			System.out.println(key);
			
		}
		
		scan.close();
	}
}

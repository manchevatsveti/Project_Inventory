package inventory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProjectTester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int menuChoice;
		
		int maxSize=getNumProducts(in);
		if(maxSize ==0) {
			System.out.println("No products required!");
		}else {
			Product[] products = new Product[maxSize];
			addToInventory(products, in);
	        do {
	        	menuChoice = getMenuOption(in);
	        	executeMenuChoice(menuChoice, products, in);
	        }while(menuChoice!=0);
	}
}
	public static void executeMenuChoice(int menuChoice, Product[]products,Scanner in) {
		switch(menuChoice) {
		case 1:
			System.out.println("View product list");
			displayInventory(products);
			break;
		case 2: 
			System.out.println("Add stock");
			addInventory(products, in);
			break;
		case 3:
			System.out.println("Deduct stock");
			deductInventory(products, in);
			break;
		case 4:
			System.out.println("Discontinue stock");
			discontinueInventory(products, in);
		}	
	}
	public static void discontinueInventory(Product[]products,Scanner in) {
		int productChoice;
		productChoice=getProductNumber(products, in);
		System.out.println("Type true to activate.");
		System.out.println("Type false to discontinue.");
		boolean active = in.nextBoolean();
		products[productChoice].setActive(active);
	}
	public static void deductInventory(Product[]products,Scanner in) {
		int productChoice;
		int updateValue=-1;
		productChoice=getProductNumber(products, in);
		System.out.println("How many products do you want deduct?");
		updateValue=in.nextInt();
		while(updateValue<0 || updateValue>products[productChoice].getQtyInStock()) {
			System.out.println("Please enter a valid value.");
			updateValue=in.nextInt();
		}
		products[productChoice].deductFromInventory(updateValue);
		
	}
	public static void addInventory(Product[]products,Scanner in) {
		int productChoice;
		int updateValue=-1;
		productChoice=getProductNumber(products, in);
		System.out.println("How many products do you want to add?");
		updateValue=in.nextInt();
		while(updateValue<0) {
			System.out.println("Please enter a valid value.");
			updateValue=in.nextInt();
		}
		products[productChoice].addToInventory(updateValue);
		
	}
	public static int getProductNumber(Product[]products,Scanner in) {
		int productChoice=-1;

		for(int i=0;i<products.length;i++) {
			System.out.println(i+ ": " + products[i].getName());
		}
		System.out.println("Enter product index");
		productChoice=in.nextInt();
		while(productChoice<0 || productChoice>products.length) {
			System.out.println("Please enter a valid index.");
			productChoice=in.nextInt();
		}
		return productChoice;
	}
	public static int getMenuOption(Scanner in) {
		System.out.println("1. View Inventory");
		System.out.println("2. Add Stock");
		System.out.println("3. Deduct Stock");
		System.out.println("4. Discontinue Product");
		System.out.println("0. Exit");
		System.out.println("Please enter a menu option: ");
		int op = in.nextInt();
		while(op<0 || op>4) {
			System.out.println("Please enter a valid option.");
			op=in.nextInt();
		}
		return op;
	}
	public static void displayInventory(Product[]products) {
		 for(Product product: products)
	        	System.out.println(product);
	}
	public static void addToInventory(Product[]products,Scanner in) {
		int stockChoice = -1;
	
	        for(int i = 0; i<products.length; i++) {
	        	System.out.println("1: CD");
	    		System.out.println("2: DVD");
	    		System.out.println("Please enter the product type: ");
	    		stockChoice=in.nextInt();
	        		
	    		while(stockChoice!=1 & stockChoice!=2) {
	    			System.out.println("Only numbers 1 or 2 allowed!");
	    			stockChoice=in.nextInt();
	    		}	
	    	switch (stockChoice) {
			case 1:
				addCDToInventory(products, in, i);
				break;
			case 2:
				addDVDToInventory(products, in, i);
				}
	        }
	}
	public static void addCDToInventory(Product[]products,Scanner in,int i) {
		int tempNumber;
		String tempName;
		int tempQty;
		double tempPrice;
		String tempArtist;
		int tempSongs;
		String tempLabel;
	
	       
	        	in.nextLine();
	    		System.out.print("\nPlease enter the CD name: ");
	    		tempName = in.nextLine();
	    		System.out.print("Please enter the artist name: ");
	    		tempArtist=in.next();
	    		System.out.print("Please enter the record label name: ");
	    		tempLabel=in.next();
	    		System.out.print("Please enter the number of songs: ");
	    		tempSongs=in.nextInt();
	    		System.out.print("Please enter the quantity of stock for this product: ");
	    		tempQty = in.nextInt();
	    		System.out.print("Please enter the price for this product: ");
	    		tempPrice = in.nextDouble();
	    		System.out.print("Please enter the item number: ");
	    		tempNumber = in.nextInt();
	    		products[i] = new CD(tempNumber, tempName, tempQty, tempPrice,tempArtist,tempSongs, tempLabel);
	        	
	}
	public static void addDVDToInventory(Product[]products,Scanner in,int i) {
		int tempNumber;
		String tempName;
		int tempQty;
		String tempStudio;
		int tempAgeRating;
		int tempLenght;
		double tempPrice;
	
	      
	        	in.nextLine();
	    		System.out.print("\nPlease enter the DVD name: ");
	    		tempName = in.nextLine();
	    		System.out.print("Please enter the film studio name: ");
	    		tempStudio=in.next();
	    		System.out.print("Please enter the age rating: ");
	    		tempAgeRating=in.nextInt();
	    		System.out.print("Please enter the lenght in minutes: ");
	    		tempLenght=in.nextInt();
	    		System.out.print("Please enter the quantity of stock for this product: ");
	    		tempQty = in.nextInt();
	    		System.out.print("Please enter the price for this product: ");
	    		tempPrice = in.nextDouble();
	    		System.out.print("Please enter the item number: ");
	    		tempNumber = in.nextInt();
	    		products[i] = new DVD(tempNumber, tempName,tempQty, tempPrice,tempLenght,tempAgeRating, tempStudio);
	        	
	}
	public static int getNumProducts(Scanner in) {
		int maxSize=-1;
		do {
			try{	
				System.out.println("Enter the number of products you would like to add.");
				System.out.print("Enter 0 (zero) if you do not wish to add products: ");
				
				maxSize = in.nextInt();	
				if(maxSize<0)
					System.out.println("Incorrect Value entered");
			}
			catch(InputMismatchException e) {
				System.out.println("Incorrect data type entered!");
				in.nextLine();
			}
			catch(Exception e){
				System.out.println(e);
				in.nextLine();
			}
		}while(maxSize<0);
		return maxSize;
	}

	
}


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import extras.DoughType;
import extras.FillingType;
import extras.FrostingType;
import extras.ToppingType;

// test method for bakery

public class BakeryTest {
	
	public static void main(String[] args) {
		System.out.println("Enter the number for the item you would like to purchase... \n1. Donut \n2. Cake \n3. Cookie \n4. Bread  \n5. to exit");
		Scanner sc = new Scanner(System.in);
		int item = sc.nextInt();
		List<Item> items = new ArrayList<>();
		while(item!= 5) {
			switch(item) {
			
			case 1: 
				// when donut is selected, offer choices
				System.out.println("What filling would you like? \n1. None \n2. Strawberry \n3. Raspberry \n4. Boston cream");
				int fill = sc.nextInt();
				FillingType fillingType = selectFillingType(fill);
				System.out.println("What frosting would you like? \n1. None \n2. Chocolate \n3. Vanilla \n4. Glaze");
				int frost = sc.nextInt();
				FrostingType frostingType = selectFrostingType(frost);
				System.out.println("What topping would you like? \n1. None \n2. Chocolate Chips \n3. Sprinkles \n4. Nuts");
				int top = sc.nextInt();
				ToppingType topping = selectToppingType(top);
				Item toBake = new DonutWithTopping( new DonutWithFrosting(new DonutWithFilling(new Donut(), fillingType), frostingType), topping);
				System.out.println(toBake.bake());
				items.add(toBake);
				break;
				
			case 2:
				// when cake is selected, offer choices
				System.out.println("What frosting would you like? \n1. None \n2. Chocolate \n3. Vanilla ");
				frost = sc.nextInt();
				frostingType = selectFrostingType(frost);
				System.out.println("What topping would you like? \n1. None \n2. Chocolate Chips \n3. Sprinkles \n4. Nuts");
				top = sc.nextInt();
				topping = selectToppingType(top);
				toBake = new CakeWithTopping( new CakeWithFrosting(new Cake(), frostingType), topping);
				System.out.println(toBake.bake());
				items.add(toBake);
				break;
				
			case 3:
				// when cookie is selected, offer choices
				System.out.println("What frosting would you like? \n1. None \n2. Chocolate \n3. Vanilla ");
				frost = sc.nextInt();
				frostingType = selectFrostingType(frost);
				System.out.println("What topping would you like? \n1. None \n2. Chocolate Chips \n3. Sprinkles \n4. Nuts");
				top = sc.nextInt();
				topping = selectToppingType(top);
				toBake = new CookieWithTopping(new CookieWithFrosting(new Cookie(), frostingType), topping);
				items.add(toBake);
				break;
				 
			case 4:
				// when bread is selected, offer choices
				System.out.println("What dough would you like? \n1. White \n2. Sour \n3. Rye \n4. Wheat" );
				int dt = sc.nextInt();
				DoughType doughType = selectDoughType(dt);
				toBake = new SpecialBread(new Bread(), doughType);
				items.add(toBake);
				break;
			default:
				break;
			
			}
						
			// check if user wants to add additional items to the order
			System.out.println("Would you like any additional items? Yes/No");
			String choice = sc.next();
			if(choice.equalsIgnoreCase("No")){
				break; // if no, calculate final bill 
			}
			
			System.out.println("Enter the number for the item you would like to purchase... \n1. Donut \n2. Cake \n3. Cookie \n4. Bread  \n5. to exit");
			item = sc.nextInt();
		}
		
		// print out items with decorators as well as the cost of each and final bill
		Double cost = 0.0;
		System.out.println("Items in list:");
		for(Item order: items){
			System.out.println("Item: " + order.bake() + " -- (Cost: $" + order.cost() + ")");
			cost += order.cost();
		}
		System.out.println("Total Cost: $" + cost);
		
	}

	// topping selections
	private static ToppingType selectToppingType(int top) {
		ToppingType topping = ToppingType.NONE; // default
		switch(top){
		case 1:
			topping = ToppingType.NONE;
			break;
		case 2:
			topping = ToppingType.CHOCOLATECHIPS;
			break;
		case 3:
			topping = ToppingType.SPRINKLES;
			break;
		case 4:
			topping = ToppingType.NUTS;
			break;
		}
		return topping;
	}

	// frosting selections
	private static FrostingType selectFrostingType(int frost) {
		FrostingType fr = FrostingType.NONE; // default
		switch(frost){
		case 1:
			fr = FrostingType.NONE;
			break;
		case 2:
			fr = FrostingType.CHOCOLATE;
			break;
		case 3:
			fr = FrostingType.VANILLA;
			break;
		case 4:
			fr = FrostingType.GLAZE;
			break;
		}
		return fr;
	}

	//filling selections
	private static FillingType selectFillingType(int fill) {
		FillingType ft = FillingType.NONE; // default
		switch(fill){
		case 1:
			ft = FillingType.NONE;
			break;
		case 2:
			ft = FillingType.STRAWBERRY;
			break;
		case 3:
			ft = FillingType.RASPBERRY;
			break;
		case 4:
			ft = FillingType.BOSTONCREAM;
			break;
		}
		return ft;
	}

	// dough selections
	private static DoughType selectDoughType(int dt) {
		DoughType dough = DoughType.WHITE; // default
		switch(dt){
		case 1: 
			dough = DoughType.WHITE;
			break;
		case 2:
			dough = DoughType.SOUR;
			break;
		case 3: 
			dough = DoughType.RYE;
			break;
		case 4:
			dough = DoughType.WHEAT;
			break;
		}
		return dough;
	}

}
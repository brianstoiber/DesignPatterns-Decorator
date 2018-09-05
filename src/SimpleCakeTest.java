import extras.FillingType;
import extras.FrostingType;
import extras.ToppingType;

public class SimpleCakeTest {

	public static void main(String[] args) {
		// Simple illustration for Cake classes alone.

		CakeWithFrosting cake = new CakeWithFrosting(new Cake(), FrostingType.GLAZE);
		// In the above code, the Cake object is passed to ItemDecorator as Item using the super() call in constructor.
		// 	public CakeWithFrosting(Item item, FrostingType frost){
		//		super(item); -> this would be stored in ItemDecorator as the protected member
		//		this.frost = frost; -> This is stored in CakeWithFrosting object.
		//	}
		//  
		//   Cake object
		//       |
		//       |
		//   passed as constructor argument to CakeWithFrosting
		//       |
		//       |
		//   passed to ItemDecorator and saved as the protected Item object.
		//
		//   FrostingType.GLAZE
		//       |
		//       |
		//   passed as constructor argument to CakeWithFrosting
		//       |
		//       |
		//   saved as private member
		

		System.out.println(cake.bake());
		// the above cake.bake() would call bake() defined in CakeWithFrosting defined as follows
		// 	@Override
		//		public String bake() {
		//			return super.bake() + " + Frosting: " + frost.name();
		//		}
		// Note that the @Override method ensures that only the Derieved class method is executed and not the base class.
		// In base class ItemDecorator, we call item.bake(). This should invoke the corresponding method in Cake object as
		// the protected member Item. So, in order to get the output in order, we call super.bake() in the overriding method.
		//
		// CakeWithFrosting.bake() => ItemDecorator.bake() => Cake.bake()
		//     (Executes last)                               (Executes First)
		
		// output should be: 
		// Plain Cake + Frosting: GLAZE
		
		System.out.println(cake.cost());
		// Same logic as above. For simplicity, we have added Double constants as the cost
		// for each type of cake. 
		// 	@Override
		//  public Double cost() {
		//		if(frost == FrostingType.NONE)// excluding additional cost for default values
		//			return super.cost();
		//		return super.cost() + 5.0;
		// 	}
		// We can modify the cost calculation depending on each type of frosting and use a switch-case statement
		// to reflect the change in cost according to the type of frosting selected.
		// Output should be :
		// 5.0 (of Cake) + 5.0 (of CakeWithFrosting) = 10.0

		// Let us consider another example:
		// Let us create another cake - strawberry filled cake with nutties on top:
		Item newCake = new CakeWithTopping(new CakeWithFilling(new Cake(), FillingType.STRAWBERRY), ToppingType.NUTS);
		//  Here, object hierarchy ( item type ) will be as follows:
		//  Cake (protected Item item for the superclass of CakeWithFilling)
		//    |
		//    |
		//  CakeWithFilling
		//    |
		//    |
		//  CakeWithTopping => This is Item newCake here.
		
		System.out.println(newCake.bake());
		// CakeWithTopping.bake() => ItemDecorator.bake() => CakeWithFilling.bake() => ItemDecorator.bake() => Cake.bake()
		//     (Executes last)                               												(Executes First)
		// Output should be: 
		// Plain Cake + Filling: STRAWBERRY + ToppingType: NUTS
		
		System.out.println(newCake.cost());
		// Output should be:
		// 5.0(of Cake) + 5.0(of CakeWithFilling) +5.0(of CakeWithTopping) = 15.0
	}

}

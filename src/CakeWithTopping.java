import extras.ToppingType;

public class CakeWithTopping extends ItemDecorator {
	private ToppingType topping;
	
	public CakeWithTopping(Item item, ToppingType topping) {
		super(item);
		this.topping = topping;
	}

	// overrides name
	@Override
	public String bake() {
		return super.bake() + " + ToppingType: " + topping.name();
	}
	
	// overrides cost
	@Override
	public Double cost() {
		if( topping == ToppingType.NONE) // excluding additional cost for default values
			return super.cost();
		return super.cost() + 5.5;
	}

}
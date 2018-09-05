import extras.FrostingType;

public class DonutWithFrosting extends ItemDecorator {
	private FrostingType frost;
	
	public DonutWithFrosting(Item item, FrostingType frost) {
		super(item);
		this.frost = frost;
	}

	// overrides name
	@Override
	public String bake() {
		return super.bake() + " + Frosting: " + frost.name();
	}
	
	// overrides cost
	@Override
	public Double cost() {
		if(frost == FrostingType.NONE) // excluding additional cost for default values
			return super.cost();
		return super.cost() + 0.5;
	}
}
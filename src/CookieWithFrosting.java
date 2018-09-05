import extras.FrostingType;

public class CookieWithFrosting extends ItemDecorator {
	private FrostingType frost;
	
	public CookieWithFrosting(Item item, FrostingType frost) {
		super(item);
		this.frost = frost;
	}

	// overrides name
	@Override
	public String bake() {
		return super.bake() + " + FrostingType: " + frost.name();
	}
	
	// overrides cost
	@Override
	public Double cost() {
		if(frost == FrostingType.NONE) // excluding additional cost for default values
			return super.cost();
		return super.cost() + 0.5;
	}

}
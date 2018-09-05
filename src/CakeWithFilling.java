import extras.FillingType;

public class CakeWithFilling extends ItemDecorator {
	private FillingType fill;
	
	public CakeWithFilling(Item item, FillingType fill) {
		super(item);
		this.fill = fill;
	}

	// overrides name
	@Override
	public String bake() {
		return super.bake() + " + Filling: " + fill.name();
	}
	
	// overrides cost
	@Override
	public Double cost() {
		if(fill == FillingType.NONE) // excluding additional cost for default values
			return super.cost();
		return super.cost() + 5.5;
	}

}
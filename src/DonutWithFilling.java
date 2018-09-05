import extras.FillingType;

public class DonutWithFilling extends ItemDecorator {
	private FillingType fill;
	
	public DonutWithFilling(Item item, FillingType fill) {
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
		return super.cost() + 1.0;
	}

}
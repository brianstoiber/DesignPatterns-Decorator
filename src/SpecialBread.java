import extras.DoughType;

// bread with special dough

public class SpecialBread extends ItemDecorator {
	private DoughType dough;
	
	public SpecialBread(Item item, DoughType dough) {
		super(item);
		this.dough = dough;
	}

	// overrides name
	@Override
	public String bake() {
		return super.bake() + " + Dough: " + dough.name();
	}

	// overrides cost
	@Override
	public Double cost() {
		if( dough == DoughType.WHITE) // excluding additional cost for default values
			return super.cost();
		return super.cost() + 5.0; 
	}
	
}
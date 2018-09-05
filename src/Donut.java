// basic donut without customizations

public class Donut implements Item {

	@Override
	public String bake() {
		return "Basic Donut";
	}
	
	@Override
	public Double cost() {
		return 1.0;
	}

}
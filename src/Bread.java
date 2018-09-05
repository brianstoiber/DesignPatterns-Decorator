// plain bread without customizations

public class Bread implements Item{

	@Override
	public String bake() {
		return "Plain Bread";
	}

	@Override
	public Double cost() {
		return 5.0;
	}

}
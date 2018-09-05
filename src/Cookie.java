// plain cookie without customizations

public class Cookie implements Item {

	@Override
	public String bake() {
		return "Plain Cookie";
	}
	
	@Override
	public Double cost() {
		return 0.75;
	}

}
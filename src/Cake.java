public class Cake implements Item {

	@Override
	public String bake() {
		return "Plain Cake";
	}
	
	@Override
	public Double cost() {
		return 10.0;
	}

}
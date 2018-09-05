// abstract decorator class that is extended by all concrete classes

public abstract class ItemDecorator implements Item {
	protected Item item;
	public ItemDecorator(Item item){
		this.item = item;
	}
	
	public String bake(){
		return item.bake();
	}
	
	public Double cost(){
		return item.cost();
	}
}
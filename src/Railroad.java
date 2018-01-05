package esof322.pa4;

public class Railroad extends Square{
	private int Price;
	private String name;
	private int rent = 25;
	
	public Railroad(String name, Owner owner, int price) {
		super(name,owner, price);
		Price = price;
	}
	
	public int getPrice() {
		return Price;
	}
	
	public int getRent() {
		return rent;
	}
	
	public void increaseRent() {
		rent *= 2;
	}
}

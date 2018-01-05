package esof322.pa4;

public class Utility extends Square{
	private int Price;
	private String name;
	
	public Utility(String name, Owner owner, int price) {
		super(name,owner,price);
		this.Price = price;
	}
	
	public int getRent(int dieOne, int dieTwo) {
		return 4 * (dieOne + dieTwo);
	}
	
	public int getPrice() {
		return Price;
	}
}

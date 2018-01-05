package esof322.pa4;

public class Square extends Board{
	private boolean available = true;
	private String name;
	private Owner owner;
	private int price;
	private int numHouses = 0;
	private int housePrice;
	private int rent;
	private boolean isMortgaged = false;
	
	public Square(String name, Owner owner,int price) {
		this.name = name;
		this.owner = owner;
		this.price = price;
	}
	
	public void setMortgage() {
		isMortgaged = !isMortgaged;
	}
	
	public boolean isMortgaged() {
		return isMortgaged;
	}
	
	public void setRent(int num) {
		rent = num;
	}
	
	public int getRent() {
		return rent;
	}
	
	public int getRent(int dieOne, int dieTwo) {
		return 4 * (dieOne + dieTwo);
	}
	
	public Owner retrieveOwner() {
		return owner;
	}
	
	public int getPrice() {
		return price;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public void setOwner(Owner newOwner) {
		owner = newOwner;
	}
	
	public void setAvailable(boolean avail) {
		available = avail;
	}
	
	public String retrieveName() {
		return name;
	}
	
	public int getNumHouses() {
		return numHouses;
	}
	
	public void setNumHouses(int num) {
		numHouses = num;
	}
	
	public int getHousePrice() {
		return housePrice;
	}
	
	public void increaseRent(int inc) {
		rent += inc;
	}
	
	public void increaseRent() {
		rent += rent;
	}
}

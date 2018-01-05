package esof322.pa4;

public class Property extends Square{
	private String colorGroup;
	private String name;
	private int housePrice;
	private int numHouses;
	private int rent;
	private int sellPrice;
	private boolean isMortgaged = false;
	
	public Property(String name, Owner owner, int price, String colorGroup) {
		super(name, owner, price);
		this.colorGroup = colorGroup;
		this.sellPrice = price;
		if(colorGroup.equals("Brown")) {
			housePrice = 50;
			rent = 4;
		}else if(colorGroup.equals("Light Blue")) {
			housePrice = 50;
			rent = 6;
		}else if(colorGroup.equals("Purple")) {
			housePrice = 100;
			rent = 10;
		}else if(colorGroup.equals("Orange")) {
			housePrice = 100;
			rent = 16;
		}else if(colorGroup.equals("Red")) {
			housePrice = 150;
			rent = 18;
		}else if(colorGroup.equals("Yellow")) {
			housePrice = 150;
			rent = 26;
		}else if(colorGroup.equals("Green")) {
			housePrice = 200;
			rent = 26;
		}else {
			housePrice = 200;
			rent = 50;
		}
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
	
	public String getColorGroup() {
		return colorGroup;
	}
	
	public int getHousePrice() {
		return housePrice;
	}
	
	public int getNumHouses() {
		return numHouses;
	}
	
	public int getPrice() {
		return sellPrice;
	}
	
	public int getRent() {
		return rent;
	}
	
	public void setNumHouses(int num) {
		numHouses = num;
		housePrice += housePrice;
	}
}

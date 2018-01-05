package esof322.pa4;

public class Player extends Owner{
	private String[] colorGroups;
	private boolean inJail;
	private String token;
	private int position;
	private int numHouses = 0;
	private boolean hasGetOutOfJailFreeCard = false;
	
	public Player(String name) {
		super(name);
		position = 0;
	}
	
	public void incNumHouses() {
		numHouses++;
	}
	
	public int getNumHouses() {
		return numHouses;
	}
	
	public void setPosition(int pos) {
		position = pos;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setJailFree() {
		hasGetOutOfJailFreeCard = !hasGetOutOfJailFreeCard;
	}
	
	public boolean getJailFree() {
		return hasGetOutOfJailFreeCard;
	}
}
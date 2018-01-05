package esof322.pa4;

public class Owner{
	private Square[] OwnedProperties;
	private int Wallet;
	private String name;
	
	public Owner(String name) {
		this.name = name;
	}
	
	public String retrieveName() {
		return name;
	}
	
	public void SellDeed(Square deed) {
		
	}
	
	public void MortgageDeed(Property deed) {
		
	}
	
	public void UpgradeProperty(Property deed) {
		
	}
	
	public void UnmortgageDeed() {
		
	}
}

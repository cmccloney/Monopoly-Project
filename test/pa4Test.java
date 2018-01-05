package esof322.pa4;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

public class pa4Test {
	@Test
	public void ChanceTest() {
		Chance chance = new Chance("Make general repairs on all your property - For each house pay $25", 300, 6);
		assertEquals("Make general repairs on all your property - For each house pay $25", chance.retrieveName());
	}
	
	@Test
	public void CommunityChestTest() {
		CommunityChest chest = new CommunityChest("You are assessed for street repairs - $40 per house", 300, 1);
		assertEquals("You are assessed for street repairs - $40 per house", chest.retrieveName());
	}
	
	@Test
	public void DiceRollTest() {
		DiceRoll roll = new DiceRoll();
		assertEquals(1, roll.getDieOne(), 5);
		assertEquals(1, roll.getDieTwo(), 5);
	}
	
	@Test
	public void BankTest() {
		Bank bank = new Bank("Bank of America");
		assertEquals("Bank of America", bank.retrieveName());
	}
	
	@Test
	public void BoardTest() {
		Board board = new Board();
		assertTrue(board.getIsOpened());
	}
	
	@Test
	public void JailTest() {
		Jail jail = new Jail();
		assertEquals("Jail", jail.retrieveName());
		//assertEquals("Bank", jail.retrieveOwner());
		//assertEquals(50, jail.getPrice());
		
	}
	@Test
	public void GoTest() {
		Go go = new Go();
		assertEquals("Go", go.retrieveName());
		//assertEquals("Nobody", go.retrieveOwner());
		//assertEquals(200, go.getPrice());
	}
	
	@Test
	public void GUITest() {
		GUI gui = new GUI();
		assertEquals(40, gui.board.length);
		assertEquals(16, gui.chanceDeck.length);
		assertEquals(16, gui.chestDeck.length);
	}
	
	@Test
	public void OwnerTest() {
		Player player = new Player("Joe");
		player.setPosition(1);
		assertEquals(1, player.getPosition());
		assertEquals("Joe", player.retrieveName());
	}
	
	@Test
	public void RailTest() {
		String railroadName = "Old Railroad";
		int price = 400;
		Player player = new Player("Miley Cyrus");
		Railroad railroad = new Railroad(railroadName, player, price);
		
		assertEquals(400, railroad.getPrice());
		assertEquals(25, railroad.getRent());
		railroad.increaseRent();
		assertEquals(50, railroad.getRent());
	}
	
	@Test
	public void SquareTest() {
		String name = "Tai Walkway";
		int price = 250;
		Player player = new Player("Miley Cyrus");
		Square sq = new Square(name, player, price);
		
		assertEquals(false, sq.isMortgaged());
		sq.setRent(15);
		assertEquals(15, sq.getRent());
		assertEquals(24,sq.getRent(3,3));
		assertEquals(player,sq.retrieveOwner());
		assertEquals(250, sq.getPrice());
		assertEquals(true, sq.isAvailable());
		Player newPlayer = new Player("Billy");
		sq.setOwner(newPlayer);
		assertEquals(newPlayer, sq.retrieveOwner());
		sq.setAvailable(false);
		assertEquals(false, sq.isAvailable());
		assertEquals(0, sq.getNumHouses());
		sq.setNumHouses(14);
		assertEquals(14, sq.getNumHouses());
	}
	
	@Test
	public void UtilityTest() {
		String name = "Util";
		int price = 150;
		Player player = new Player("Miley Cyrus");
		Utility util = new Utility(name, player, price);
		
		assertEquals(40, util.getRent(4, 6));
		assertEquals(150, util.getPrice());
	}
	
	@Test
	public void PlayerTest() {
		Player player = new Player("Miley Cyrus");
		player.setPosition(1);
		assertEquals("Miley Cyrus", player.retrieveName());
		assertEquals(1, player.getPosition());
	}
	
	@Test
	public void PropTest1() {
		String colorGroup = "Brown";
		int price = 300;
		Player player = new Player("Miley Cyrus");
		Property prop = new Property("Sick house", player, price, colorGroup);
		
		assertEquals(300, prop.getPrice());
		assertEquals(4, prop.getRent());
		assertEquals(50, prop.getHousePrice());
		assertEquals("Brown", prop.getColorGroup());
		prop.setNumHouses(14);
		assertEquals(14, prop.getNumHouses());
		assertEquals(100, prop.getHousePrice());
	}
	
	@Test
	public void PropTest2() {
		String colorGroup = "Orange";
		int price = 400;
		Player player = new Player("Miley Cyrus");
		Property prop = new Property("Sick house", player, price, colorGroup);
		
		assertEquals(400, prop.getPrice());
		assertEquals(16, prop.getRent());
		assertEquals(100, prop.getHousePrice());
		assertEquals("Orange", prop.getColorGroup());
		prop.setNumHouses(4);
		assertEquals(4, prop.getNumHouses());
		assertEquals(200, prop.getHousePrice());
	}
	
	@Test
	public void PropTest3() {
		String colorGroup = "NoColor";
		int price = 250;
		Player player = new Player("Miley Cyrus");
		Property prop = new Property("Sick house", player, price, colorGroup);
		
		assertEquals(250, prop.getPrice());
		assertEquals(50, prop.getRent());
		assertEquals(200, prop.getHousePrice());
		assertEquals("NoColor", prop.getColorGroup());
		prop.setNumHouses(7);
		assertEquals(7, prop.getNumHouses());
		assertEquals(400, prop.getHousePrice());
	}

}

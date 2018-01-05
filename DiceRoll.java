package esof322.pa4;

import java.util.Random;

public class DiceRoll {
	private int dieOne, dieTwo;
	private Random random = new Random();
	
	public DiceRoll() {
		dieOne = random.nextInt(6 - 1 + 1) + 1;
		dieTwo = random.nextInt(6 - 1 + 1) + 1;
	}
	
	public int getDieOne() {
		return dieOne;
	}
	
	public int getDieTwo() {
		return dieTwo;
	}
}

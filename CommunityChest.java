package esof322.pa4;

import java.awt.datatransfer.*;
import java.awt.Toolkit;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Timer;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.awt.Image.*;
import java.util.Random;
import java.util.*;

public class CommunityChest {
	String name;
	int money;
	int newPos;
	
	public CommunityChest(String name, int money, int newPos) {
		this.name = name;
		this.money = money;
		this.newPos = newPos;
	}
	
	public int run(Player[] players, int playerTurn, int[] wallet, int pos) { //play the chance card
		if(name.equals("You are assessed for street repairs - $40 per house")) {
			wallet[playerTurn - 1] += money * players[playerTurn-1].getNumHouses();
			newPos = pos;
		}else {
			wallet[playerTurn - 1] += money;
		}
		if(name.equals("Get out of Jail Free")) {
			if(!players[playerTurn-1].getJailFree()) {
				players[playerTurn-1].setJailFree();
			}
			newPos = pos;
		}else if(newPos > -1) {
			players[playerTurn-1].setPosition(newPos);
			if(players[playerTurn-1].getPosition() < newPos) {
				wallet[playerTurn-1] += 200;
			}
		}else {
			newPos = pos;
		}
		return newPos;
	}
	
	public String retrieveName() {
		return name;
	}
	
}
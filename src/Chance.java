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

public class Chance {
	String name;
	int money;
	int newPos;
	
	public Chance(String name, int money, int newPos) {
		this.name = name;
		this.money = money;
		this.newPos = newPos;
	}
	
	public int run(Player[] players, int playerTurn, int[] wallet, int pos) { //play the chance card
		if(name.equals("Make general repairs on all your property - For each house pay $25")) {
			wallet[playerTurn - 1] += money * players[playerTurn-1].getNumHouses();
			newPos = pos;
		}else if(name.equals("You have been elected Chairman of the Board - Pay each player $50")){
			wallet[playerTurn - 1] += money;
			wallet[playerTurn % 2] -= money;
			newPos = pos;
		}else {
			wallet[playerTurn - 1] += money;
		}if(newPos == 12) {
			if(players[playerTurn-1].getPosition() <= newPos) {
				players[playerTurn-1].setPosition(newPos);
			}else {
				players[playerTurn-1].setPosition(28);
			}
		}else if(newPos == 15) {
			if(players[playerTurn-1].getPosition() <= newPos-10) {
				players[playerTurn-1].setPosition(newPos-10);
			}else if(players[playerTurn-1].getPosition() <= newPos) {
				players[playerTurn-1].setPosition(newPos);
			}else if(players[playerTurn-1].getPosition() <= newPos+10) {
				players[playerTurn-1].setPosition(newPos+10);
			}else {
				players[playerTurn-1].setPosition(newPos+20);
			}
		}else if(name.equals("Go Back 3 Spaces")) {
			newPos = pos - 3;
			if(newPos < 0) {
				newPos = 40 - newPos;
			}
			players[playerTurn-1].setPosition(newPos);
		}else if(name.equals("Get out of Jail Free")) {
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

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

public class SouthParkTheme implements ThemeFactory {

	public SouthParkTheme() {
		
	}
	
	public void initCommunityChest(CommunityChest[] chestDeck) {
		chestDeck[0] = new CommunityChest("Advance to Go",0,0);
		chestDeck[1] = new CommunityChest("Bank error in your favor - Collect $200",200,-1);
		chestDeck[2] = new CommunityChest("Doctor's fees - Pay $50",-50,-1);
		chestDeck[3] = new CommunityChest("Get out of Jail Free",0,-1);
		chestDeck[4] = new CommunityChest("Go directly to Jail",0,10);
		chestDeck[5] = new CommunityChest("Grand Opera Night - Collect $50",50,-1);
		chestDeck[6] = new CommunityChest("Holiday fund matures - Collect $100",100,-1);
		chestDeck[7] = new CommunityChest("Income tax refund - Collect $20",20,-1);
		chestDeck[8] = new CommunityChest("It's your birthday - Collect $10",10,-1);
		chestDeck[9] = new CommunityChest("Life insurance matures - Collect $100",100,-1);
		chestDeck[10] = new CommunityChest("Pay hospital fee of $100",-100,-1);
		chestDeck[11] = new CommunityChest("Pay school fee of $150",-150,-1);
		chestDeck[12] = new CommunityChest("Receive $25 consultancy fee",25,-1);
		chestDeck[13] = new CommunityChest("You are assessed for street repairs - $40 per house",-40,-1);
		chestDeck[14] = new CommunityChest("You have won second prize in beauty contest - Collect $10",10,-1);
		chestDeck[15] = new CommunityChest("You inherit $100",100,-1);
	}
	
	public void initChanceDeck(Chance[] chanceDeck) {
		chanceDeck[0] = new Chance("Advance to Go",0,0);
		chanceDeck[1] = new Chance("Advance to Mr. Hanky's House",0,24);
		chanceDeck[2] = new Chance("Advance to Skeeter's Bar",0,11);
		chanceDeck[3] = new Chance("Advance token to the nearest Utility",0,12);
		chanceDeck[4] = new Chance("Advance token to the nearest Railroad",0,15);
		chanceDeck[5] = new Chance("Bank pays you dividend of $50",50,-1);
		chanceDeck[6] = new Chance("Get out of Jail Free",0,-1);
		chanceDeck[7] = new Chance("Go Back 3 Spaces",0,-1);
		chanceDeck[8] = new Chance("Go directly to Jail",0,10);
		chanceDeck[9] = new Chance("Make general repairs on all your property - "
				+ "For each house pay $25",-25,-1);
		chanceDeck[10] = new Chance("Pay poor tax of $15",-15,-1);
		chanceDeck[11] = new Chance("Advance to Seven-Turdy-Seven",0,5);
		chanceDeck[12] = new Chance("Advance to Cartmanland",0,39);
		chanceDeck[13] = new Chance("You have been elected Chairman of the Board -"
				+ " Pay each player $50",-50,-1);
		chanceDeck[14] = new Chance("Your building and loan matures - Collect $150",150,-1);
		chanceDeck[15] = new Chance("You have won a crossword competition - Collect $100",100,-1);
	}
	
	public void initPics(JPanel panel) {
		//ImageIcon icon = new ImageIcon("C:\\Users\\cmccl_000\\eclipse-workspace\\GUI\\images\\south-park-first-ten.jpg");
		ImageIcon icon = new ImageIcon("Team13\\images\\south-park-first-ten.jpg");
		Image image = icon.getImage();
		Image newimg = image.getScaledInstance(1950, 150,  java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		JLabel firstTen = new JLabel();
		firstTen.setIcon(icon);
		firstTen.setBounds(0, -65, 2000, 2000);
		panel.add(firstTen);
		
		//icon = new ImageIcon("C:\\Users\\cmccl_000\\eclipse-workspace\\GUI\\images\\south-park-second-ten.jpg");
		icon = new ImageIcon("Team13\\images\\south-park-second-ten.jpg");
		image = icon.getImage();
		newimg = image.getScaledInstance(260, 860, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		JLabel secondTen = new JLabel();
		secondTen.setIcon(icon);
		secondTen.setBounds(0, -570, 2000, 2000);
		panel.add(secondTen);
		
		//icon = new ImageIcon("C:\\Users\\cmccl_000\\eclipse-workspace\\GUI\\images\\south-park-third-ten.jpg");
		icon = new ImageIcon("Team13\\images\\south-park-third-ten.jpg");
		image = icon.getImage();
		newimg = image.getScaledInstance(1700, 130, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		JLabel thirdTen = new JLabel();
		thirdTen.setIcon(icon);
		thirdTen.setBounds(255, -935, 2000, 2000);
		panel.add(thirdTen);
		
		//icon = new ImageIcon("C:\\Users\\cmccl_000\\eclipse-workspace\\GUI\\images\\south-park-last-ten.jpg");
		icon = new ImageIcon("Team13\\images\\south-park-last-ten.jpg");
		image = icon.getImage();
		newimg = image.getScaledInstance(240, 740, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		JLabel lastTen = new JLabel();
		lastTen.setIcon(icon);
		lastTen.setBounds(1690, -500, 2000, 2000);
		panel.add(lastTen);
	}
	
	public void initBoard(Square[] board) {
		Bank bank = new Bank("Bank");
		board[0] = new Go();
		board[1] = new Property("Kenny's House",bank,60,"Brown"); //here
		board[2] = new Square("Cheesy Poofs",bank,0);
		board[3] = new Property("Canada",bank,60,"Brown");
		board[4] = new Square("Aaaaand it's gone!",bank,100);
		board[5] = new Railroad("Seven-Turdy-Seven",bank,200);
		board[6] = new Property("Tom's Rhinoplasty",bank,100,"Light Blue");
		board[7] = new Square("Snacky S'mores",bank,0);
		board[8] = new Property("Tweak's Coffee",bank,100,"Light Blue");
		board[9] = new Property("Lolly's Candy Factory",bank,120,"Light Blue");
		board[10] = new Jail();
		board[11] = new Property("Skeeter's Bar",bank,140,"Purple");
		board[12] = new Utility("Mephesto's Genetic Engineering Ranch",bank,150);
		board[13] = new Property("Hell's Pass Hospital",bank,140,"Purple");
		board[14] = new Property("City Hall",bank,160,"Purple");
		board[15] = new Railroad("Helicrapter",bank,200);
		board[16] = new Property("City Sushi",bank,180,"Orange");
		board[17] = new Square("Cheesy Poofs",bank,0);
		board[18] = new Property("Tower of Peace",bank,180,"Orange");
		board[19] = new Property("City Wok",bank,200,"Orange");
		board[20] = new Square("Free Parking",bank,100);
		board[21] = new Property("Critter Forest",bank,220,"Red");
		board[22] = new Square("Snacky S'mores",bank,0);
		board[23] = new Property("Santa's Workshop",bank,220,"Red");
		board[24] = new Property("Mr. Hanky's House",bank,240,"Red");
		board[25] = new Railroad("Poo Choo Express",bank,200);
		board[26] = new Property("Super Fun Thyme",bank,260,"Yellow");
		board[27] = new Property("Raisins",bank,260,"Yellow");
		board[28] = new Utility("Tynacorp",bank,150);
		board[29] = new Property("Whistlin Willie's",bank,280,"Yellow");
		board[30] = new Square("Go To Jail",bank,0);
		board[31] = new Property("Bus Stop",bank,300,"Green");
		board[32] = new Property("Stark's Pond",bank,300,"Green");
		board[33] = new Square("Cheesy Poofs",bank,0);
		board[34] = new Property("South Park Elementary",bank,320,"Green");
		board[35] = new Railroad("Kyle's Toilet",bank,200);
		board[36] = new Square("Snacky S'mores",bank,0);
		board[37] = new Property("Imaginationland",bank,350,"Blue");
		board[38] = new Square("Gooback Tax",bank,200);
		board[39] = new Property("Cartmanland",bank,400,"Blue");
	}
}
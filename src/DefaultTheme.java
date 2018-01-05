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

public class DefaultTheme implements ThemeFactory {

	public DefaultTheme() {
		
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
		chanceDeck[1] = new Chance("Advance to Trafalgar Square",0,24);
		chanceDeck[2] = new Chance("Advance to Pall Mall",0,11);
		chanceDeck[3] = new Chance("Advance token to the nearest Utility",0,12);
		chanceDeck[4] = new Chance("Advance token to the nearest Railroad",0,15);
		chanceDeck[5] = new Chance("Bank pays you dividend of $50",50,-1);
		chanceDeck[6] = new Chance("Get out of Jail Free",0,-1);
		chanceDeck[7] = new Chance("Go Back 3 Spaces",0,-1);
		chanceDeck[8] = new Chance("Go directly to Jail",0,10);
		chanceDeck[9] = new Chance("Make general repairs on all your property - "
				+ "For each house pay $25",-25,-1);
		chanceDeck[10] = new Chance("Pay poor tax of $15",-15,-1);
		chanceDeck[11] = new Chance("Advance to Kings Cross Station",0,5);
		chanceDeck[12] = new Chance("Advance to Mayfair",0,39);
		chanceDeck[13] = new Chance("You have been elected Chairman of the Board -"
				+ " Pay each player $50",-50,-1);
		chanceDeck[14] = new Chance("Your building and loan matures - Collect $150",150,-1);
		chanceDeck[15] = new Chance("You have won a crossword competition - Collect $100",100,-1);
	}
	
	public void initPics(JPanel panel) {
		//ImageIcon icon = new ImageIcon("C:\\Users\\cmccl_000\\git\\Team13\\images\\first-ten.jpg");
		ImageIcon icon = new ImageIcon("Team13\\images\\first-ten.jpg");
		Image image = icon.getImage();
		Image newimg = image.getScaledInstance(1950, 150,  java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		JLabel firstTen = new JLabel();
		firstTen.setIcon(icon);
		firstTen.setBounds(0, -65, 2000, 2000);
		panel.add(firstTen);
		
		//icon = new ImageIcon("C:\\Users\\cmccl_000\\git\\Team13\\images\\second-ten.jpg");
		icon = new ImageIcon("Team13\\images\\second-ten.jpg");
		image = icon.getImage();
		newimg = image.getScaledInstance(260, 860, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		JLabel secondTen = new JLabel();
		secondTen.setIcon(icon);
		secondTen.setBounds(0, -570, 2000, 2000);
		panel.add(secondTen);
		
		//icon = new ImageIcon("C:\\Users\\cmccl_000\\git\\Team13\\images\\third-ten.jpg");
		icon = new ImageIcon("Team13\\images\\third-ten.jpg");
		image = icon.getImage();
		newimg = image.getScaledInstance(1700, 130, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		JLabel thirdTen = new JLabel();
		thirdTen.setIcon(icon);
		thirdTen.setBounds(255, -935, 2000, 2000);
		panel.add(thirdTen);
		
		//icon = new ImageIcon("C:\\Users\\cmccl_000\\git\\Team13\\images\\last-ten.jpg");
		icon = new ImageIcon("Team13\\images\\last-ten.jpg");
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
		board[1] = new Property("Old Kent Road",bank,60,"Brown"); //here
		board[2] = new Square("Community Chest",bank,0);
		board[3] = new Property("Whitechapel Road",bank,60,"Brown");
		board[4] = new Square("Income Tax",bank,100);
		board[5] = new Railroad("Kings Cross Station",bank,200);
		board[6] = new Property("The Angel Islington",bank,100,"Light Blue");
		board[7] = new Square("Chance",bank,0);
		board[8] = new Property("Euston Road",bank,100,"Light Blue");
		board[9] = new Property("Pentonville Road",bank,120,"Light Blue");
		board[10] = new Jail();
		board[11] = new Property("Pall Mall",bank,140,"Purple");
		board[12] = new Utility("Electric Company",bank,150);
		board[13] = new Property("Whitehall",bank,140,"Purple");
		board[14] = new Property("Northumrl'd Avenue",bank,160,"Purple");
		board[15] = new Railroad("Marylebone Station",bank,200);
		board[16] = new Property("Bow Street",bank,180,"Orange");
		board[17] = new Square("Community Chest",bank,0);
		board[18] = new Property("Marlborough Street",bank,180,"Orange");
		board[19] = new Property("Vine Street",bank,200,"Orange");
		board[20] = new Square("Free Parking",bank,100);
		board[21] = new Property("Strand",bank,220,"Red");
		board[22] = new Square("Chance",bank,0);
		board[23] = new Property("Fleet Street",bank,220,"Red");
		board[24] = new Property("Trafalgar Square",bank,240,"Red");
		board[25] = new Railroad("Fenchurch St. Station",bank,200);
		board[26] = new Property("Leicester Square",bank,260,"Yellow");
		board[27] = new Property("Coventry Street",bank,260,"Yellow");
		board[28] = new Utility("Water Works",bank,150);
		board[29] = new Property("Piccadilly",bank,280,"Yellow");
		board[30] = new Square("Go To Jail",bank,0);
		board[31] = new Property("Regent Street",bank,300,"Green");
		board[32] = new Property("Oxford Street",bank,300,"Green");
		board[33] = new Square("Community Chest",bank,0);
		board[34] = new Property("Bond Street",bank,320,"Green");
		board[35] = new Railroad("Liverpool St. Station",bank,200);
		board[36] = new Square("Chance",bank,0);
		board[37] = new Property("Park Lane",bank,350,"Blue");
		board[38] = new Square("Luxury Tax",bank,200);
		board[39] = new Property("Mayfair",bank,400,"Blue");
	}
}

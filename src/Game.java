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

public class Game {
	JFrame frame;
	JLabel diceRoll, turn, pieceName, pieceName2, walletOne, walletTwo;
	JButton roll;
	JPanel panel;
	Player[] players;
	int[] wallet;
	Square[] board;
	Chance[] chanceDeck;
	CommunityChest[] chestDeck;
	Random random = new Random();
	
	public Game(JFrame frame, JPanel panel, JLabel diceRoll,JLabel turn, JLabel pieceName, JLabel pieceName2,
			JLabel walletOne, JLabel walletTwo, JButton roll, Square[] board, Player[] players, int[] wallet,
			Chance[] chanceDeck, CommunityChest[] chestDeck) {
		this.frame = frame;
		this.diceRoll = diceRoll;
		this.turn = turn;
		this.pieceName = pieceName;
		this.pieceName2 = pieceName2;
		this.walletOne = walletOne;
		this.walletTwo = walletTwo;
		this.roll = roll;
		this.players = players;
		this.wallet = wallet;
		this.board = board;
		this.panel = panel;
		this.chanceDeck = chanceDeck;
		this.chestDeck = chestDeck;
	}
	
	public void railroadPlay(int pos, int playerTurn) {
		if(board[pos].retrieveOwner().retrieveName().equals("Bank")) { //if nobody owns the railroad
			int answer = JOptionPane.showConfirmDialog(frame,"You've landed on "
				+ board[pos].retrieveName() + ", would you like to buy it for $" + 
					board[pos].getPrice() + "?");
			if(answer == 0) {
				wallet[playerTurn-1] -= board[pos].getPrice();
				board[pos].setOwner(players[playerTurn-1]);
				board[pos].increaseRent();
			}
		}else if(!(board[pos].retrieveOwner().retrieveName().equals(players[playerTurn-1].retrieveName()))){ //if the other player owns the railroad
			JOptionPane.showConfirmDialog(frame, board[pos].retrieveOwner().retrieveName()
					+ " owns " + board[pos].retrieveName() + " and so you will pay $" + board[pos].getRent());
			wallet[playerTurn-1] -= board[pos].getRent();
			wallet[playerTurn%2] += board[pos].getRent();
		}
	}
	
	public void propertyPlay(int pos, int playerTurn) {
		if(board[pos].retrieveOwner().retrieveName().equals("Bank")) { //if the bank owns this square
			int answer = JOptionPane.showConfirmDialog(frame,"You've landed on "
				+ board[pos].retrieveName() + ", would you like to buy it for $"
						+ board[pos].getPrice() + "?");
			if(answer == 0) {
				wallet[playerTurn-1] -= board[pos].getPrice();
				board[pos].setOwner(players[playerTurn-1]);
			}
		}else if(!(players[playerTurn-1].retrieveName().equals(board[pos].retrieveOwner().retrieveName()))){ // if the other player owns the square
			if(!board[pos].isMortgaged()) {
				wallet[playerTurn-1] -= board[pos].getRent();
				wallet[playerTurn%2] += board[pos].getRent();
				JOptionPane.showMessageDialog(frame,board[pos].retrieveOwner().retrieveName()
					+ " owns " + board[pos].retrieveName() + ", so you will lose $" + board[pos].getRent());
			}
		}else if(board[pos].getNumHouses() <= 5){ //if you own the square, you can purchase a house/hotel
			int answer = JOptionPane.showConfirmDialog(frame, "You own " + board[pos].getNumHouses()
					+ " houses/hotels on " + board[pos].retrieveName() + ", would you like to buy another one?");
			if(answer == 0) {
				wallet[playerTurn-1] -= board[pos].getHousePrice();
				board[pos].setNumHouses(board[pos].getNumHouses()+1);
			}else if(!board[pos].isMortgaged()){ //mortgage property
				answer = JOptionPane.showConfirmDialog(frame, "Would you like to mortgage this property?");
				if(answer == 0) {
					wallet[playerTurn-1] += (board[pos].getPrice()/2);
					board[pos].setMortgage();
				}
			}else { //unmortgage property
				answer = JOptionPane.showConfirmDialog(frame, "Would you like to unmortgage this property?");
				if(answer == 0) {
					wallet[playerTurn-1] -= (board[pos].getPrice() + (board[pos].getPrice() * .1));
					board[pos].setMortgage();
				}
			}
		}
	}
	
	public int goToJail(int playerTurn) {
		int answer = 0;
		if(players[playerTurn-1].getJailFree()) { //if player has a get out of jail free card
			answer = JOptionPane.showConfirmDialog(frame,"You've landed on Go To Jail, "
					+ "would you like to use your Get Out Of Jail Free Card?");
			if(answer == 0) {
				players[playerTurn-1].setJailFree();
				return (playerTurn % 2) + 1; //player gets to roll again
			}
		}
		if(!players[playerTurn-1].getJailFree() || answer == 1) {
			answer = JOptionPane.showConfirmDialog(frame,"You've landed on Go To Jail, "
					+ "Pay Fine $50 (Yes) or Roll"
					+ " for Doubles (No)?");
			if(answer == 0) {
				wallet[playerTurn-1] -= 50;
				return (playerTurn % 2) + 1; //player gets to roll again
			}else {
	            DiceRoll dr = new DiceRoll();
	            diceRoll.setText("Dice Roll: " + dr.getDieOne() + "," + dr.getDieTwo());
	            if(dr.getDieOne() == dr.getDieTwo()) {
	            	return (playerTurn % 2) + 1; //player keeps his turn
	            }
			}
		}
		return playerTurn;
	}
	
	public void utilityPlay(int pos, int playerTurn, int dieOne, int dieTwo) {
		if(board[pos].retrieveOwner().retrieveName().equals("Bank")) { //if nobody owns the utility
			int answer = JOptionPane.showConfirmDialog(frame,"You've landed on "
					+ board[pos].retrieveName() + " would you like to buy it for $"
					+ board[pos].getPrice() + "?");
			if(answer == 0) {
				wallet[playerTurn-1] -= board[pos].getPrice();
				board[pos].setOwner(players[playerTurn-1]);
			}
		}else if(!(board[pos].retrieveOwner().retrieveName().equals(players[playerTurn-1].retrieveName()))){ //if the other player owns the utility
			JOptionPane.showConfirmDialog(frame, board[pos].retrieveOwner().retrieveName()
					+ " owns " + board[pos].retrieveName() + " and so you will pay $" + board[pos].getRent(dieOne,dieTwo));
			wallet[playerTurn-1] -= board[pos].getRent(dieOne, dieTwo);
			wallet[playerTurn%2] += board[pos].getRent(dieOne, dieTwo);
		}
	}
	
	public int playTurn(JLabel Turn, int playerTurn) {
		if(wallet[0] <= 0 || wallet[1] <= 0) {
      	  endGame(panel);
      	  return playerTurn;
        }
		DiceRoll dr = new DiceRoll();
        int dieOne = dr.getDieOne();
        int dieTwo = dr.getDieTwo();
        int sum = dr.getDieOne() + dr.getDieTwo();
        int pos = (players[playerTurn-1].getPosition() + sum) % 39;
        int prevPos = players[playerTurn-1].getPosition();
		boolean isProp = false;
		boolean inJail = false;
		int[] properties = {1,3,6,8,9,11,13,14,16,18,19,21,23,24,26,27,29,31,32,34,37,39};
		for(int i = 0; i < properties.length; i++) {
			if(pos == properties[i]) {
				isProp = true;
				break;
			}
		}
		if(pos < prevPos) { //pass go and collect $200
			JOptionPane.showMessageDialog(frame, "You've passed Go and collected $200");
			wallet[playerTurn-1] += 200;
		}
		if(pos == 5 || pos == 15 || pos == 25 || pos == 35) { //if it is a railroad square
			railroadPlay(pos, playerTurn);
		}else if(isProp) {
			propertyPlay(pos, playerTurn);
		}else if(board[pos].retrieveName().equals("Go To Jail")) { //go to jail
			inJail = true;
			pos = 10;
			players[playerTurn-1].setPosition(pos);
			playerTurn = goToJail(playerTurn);
		}else if(pos == 4 || pos == 38) { //pay tax
			JOptionPane.showMessageDialog(frame, "You've landed on " + 
				board[pos].retrieveName() + " and so will lose $" + board[pos].getPrice());
			wallet[playerTurn-1] -= board[pos].getPrice();
		}else if(pos == 12 || pos == 28) { //land on a non-railroad utility
			utilityPlay(pos, playerTurn, dieOne, dieTwo);
		}else if(pos == 7 || pos == 22 || pos == 36) {
			int chance = random.nextInt(15 - 1 + 1);
			JOptionPane.showMessageDialog(frame, "You've landed on " + 
					board[pos].retrieveName() + " and your card says: "
					+ chanceDeck[chance].retrieveName());
			int newPos = chanceDeck[chance].run(players, playerTurn, wallet,pos);
			pos = newPos;
		}else if(pos == 2 || pos == 17 || pos == 33) {
			int chance = random.nextInt(15 - 1 + 1);
			JOptionPane.showMessageDialog(frame, "You've landed on " + 
					board[pos].retrieveName() + " and your card says: "
					+ chestDeck[chance].retrieveName());
			int newPos = chestDeck[chance].run(players, playerTurn, wallet,pos);
			pos = newPos;
		}
		if(!inJail) {
			players[playerTurn-1].setPosition(pos);
		}
		diceRoll.setText("Dice Roll: " + dr.getDieOne() + "," + dr.getDieTwo());
		walletOne.setText("Player 1: $" + wallet[0]);
        pieceName.setText("Player 1: " + board[players[0].getPosition()].retrieveName());
     	walletTwo.setText("Player 2: $" + wallet[1]);
     	pieceName2.setText("Player 2: " + board[players[1].getPosition()].retrieveName());
        playerTurn = (playerTurn % 2) + 1;
        Turn.setText("Player " + playerTurn + "'s turn");
        return playerTurn;
	}
	
	public void endGame(JPanel panel) {
		panel.remove(pieceName2);
		panel.remove(turn);
		compareCash(players);
		walletOne.setBounds(450, 300, 900, 100);
		walletTwo.setBounds(450, 350, 900, 100);
		walletOne.setText("Player 1 Total Assets: $" + wallet[0]);
		walletTwo.setText("Player 2 Total Assets: $" + wallet[1]);
		if(wallet[0] > wallet[1]) {
			pieceName.setText("Player One has won the game.");
		}else{
			pieceName.setText("Player Two has won the game.");
		}
	}
	
	public void compareCash(Player[] players) {
		for(int i = 0; i < 40; i++) {
			if(board[i].retrieveOwner().retrieveName().equals("Player One")) {
				wallet[0] += board[i].getPrice();
			}else if(board[i].retrieveOwner().retrieveName().equals("Player Two")) {
				wallet[1] += board[i].getPrice();
			}
		}
	}
}
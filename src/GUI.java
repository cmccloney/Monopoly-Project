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

public class GUI extends JPanel{
	Player[] players = {new Player("Player One"), new Player("Player Two")};
	int playerTurn = 1;
	int turnsLeft = 50;
	int[] wallet = {1500, 1500};
	Square[] board;
	Chance[] chanceDeck;
	CommunityChest[] chestDeck;
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel panel;
	JLabel diceRoll, turn, pieceName, pieceName2, walletOne, walletTwo, timer;
	JButton roll;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUI gui = new GUI();
			}
		});
	}
	
	public GUI() {
		board = new Square[40];
		chanceDeck = new Chance[16];
		chestDeck = new CommunityChest[16];
		panel = new JPanel();
		String[] options = new String[] {"Default", "NFL", "South Park"};
	    int response = JOptionPane.showOptionDialog(null, "Pick a Theme Below", "Choose Theme",
	        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
	        null, options, options[0]);
		Game temp = new Game(frame, panel, diceRoll, turn, pieceName, pieceName2, walletOne, walletTwo,
				roll, board, players, wallet, chanceDeck,chestDeck);
		switch(response){
			case 1:
				NFLTheme nf = new NFLTheme();
				nf.initPics(panel);
				nf.initBoard(board);
				nf.initChanceDeck(chanceDeck);
				nf.initCommunityChest(chestDeck);
				break;
			case 2:
				SouthParkTheme sp = new SouthParkTheme();
				sp.initPics(panel);
				sp.initBoard(board);
				sp.initChanceDeck(chanceDeck);
				sp.initCommunityChest(chestDeck);
				break;
			default:
				DefaultTheme df = new DefaultTheme();
				df.initPics(panel);
				df.initBoard(board);
				df.initChanceDeck(chanceDeck);
				df.initCommunityChest(chestDeck);
				break;
		}
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(500,500,500,500);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		timer = new JLabel("Turns remaining: " + turnsLeft);
		timer.setBounds(1150, 50, 900, 300);
		timer.setBackground(Color.GRAY);
		timer.setFont(new Font("Sans Serif", Font.PLAIN, 54));
		panel.add(timer);
		
		turn = new JLabel("Player " + playerTurn + "'s turn");
		turn.setBounds(450, 50, 900, 300);
		turn.setBackground(Color.GRAY);
		turn.setFont(new Font("Sans Serif", Font.PLAIN, 54));
		panel.add(turn);
		
		pieceName = new JLabel("Player 1: " + board[players[0].getPosition()].retrieveName());
		pieceName.setBounds(450, 150, 900, 300);
		pieceName.setBackground(Color.GRAY);
		pieceName.setFont(new Font("Sans Serif", Font.PLAIN, 54));
		panel.add(pieceName);
		
		pieceName2 = new JLabel("Player 2: " + board[players[1].getPosition()].retrieveName());
		pieceName2.setBounds(450, 250, 900, 300);
		pieceName2.setBackground(Color.GRAY);
		pieceName2.setFont(new Font("Sans Serif", Font.PLAIN, 54));
		panel.add(pieceName2);
		
		diceRoll = new JLabel("Dice Roll: ");
		diceRoll.setBounds(450, 550, 900, 300);
		diceRoll.setBackground(Color.GRAY);
		diceRoll.setFont(new Font("Sans Serif", Font.PLAIN, 54));
		panel.add(diceRoll);
		
		walletOne = new JLabel("Player 1: $" + wallet[0]);
		walletOne.setBounds(1250, 500, 900, 100);
		walletOne.setBackground(Color.GRAY);
		walletOne.setFont(new Font("Sans Serif", Font.PLAIN, 54));
		panel.add(walletOne);
		
		walletTwo = new JLabel("Player 2: $" + wallet[1]);
		walletTwo.setBounds(1250, 600, 900, 100);
		walletTwo.setBackground(Color.GRAY);
		walletTwo.setFont(new Font("Sans Serif", Font.PLAIN, 54));
		panel.add(walletTwo);
		
		Game g = new Game(frame, panel, diceRoll, turn, pieceName, pieceName2, walletOne, walletTwo,
				roll, board, players, wallet,chanceDeck,chestDeck);
		
		roll = new JButton("Roll Dice");
		roll.setBounds(475,500,300,100);
		roll.setBackground(Color.WHITE);
        roll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              turnsLeft--;
              timer.setText("Turns remaining: " + turnsLeft);
              if(!(turnsLeft <= 0)) {
            	  playerTurn = g.playTurn(turn,playerTurn);
              }else {
            	  g.endGame(panel);
              }
            }
        });
        panel.add(roll);
        panel.setOpaque(true);
        
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //set size of frame, change if need be
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Monopoly GUI");
        frame.setVisible(true); //make last statement
	}
}

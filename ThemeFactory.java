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

public interface ThemeFactory {
	
	public void initPics(JPanel panel);
	public void initBoard(Square[] board);
	public void initChanceDeck(Chance[] chanceDeck);
	public void initCommunityChest(CommunityChest[] chestDeck);
}

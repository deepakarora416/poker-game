package com.poker.player;

import com.poker.card.Card;

/**
 * Represents a player playing the game of poker.
 * @author deepakarora
 *
 */
public class Player {
	  Card[] cards = new Card[2];
	  private int money = 2000;

	  public void setCards(Card card1, Card card2) {
	    cards[0] = card1;
	    cards[1] = card2;
	  }

	  public Card[] getCards() {
	    return this.cards;
	  }

	  /**
	   * hidden: if true, hide CPU cards with "?"
	   * cpu: if true, print CPU's cards
	   */
	  public void printCards(boolean hidden, boolean cpu) {
	    if (cpu) {
	      System.out.println("CPU's cards:");
	    }
	    else {
	      System.out.println("Your cards:");
	    }
	    if (hidden) {
	      System.out.print("|?|  ");
	      System.out.print("|?|");
	    }
	    else {
	      System.out.print("|" + cards[0].toString() + "|  ");
	      System.out.print("|" + cards[1].toString() + "|");
	    }
	    System.out.println("\n");
	  }

	  /**
	   * cpu: if true, print CPU's money 
	   */
	  public void printMoney(boolean cpu) {
	    if (cpu) {
	      System.out.println("CPU's Money: $" + this.money);
	    }
	    else {
	      System.out.println("Your Money: $" + this.money);
	    }
	  }

	  public int getMoney() {
	    return this.money;
	  }

	  public void addMoney(int money) {
	    this.money += money;
	  }

	  public void subMoney(int money) {
	    this.money -= money;
	  }
	}
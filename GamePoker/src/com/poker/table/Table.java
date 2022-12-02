package com.poker.table;

import com.poker.card.Card;

/**
 * Represents the table used in a game of Poker with community cards and a pot
 * @author deepakarora
 *
 */
public class Table {
	  private Card[] cards = new Card[5];
	  private int moneyFromP1 = 0;
	  private int moneyFromCPU = 0;

	  public void setCards(Card c1, Card c2, Card c3, Card c4, Card c5) {
	    cards[0] = c1;
	    cards[1] = c2;
	    cards[2] = c3;
	    cards[3] = c4;
	    cards[4] = c5;
	  }

	  public Card[] getCards() {
	    return this.cards;
	  }

	  public int getMoneyFromP1() {
	    return this.moneyFromP1;
	  }

	  public int getMoneyFromCPU() {
	    return this.moneyFromCPU;
	  }

	  public void addP1Money(int money) {
	    this.moneyFromP1 += money;
	  }

	  public void addCPUMoney(int money) {
	    this.moneyFromCPU += money;
	  }

	  public void clearTableMoney() {
	    this.moneyFromP1 = 0;
	    this.moneyFromCPU = 0;
	  }

	  /**
	   * numberOfCards: number of cards to display on table
	   */
	  public void printCards(int numberOfCards) {
	    if (numberOfCards == 0) {
	      System.out.println("\n");
	    }
	    else if (numberOfCards == 3) {
	      System.out.print("|" + cards[0].toString() + "|  ");
	      System.out.print("|" + cards[1].toString() + "|  ");
	      System.out.print("|" + cards[2].toString() + "|");
	      System.out.println("\n");
	    }
	    else if (numberOfCards == 4) {
	      System.out.print("|" + cards[0].toString() + "|  ");
	      System.out.print("|" + cards[1].toString() + "|  ");
	      System.out.print("|" + cards[2].toString() + "|  ");
	      System.out.print("|" + cards[3].toString() + "|");
	      System.out.println("\n");
	    }
	    else if (numberOfCards == 5) {
	      System.out.print("|" + cards[0].toString() + "|  ");
	      System.out.print("|" + cards[1].toString() + "|  ");
	      System.out.print("|" + cards[2].toString() + "|  ");
	      System.out.print("|" + cards[3].toString() + "|  ");
	      System.out.print("|" + cards[4].toString() + "|");
	      System.out.println("\n");
	    }
	  }

	  public void printMoney() {
	    System.out.println("Money on table: $" + (moneyFromCPU + moneyFromP1));
	  }
	}
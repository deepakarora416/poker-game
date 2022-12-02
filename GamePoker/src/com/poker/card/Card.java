package com.poker.card;

/**
 * Represents a playing card with a suit (Clubs, Diamonds, Hearts or Spades)
 * and value (Two, Three, ..., Ten, Jack, Queen, King, Ace).
 * @author deepakarora
 *
 */
public class Card implements Comparable<Card> {
	  private int rank;
	  private int suit;
	  private String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	  private String[] suits = {"Spades", "Clubs", "Diamonds", "Hearts"};

	  public Card(int rank, int suit) {
	    this.rank = rank;
	    this.suit = suit;
	  }

	  public int getRank() {
	    return this.rank;
	  }

	  public int getSuit() {
	    return this.suit;
	  }

	  public String toString() {
	    return ranks[this.getRank()] + " " + suits[this.getSuit()];
	  }

	  @Override
	  public int hashCode() {
	    return this.getRank() + this.getSuit();
	  }

	  @Override
	  public boolean equals(Object o) {
	    if (((Card)o).getRank() == this.getRank() && ((Card)o).getSuit() == this.getSuit()) {
	      return true;
	    }
	    return false;
	  }

	  @Override
	  public int compareTo(Card card) {
	    if (this.rank < card.rank) {
	      return -1;
	    }
	    else if (this.rank == card.rank) {
	      return 0;
	    }
	    else {
	      return 1;
	    }
	  }
	}

package com.poker.ranking;

import java.util.ArrayList;
import java.util.Collections;

import com.poker.card.Card;

/**
 * Get the player hand ranking
 * @author deepakarora
 *
 */
public class HandRanker {
  int[] rank = new int[13];
  int[] suit = new int[4];

  public int rankHand(Card[] cards) {
    if (straightFlush(cards)) return 9;
    else if (fourKind(cards)) return 8;
    else if (fullHouse(cards)) return 7;
    else if (flush(cards)) return 6;
    else if (straight(cards)) return 5;
    else if (threeKind(cards)) return 4;
    else if (twoPair(cards)) return 3;
    else if (onePair(cards)) return 2;
    return 1;
  }

  /**
   * five cards of consecutive rank with all the same suit
   * e.g. 5 spades, 6 spades, 7 spades, 8 spades, 9 spades
   */
  public boolean straightFlush(Card[] cards) {
    if (!straight(cards) && !flush(cards)) {
      return false;
    }
    Card[] sortedCards = sortHand(cards);
    int i = 0;
    /* check if cards (when sorted) are in consecutive order */
    while (i < 3) {
      if (sortedCards[i].getRank() - sortedCards[i+1].getRank() == -1) {
        if (sortedCards[i+1].getRank() - sortedCards[i+2].getRank() == -1) {
          if (sortedCards[i+2].getRank() - sortedCards[i+3].getRank() == -1) {
            if (sortedCards[i+3].getRank() - sortedCards[i+4].getRank() == -1) {
              break;
            }
          }
        }
      }
      i++;
    }
    /* check if cards all have same suit */
    if (sortedCards[i].getSuit() == sortedCards[i+1].getSuit()) {
      if (sortedCards[i+1].getSuit() == sortedCards[i+2].getSuit()) {
        if (sortedCards[i+2].getSuit() == sortedCards[i+3].getSuit()) {
          if (sortedCards[i+3].getSuit() == sortedCards[i+4].getSuit()) {
            return true;
          }
        }
      }
    }
    return false;
  }

  /**
   * four cards of one rank and any other card
   * e.g. Q spades, Q diamonds, Q hearts, Q clubs, 2 clubs
   */
  public boolean fourKind(Card[] cards) {
    fillRankArray(cards);
    for (int i = 0; i < rank.length; i++) {
      if (rank[i] == 4) {
        return true;
      }
    }
    return false;
  }

  /**
   * three matching cards of one rank and two matching cards of another rank
   * e.g. J clubs, J hearts, J spades, K clubs, K diamonds
   */
  public boolean fullHouse(Card[] cards) {
    fillRankArray(cards);
    /* check if there are 2 ranks that satisfy full house condition */
    boolean flag_one = false;
    boolean flag_two = false;

    for (int i = 0; i < rank.length; i++) {
      if (rank[i] == 3 && flag_one == false) {
        flag_one = true;
      }
      else if (rank[i] >= 2) {
        flag_two = true;
      }
    }
    return flag_one && flag_two;
  }

  /**
   * five cards of the same suit
   * e.g. 5 diamonds, 8 diamonds, 10 diamonds, J diamonds, K diamonds
   */
  public boolean flush(Card[] cards) {
    fillSuitArray(cards);
    for (int i = 0; i < suit.length; i++) {
      if (suit[i] >= 5) {
        return true;
      }
    }
    return false;
  }

  /**
   * five cards of consecutive rank
   * e.g. 2 clubs, 3 clubs, 4 hearts, 5 spades, 6 clubs
   */
  public boolean straight(Card[] cards) {
    fillRankArray(cards);
    int i = 0;
    while (i < rank.length-4) {
      if (rank[i] >= 1 && rank[i+1] >= 1 && rank[i+2] >= 1 && rank[i+3] >= 1 && rank[i+4] >= 1) {
        return true;
      }
      i++;
    }
    return false;
  }

  /**
   * three cards of the same rank
   * e.g. 6 clubs, 2 spades, 10 diamonds, 10 hearts, 10 clubs
   */
  public boolean threeKind(Card[] cards) {
    fillRankArray(cards);
    for (int i = 0; i < rank.length; i++) {
      if (rank[i] == 3) {
        return true;
      }

    }
    return false;
  }

  /**
   * two cards of the same rank plus two cards of the same (but different from the first pair) rank
   * e.g. 5 clubs, 7 spades, 7 hearts, 8 clubs, 8 diamonds
   */
  public boolean twoPair(Card[] cards) {
    fillRankArray(cards);
    int twoPair = 0;
    int i = 0;
    while (twoPair < 2 && i < rank.length) {
      if (rank[i] == 2) {
        twoPair++;
      }
      i++;
    }
    if (twoPair == 2) {
      return true;
    }
    return false;
  }

  /**
   * two cards of the same rank
   * e.g. 4 diamonds, 4 hearts, 6 clubs, K spades, Q diamonds
   */
  public boolean onePair(Card[] cards) {
    fillRankArray(cards);
    for (int i = 0; i < rank.length; i++) {
      if (rank[i] == 2) {
        return true;
      }
    }
    return false;
  }

  /**
   * find out how many Aces, 2's, 3's, ... there are
   */
  public void fillRankArray(Card[] cards) {
    for (int i = 0; i < rank.length; i++) {
      rank[i] = 0;
    }
    for (Card card : cards) {
      rank[card.getRank()] += 1;
    }
  }

  /**
   * find out how many spades, clubs, hearts, diamonds there are
   */
  public void fillSuitArray(Card[] cards) {
    for (int i = 0; i < suit.length; i++) {
      suit[i] = 0;
    }
    for (Card card : cards) {
      suit[card.getSuit()] += 1;
    }
  }

  /**
   * sort cards in ascending order based on rank (A's, 2's, 3's, ...)
   */
  public Card[] sortHand(Card[] cards) {
    ArrayList<Card> sortedList = new ArrayList<Card>();
    for (int i = 0; i < cards.length; i++) {
      sortedList.add(cards[i]);
    }
    Collections.sort(sortedList);
    Card[] sortedArray = new Card[7];
    for (int i = 0; i < sortedArray.length; i++) {
      sortedArray[i] = sortedList.get(i);
    }
    return sortedArray;
  }
}
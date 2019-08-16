package blackjackfundis;

/**
 * Original Code written by Janos @ Code Review Stack Exchange
 * Modified by Marc Lamentac & Steven Carleton
 */
public class Card
{
   private int suit;
   private int rank;
   private int value;
   private static String[] ranks = {"Joker", "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
   private static String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

   public Card (int rank, int suit)
   {
      this.suit = suit;
      this.rank = rank;
   }

   public String toString ()
   {
      return ranks[rank] + " of " + suits[suit];
   }

   public int getRank ()
   {
      return rank;
   }

   public int getSuit ()
   {
      return suit;
   }

   public int getValue ()
   {
      if (rank > 10) {
         value = 10;
      }
      else if (rank == 1) {
         value = 11;
      }
      else {
         value = rank;
      }
      return value;
   }

   public void setValue (int val)
   {
      this.value = val;
   }


}

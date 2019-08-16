package blackjackfundis;
import static blackjackfundis.HandValue.calcHandValue;
import static blackjackfundis.PlayerHit.hit;
import static blackjackfundis.Result.lose;
import static blackjackfundis.Result.win;
import static blackjackfundis.WentOver.checkBust;
import static blackjackfundis.YourBet.bet;
import java.util.*;
/**
 * @Marc Lamentac
 */
public class Blackjack
{
   protected static int cash;
   protected static int bet;
   protected static int AceCounter;
   protected static ArrayList<Card> hand;
   protected static int handvalue;
   protected static String name;

   public static void main (String[] args)
   {
      System.out.println("Hi! What is your name?");
      Scanner scan = new Scanner(System.in);
      name = scan.nextLine();
      System.out.println("Hello, " + name + ", lets play some BlackJack!");
      System.out.println("How much cash do you want to start with?");
      Scanner money = new Scanner(System.in);
      cash = money.nextInt();
      System.out.println("You start with cash: " + cash);
      while (cash > 0) {
         Deck deck = new Deck();//initialize deck, dealer, hands, and set the bet.
         deck.shuffle();
         AceCounter = 0;
         Dealer dealer = new Dealer(deck);
         List<Card> hand = new ArrayList<>();
         hand.add(deck.drawCard());
         hand.add(deck.drawCard());
         System.out.println("How much would you like to bet?");
         bet = bet(cash);
         System.out.println("Cash:" + (cash - bet));
         System.out.println("Money on the table:" + bet);
         System.out.println("Here is your hand: ");
         System.out.println(hand);
         int handvalue = calcHandValue(hand);
         System.out.println("The dealer is showing: ");
         dealer.showFirstCard();
         if (hasBlackJack(handvalue) && dealer.hasBlackJack())//check if both the user and dealer have blackjack.
         {
            push();
         }
         else if (hasBlackJack(handvalue))//check if the user has blackjack.
         {
            System.out.println("You have BlackJack!");
            System.out.println("You win 2x your money back!");
            cash = cash + bet;
            win();
         }
         else if (dealer.hasBlackJack())//check if the dealer has blackjack.
         {
            System.out.println("Here is the dealer's hand:");
            dealer.showHand();
            lose();
         }
         else {
            if (2 * bet < cash)//check if the user can double down.
            {
               System.out.println("Would you like to double down?");//allows the user to double down.
               Scanner doubledown = new Scanner(System.in);
               String doubled = doubledown.nextLine();
               while (!isYesOrNo(doubled)) {
                  System.out.println("Please enter yes or no.");
                  doubled = doubledown.nextLine();
               }
               if (doubled.equals("yes")) {
                  System.out.println("You have opted to double down!");
                  bet = 2 * bet;
                  System.out.println("Cash:" + (cash - bet));
                  System.out.println("Money on the table:" + bet);
               }
            }
            System.out.println("Would you like to hit or stand?");//ask if the user will hit or stand
            Scanner hitorstand = new Scanner(System.in);
            String hitter = hitorstand.nextLine();
            while (!isHitorStand(hitter)) {
               System.out.println("Please enter 'hit' or 'stand'.");
               hitter = hitorstand.nextLine();
            }
            while (hitter.equals("hit"))//hits the user as many times as he or she pleases.
            {
               hit(deck, hand);
               System.out.println("Your hand is now:");
               System.out.println(hand);
               handvalue = calcHandValue(hand);
               if (checkBust(handvalue))//checks if the user busted
               {
                  lose();
                  break;
               }
               if (handvalue <= 21 && hand.size() == 5)//checks for a five card trick.
               {
                  fiveCardTrick();
                  break;
               }
               System.out.println("Would you like to hit or stand?");
               hitter = hitorstand.nextLine();
            }
            if (hitter.equals("stand"))//lets the user stand.
            {
               int dealerhand = dealer.takeTurn(deck);//takes the turn for the dealer.
               System.out.println("");
               System.out.println("Here is the dealer's hand:");
               dealer.showHand();
               if (dealerhand > 21)//if the dealer busted, user wins.
               {
                  win();
               }
               else {
                  int you = 21 - handvalue;//check who is closer to 21 and determine winner
                  int deal = 21 - dealerhand;
                  if (you == deal) {
                     push();
                  }
                  if (you < deal) {
                     win();
                  }
                  if (deal < you) {
                     lose();
                  }
               }
            }
         }
         System.out.println("Would you like to play again?");//ask if the user wants to keep going
         Scanner yesorno = new Scanner(System.in);
         String answer = yesorno.nextLine();
         while (!isYesOrNo(answer)) {
            System.out.println("Please answer yes or no.");
            answer = yesorno.nextLine();
         }
         if (answer.equals("no")) {
            break;
         }
      }
      System.out.println("Your cash is: " + cash);//if user doesn't want to play or runs out of cash, either congratulates them on their winnings or lets them know
      if (cash == 0) {
         System.out.println("You ran out of cash!");
      }
      else {
         System.out.println("Enjoy your winnings, " + name + "!");
      }
   }

   public static boolean hasBlackJack (int handValue)
   {
      if (handValue == 21) {
         return true;
      }
      return false;
   }

   public static boolean isHitorStand (String hitter)
   {
      if (hitter.equals("hit") || hitter.equals("stand")) {
         return true;
      }
      return false;
   }

   public static boolean isYesOrNo (String answer)
   {
      if (answer.equals("yes") || answer.equals("no")) {
         return true;
      }
      return false;
   }

   private static void push ()
   {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   private static void fiveCardTrick ()
   {
      throw new UnsupportedOperationException("Not supported yet.");
   }



}

package blackjackfundis;
import java.util.Scanner;
/**
 * Original Code written by Janos @ Code Review Stack Exchange
 * Modified by Marc Lamentac & Steven Carleton
 */
public class YourBet extends Blackjack
{
   public static int bet (int cash)
   {
      Scanner sc = new Scanner(System.in);
      int bet = sc.nextInt();
      while (bet > cash) {
         System.out.println("You cannot bet more cash than you have!");
         System.out.println("How much would you like to bet?");
         bet = sc.nextInt();
      }
      return bet;
   }
}

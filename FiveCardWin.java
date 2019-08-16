package blackjackfundis;
import static blackjackfundis.Result.win;
/**
 * Original Code written by Janos @ Code Review Stack Exchange
 * Modified by Marc Lamentac & Steven Carleton
 */
public class FiveCardWin extends Blackjack
{
   public static void fivecardtrick ()
   {
      System.out.println("You have achieved a five card trick!");
      win();
   }
}

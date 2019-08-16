package blackjackfundis;
import static blackjackfundis.Result.win;
/**
 * @Marc Lamentac
 */
public class FiveCardWin extends Blackjack
{
   public static void fivecardtrick ()
   {
      System.out.println("You have achieved a five card trick!");
      win();
   }
}

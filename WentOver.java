package blackjackfundis;
/**
 * @Marc Lamentac
 */
public class WentOver extends Blackjack
{
   public static boolean checkBust (int handvalue)
   {
      if (handvalue > 21) {
         System.out.println("You have busted!");
         return true;
      }
      return false;
   }
}

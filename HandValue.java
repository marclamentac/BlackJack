package blackjackfundis;
import java.util.List;
/**
 * @Marc Lamentac
 */
public class HandValue extends Blackjack
{
   public static int calcHandValue (List<Card> hand)
   {
      Card[] aHand = new Card[] {};
      aHand = hand.toArray(aHand);
      int handvalue = 0;
      for (int i = 0; i < aHand.length; i++) {
         handvalue += aHand[i].getValue();
         if (aHand[i].getValue() == 11) {
            AceCounter++;
         }
         while (AceCounter > 0 && handvalue > 21) {
            handvalue -= 10;
            AceCounter--;
         }
      }
      return handvalue;
   }
}

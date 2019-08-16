package blackjackfundis;
import java.util.List;
/**
 * Original Code written by Janos @ Code Review Stack Exchange
 * Modified by Marc Lamentac & Steven Carleton
 */
public class PlayerHit extends Blackjack
{
   public static void hit (Deck deck, List<Card> hand)
   {
      hand.add(deck.drawCard());
      Card[] aHand = new Card[] {};
      aHand = hand.toArray(aHand);
      handvalue = 0;
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
   }

}

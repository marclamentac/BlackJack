package blackjackfundis;
/**
 * @Marc Lamentac
 */
public class Result extends Blackjack
{
   public static void win ()
   {
      System.out.println("Congratulations, you win!");
      cash = cash + bet;
      System.out.println("Cash: " + cash);
   }

   public static void lose ()
   {
      System.out.println("Sorry, you lose!");
      cash = cash - bet;
      System.out.println("Cash: " + cash);
   }

   public static void push ()
   {
      System.out.println("It's a push!");
      System.out.println("You get your money back.");
      System.out.println("Cash: " + cash);
   }

}

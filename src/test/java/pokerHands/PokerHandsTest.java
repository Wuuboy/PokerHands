package pokerHands;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class PokerHandsTest {
  @Test
  public void should_return_player1_win_when_input_and_3H(){

    Card card1 = new Card("2H");
    List<Card>cardList1 = Arrays.asList(card1);
    Card card2 = new Card("3H");
    List<Card>cardList2 = Arrays.asList(card2);

    PokerHands pokerHands = new PokerHands();
    String result = pokerHands.judge(cardList1,cardList2);

    assertEquals("player 1 win!",result);



  }

}
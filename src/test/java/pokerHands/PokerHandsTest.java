package pokerHands;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class PokerHandsTest {
  @Test
  public void should_return_player1_win_when_input_2H_and_3H() {

    Card card1 = new Card("3H");
    List<Card> cardList1 = Arrays.asList(card1);
    Card card2 = new Card("2H");
    List<Card> cardList2 = Arrays.asList(card2);

    PokerHands pokerHands = new PokerHands();
    String result = pokerHands.judge(cardList1, cardList2);

    assertEquals("player 1 win!", result);
  }

  @Test
  public void should_return_player1_win_when_input_2H_and_JH() {

    Card card1 = new Card("2H");
    List<Card> cardList1 = Arrays.asList(card1);
    Card card2 = new Card("JH");
    List<Card> cardList2 = Arrays.asList(card2);

    PokerHands pokerHands = new PokerHands();
    String result = pokerHands.judge(cardList1, cardList2);

    assertEquals("player 2 win!", result);
  }

  @Test
  public void should_return_player1_win_when_input_KH_and_JH() {

    Card card1 = new Card("KH");
    List<Card> cardList1 = Arrays.asList(card1);
    Card card2 = new Card("JH");
    List<Card> cardList2 = Arrays.asList(card2);

    PokerHands pokerHands = new PokerHands();
    String result = pokerHands.judge(cardList1, cardList2);

    assertEquals("player 1 win!", result);
  }
  @Test
  public void should_return_player1_win_when_input_QH_and_JH() {

    Card card1 = new Card("QH");
    List<Card> cardList1 = Arrays.asList(card1);
    Card card2 = new Card("KH");
    List<Card> cardList2 = Arrays.asList(card2);

    PokerHands pokerHands = new PokerHands();
    String result = pokerHands.judge(cardList1, cardList2);

    assertEquals("player 2 win!", result);
  }

}

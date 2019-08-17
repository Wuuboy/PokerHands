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
  @Test
  public void should_return_player1_win_when_input_2H_3D_5S_9C_8D_and_3H_3D_5S_9C_8D() {

    Card card1 = new Card("2H");
    Card card2 = new Card("3D");
    Card card3 = new Card("5S");
    Card card4 = new Card("9C");
    Card card5 = new Card("8D");
    List<Card>cardList1 = Arrays.asList(card1,card2,card3,card4,card5);
    Card card6 = new Card("3H");
    Card card7 = new Card("3D");
    Card card8 = new Card("5S");
    Card card9 = new Card("9C");
    Card card10 = new Card("8D");
    List<Card>cardList2 = Arrays.asList(card6,card7,card8,card9,card10);

    PokerHands pokerHands = new PokerHands();
    String result = pokerHands.judge(cardList1,cardList2);

    assertEquals("player 2 win!",result);
  }
  @Test
  public void should_return_player1_win_when_input_2H_4D_5S_9C_KD_and_2H_3D_5S_9C_KD() {

    Card card1 = new Card("2H");
    Card card2 = new Card("4D");
    Card card3 = new Card("5S");
    Card card4 = new Card("9C");
    Card card5 = new Card("KD");
    List<Card>cardList1 = Arrays.asList(card1,card2,card3,card4,card5);
    Card card6 = new Card("2H");
    Card card7 = new Card("3D");
    Card card8 = new Card("5S");
    Card card9 = new Card("9C");
    Card card10 = new Card("KD");
    List<Card>cardList2 = Arrays.asList(card6,card7,card8,card9,card10);

    PokerHands pokerHands = new PokerHands();
    String result = pokerHands.judge(cardList1,cardList2);

    assertEquals("player 1 win!",result);
  }
  @Test
  public void should_return_player1_win_when_input_2H_3D_5S_9C_AD_and_2H_2D_5S_9C_KD() {

    Card card1 = new Card("2H");
    Card card2 = new Card("3D");
    Card card3 = new Card("5S");
    Card card4 = new Card("9C");
    Card card5 = new Card("AD");
    List<Card>cardList1 = Arrays.asList(card1,card2,card3,card4,card5);
    Card card6 = new Card("2H");
    Card card7 = new Card("2D");
    Card card8 = new Card("5S");
    Card card9 = new Card("9C");
    Card card10 = new Card("KD");
    List<Card>cardList2 = Arrays.asList(card6,card7,card8,card9,card10);

    PokerHands pokerHands = new PokerHands();
    String result = pokerHands.judge(cardList1,cardList2);

    assertEquals("player 2 win!",result);
  }
  @Test
  public void should_return_player1_win_when_input_2H_2D_5S_9C_KD_and_3H_3D_5S_9C_KD() {

    Card card1 = new Card("2H");
    Card card2 = new Card("2D");
    Card card3 = new Card("5S");
    Card card4 = new Card("9C");
    Card card5 = new Card("KD");
    List<Card>cardList1 = Arrays.asList(card1,card2,card3,card4,card5);
    Card card6 = new Card("3H");
    Card card7 = new Card("3D");
    Card card8 = new Card("5S");
    Card card9 = new Card("9C");
    Card card10 = new Card("KD");
    List<Card>cardList2 = Arrays.asList(card6,card7,card8,card9,card10);

    PokerHands pokerHands = new PokerHands();
    String result = pokerHands.judge(cardList1,cardList2);

    assertEquals("player 2 win!",result);
  }
  @Test
  public void should_return_player1_win_when_input_2H_2D_5S_9C_9D_and_2H_2D_5S_9C_KD() {

    Card card1 = new Card("2H");
    Card card2 = new Card("2D");
    Card card3 = new Card("5S");
    Card card4 = new Card("9C");
    Card card5 = new Card("9D");
    List<Card>cardList1 = Arrays.asList(card1,card2,card3,card4,card5);
    Card card6 = new Card("2H");
    Card card7 = new Card("3D");
    Card card8 = new Card("5S");
    Card card9 = new Card("9C");
    Card card10 = new Card("KD");
    List<Card>cardList2 = Arrays.asList(card6,card7,card8,card9,card10);

    PokerHands pokerHands = new PokerHands();
    String result = pokerHands.judge(cardList1,cardList2);

    assertEquals("player 2 win!",result);
  }
}

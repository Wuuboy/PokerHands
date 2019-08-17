package pokerHands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PokerHands {

  public String judge(List<Card> cardList1, List<Card> cardList2) {
    String player1CardNum = transferWordToNum(cardList1.get(0).getCardName().substring(0,1));
    String player2CardNum = transferWordToNum(cardList2.get(0).getCardName().substring(0,1));
    int resultNum = player1CardNum.compareTo(player2CardNum);
    if (resultNum > 0) {
      return "player 1 win!";
    }else{
      return "player 2 win!";
    }
  }

  private String transferWordToNum(String cardNum){
    switch (cardNum){
      case "J":
        cardNum = "11";
        break;
      case "Q":
        cardNum = "12";
        break;
      case "K":
        cardNum = "13";
        break;
      case "A":
        cardNum = "14";
        break;
      default:
        cardNum = cardNum;
    }
    return cardNum;
  }
}

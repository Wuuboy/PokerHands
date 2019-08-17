package pokerHands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PokerHands {

  public String judge(List<Card> cardList1, List<Card> cardList2) {
    Integer player1CardNum = addressInput(cardList1).get(0);
    Integer player2CardNum = addressInput(cardList2).get(0);
    int resultNum = player1CardNum.compareTo(player2CardNum);
    if (resultNum > 0) {
      return "player 1 win!";
    }else{
      return "player 2 win!";
    }
  }

  private List<Integer >addressInput(List<Card>cardList){
    List<Integer>adressedArrayInput = new ArrayList<>();
    cardList.stream().forEach(card -> adressedArrayInput
        .add(transferWordToNum(card.getCardName().substring(0,1))));
    Collections.sort(adressedArrayInput);
    return adressedArrayInput;
  }


  private Integer transferWordToNum(String cardNum){
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
    return Integer.valueOf(cardNum);
  }
}

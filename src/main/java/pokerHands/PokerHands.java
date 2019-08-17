package pokerHands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PokerHands {

  public String judge(List<Card> cardList1, List<Card> cardList2) {
    //    Integer player1CardNum = addressInput(cardList1).get(0);
    //    Integer player2CardNum = addressInput(cardList2).get(0);
    int resultNum=1;
    List<Integer> player1CardNumList = addressInput(cardList1);
    List<Integer> player2CardNumList = addressInput(cardList2);
    //    player1CardNumList.stream().forEach(player1CardNum->{
    //      player2CardNumList.stream().forEach(player2CardNum->{
    //        resultNum = player1CardNum.compareTo(player2CardNum);
    //      });
    //    });
    for (int i = 0; i < player1CardNumList.size(); i++) {
      resultNum = player1CardNumList.get(i).compareTo(player2CardNumList.get(i));
      if (resultNum == 0) {
        continue;
      }
      break;
    }
    //    int resultNum = player1CardNum.compareTo(player2CardNum);
    if (resultNum > 0) {
      return "player 1 win!";
    } else if (resultNum < 0){
      return "player 2 win!";
    }else {
      return "peace!";
    }
  }

  private List<Integer> addressInput(List<Card> cardList) {
    List<Integer> adressedArrayInput = new ArrayList<>();
    cardList.stream()
        .forEach(
            card -> adressedArrayInput.add(transferWordToNum(card.getCardName().substring(0, 1))));
    Collections.sort(adressedArrayInput);
    return adressedArrayInput;
  }

  private Integer transferWordToNum(String cardNum) {
    switch (cardNum) {
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

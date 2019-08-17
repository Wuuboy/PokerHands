package pokerHands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.omg.CORBA.PRIVATE_MEMBER;

public class PokerHands {

  public String judge(List<Card> cardList1, List<Card> cardList2) {
    int resultNum = 1;
    List<Integer> player1CardNumList = addressInput(cardList1);
    List<Integer> player2CardNumList = addressInput(cardList2);
    for (int i = 0; i < player1CardNumList.size(); i++) {
      resultNum = player1CardNumList.get(i).compareTo(player2CardNumList.get(i));
      if (resultNum == 0) {
        continue;
      }
      break;
    }
    if (existPair(player1CardNumList)){
      return "player 1 win!";
    }else if (existPair(player2CardNumList)){
      return "player 2 win!";
    }else {
      if (resultNum > 0) {
        return "player 1 win!";
      } else if (resultNum < 0) {
        return "player 2 win!";
      } else {
        return "peace!";
      }
    }
  }

  private boolean existPair(List<Integer> playerCardNumList) {
    Map<Integer, Integer> map = new HashMap<>();
    playerCardNumList.stream().forEach(cardNum->{
      Integer num = map.get(cardNum);
      map.put(cardNum, num == null ? 1 : num + 1);
    });
    if (map.containsValue(2)){
      return true;
    }
    return false;
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

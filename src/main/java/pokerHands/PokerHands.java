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
    boolean player1ExistPair = existPair(player1CardNumList).entrySet().iterator().next().getValue();
    boolean player2ExistPair = existPair(player2CardNumList).entrySet().iterator().next().getValue();
    Integer player1ExistPairValue = existPair(player1CardNumList).entrySet().iterator().next().getKey();
    Integer player2ExistPairValue = existPair(player2CardNumList).entrySet().iterator().next().getKey();
    if (player1ExistPair&&!player2ExistPair){
      return "player 1 win!";
    }else if (!player1ExistPair&&player2ExistPair){
      return "player 2 win!";
    }else if (player1ExistPair&&player2ExistPair){
      if (player1ExistPairValue>player2ExistPairValue){
        return "player 1 win!";
      }else {
        return "player 2 win!";
      }
    } else{
      if (resultNum > 0) {
        return "player 1 win!";
      } else if (resultNum < 0) {
        return "player 2 win!";
      } else {
        return "peace!";
      }
    }
  }

  private Map<Integer,Boolean> existPair(List<Integer> playerCardNumList) {
    Map<Integer,Boolean> result = new HashMap<>();
    Map<Integer, Integer> map = new HashMap<>();
    playerCardNumList.stream().forEach(cardNum->{
      Integer num = map.get(cardNum);
      map.put(cardNum, num == null ? 1 : num + 1);
    });
    map.entrySet()
        .stream()
        .filter(e->e.getValue()==2)
        .forEach(e->result.put(e.getValue(),true));
//    if (map.containsValue(2)){
//      result.put()
//      return true;
//    }
    return result;
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

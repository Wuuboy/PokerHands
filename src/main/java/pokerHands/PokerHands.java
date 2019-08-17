package pokerHands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
    Map<Integer,Integer>player1ExistPairMap = existPair(player1CardNumList);
    Map<Integer,Integer>player2ExistPairMap = existPair(player2CardNumList);
    int player1ExistPairMapSize = player1ExistPairMap.size();
    int player2ExistPairMapSize = player2ExistPairMap.size();

    if (player1ExistPairMapSize==0&&player2ExistPairMapSize==0){
      if (resultNum > 0) {
        return "player 1 win!";
      } else if (resultNum < 0) {
        return "player 2 win!";
      } else {
        return "peace!";
      }
    }
    else {
      if (player2ExistPairMapSize==0){
        return "player 1 win!";
      }else if (player1ExistPairMapSize==0){
        return "player 2 win!";
      }else {
        if (player1ExistPairMap.containsValue(3)&&!player2ExistPairMap.containsValue(3)){
          return "player 1 win!";
        }else if (!player1ExistPairMap.containsValue(3)&&player2ExistPairMap.containsValue(3)){
          return "player 2 win!";
        }else {
          Entry<Integer, Integer> player1ExistPairFirstItem = player1ExistPairMap.entrySet().iterator().next();
          Entry<Integer, Integer> player2ExistPairFirstItem = player2ExistPairMap.entrySet().iterator().next();
          Integer player1ExistPair =player1ExistPairFirstItem.getValue();
          Integer player2ExistPair = player2ExistPairFirstItem.getValue();
          Integer player1ExistPairValue = player1ExistPairFirstItem.getKey();
          Integer player2ExistPairValue = player2ExistPairFirstItem.getKey();
          if (player1ExistPairMapSize>player2ExistPairMapSize){
            return "player 1 win!";
          }else if (player1ExistPairMapSize==player2ExistPairMapSize){
            return (player1ExistPairValue>player2ExistPairValue)?"player 1 win!":"player 2 win!";
          }else {
            return "player 2 win!";
          }
        }

      }
    }
  }

  private Map<Integer,Integer> existPair(List<Integer> playerCardNumList) {
    Map<Integer,Integer> result = new HashMap<>();
    Map<Integer, Integer> map = new HashMap<>();
    playerCardNumList.stream().forEach(cardNum->{
      Integer num = map.get(cardNum);
      map.put(cardNum, num == null ? 1 : num + 1);
    });
    map.entrySet()
        .stream()
        .filter(e->e.getValue()==2)
        .forEach(e->result.put(e.getValue(),2));
    map.entrySet()
        .stream()
        .filter(e->e.getValue()==3)
        .forEach(e->result.put(e.getValue(),3));
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

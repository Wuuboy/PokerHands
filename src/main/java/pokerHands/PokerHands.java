package pokerHands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
    Map<Integer, Integer> player1ExistPairMap = existPair(player1CardNumList);
    Map<Integer, Integer> player2ExistPairMap = existPair(player2CardNumList);
    int player1ExistPairMapSize = player1ExistPairMap.size();
    int player2ExistPairMapSize = player2ExistPairMap.size();

    if (isConstant(player1CardNumList) && !isConstant(player2CardNumList)) {
      return "player 1 win!";
    } else if (!isConstant(player1CardNumList) && isConstant(player2CardNumList)) {
      return "player 2 win!";
    } else if (isConstant(player1CardNumList) && isConstant(player2CardNumList)) {
      return isConstantWithSameColor(cardList1) ? "player 1 win!" : "player 2 win!";
    } else {
      if (player1ExistPairMapSize == 0 && player2ExistPairMapSize == 0) {
        if (resultNum > 0) {
          return "player 1 win!";
        } else if (resultNum < 0) {
          return "player 2 win!";
        } else {
          return "peace!";
        }
      } else {
        if (player2ExistPairMapSize == 0) {
          return "player 1 win!";
        } else if (player1ExistPairMapSize == 0) {
          return "player 2 win!";
        } else {
          if (player1ExistPairMap.containsValue(4) && !player2ExistPairMap.containsValue(4)) {
            return "player 1 win!";
          } else if (!player1ExistPairMap.containsValue(4)
              && player2ExistPairMap.containsValue(4)) {
            return "player 2 win!";
          } else if (player1ExistPairMap.containsValue(4) && player2ExistPairMap.containsValue(4)) {
            return player1ExistPairMap.entrySet().stream().filter(e -> e.getValue() == 4)
                        .findFirst().get().getValue()
                    > player2ExistPairMap.entrySet().stream().filter(e -> e.getValue() == 4)
                        .findFirst().get().getValue()
                ? "player 1 win!" : "player 2 win!";
          } else {
            if (player1ExistPairMap.containsValue(3) && !player2ExistPairMap.containsValue(3)) {
              return "player 1 win!";
            } else if (!player1ExistPairMap.containsValue(3)
                && player2ExistPairMap.containsValue(3)) {
              return "player 2 win!";
            } else if (player1ExistPairMap.containsValue(3)
                && player2ExistPairMap.containsValue(3)) {
              return player1ExistPairMap.entrySet().stream().filter(e -> e.getValue() == 3)
                          .findFirst().get().getValue()
                  > player2ExistPairMap.entrySet().stream().filter(e -> e.getValue() == 3)
                          .findFirst().get().getValue()
                  ? "player 1 win!" : "player 2 win!";
            } else {
              Entry<Integer, Integer> player1ExistPairFirstItem =
                  player1ExistPairMap.entrySet().iterator().next();
              Entry<Integer, Integer> player2ExistPairFirstItem =
                  player2ExistPairMap.entrySet().iterator().next();
              Integer player1ExistPairValue = player1ExistPairFirstItem.getKey();
              Integer player2ExistPairValue = player2ExistPairFirstItem.getKey();
              if (player1ExistPairMapSize > player2ExistPairMapSize) {
                return "player 1 win!";
              } else if (player1ExistPairMapSize == player2ExistPairMapSize) {
                return (player1ExistPairValue > player2ExistPairValue)
                    ? "player 1 win!" : "player 2 win!";
              } else {
                return "player 2 win!";
              }
            }
          }
        }
      }
    }
  }

  private boolean isConstantWithSameColor(List<Card> cardList) {
    Set<String> player1Set = new HashSet<>();
    for (Card card : cardList) {
      player1Set.add(card.getCardName().substring(1, 2));
    }
    return player1Set.size() == 1;
  }

  private boolean isConstant(List<Integer> playerCardNumList) {
    int playerCardNumListSize = playerCardNumList.size();
    if (playerCardNumList.get(playerCardNumListSize - 1) - playerCardNumList.get(0) != 4) {
      return false;
    }
    boolean isConstant = false;
    for (int i = 1; i < playerCardNumListSize - 1; i++) {
      if (playerCardNumList.get(i) * 2
          != playerCardNumList.get(i - 1) + playerCardNumList.get(i + 1)) {
        isConstant = false;
        break;
      }
      if (Math.abs(playerCardNumList.get(i + 1) - playerCardNumList.get(i)) != 1) {
        isConstant = false;
        break;
      }
      if ((playerCardNumList.get(i + 1) - playerCardNumList.get(i))
          != (playerCardNumList.get(i) - playerCardNumList.get(i - 1))) {
        isConstant = false;
        break;
      }
      isConstant = true;
      continue;
    }
    return isConstant;
  }

  private Map<Integer, Integer> existPair(List<Integer> playerCardNumList) {
    Map<Integer, Integer> result = new HashMap<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (Integer cardNum : playerCardNumList) {
      Integer num = map.get(cardNum);
      map.put(cardNum, num == null ? 1 : num + 1);
    }
    map.entrySet().stream().filter(e -> e.getValue() == 2).forEach(e -> result.put(e.getKey(), 2));
    map.entrySet().stream().filter(e -> e.getValue() == 3).forEach(e -> result.put(e.getKey(), 3));
    map.entrySet().stream().filter(e -> e.getValue() == 4).forEach(e -> result.put(e.getKey(), 4));
    return result;
  }

  private List<Integer> addressInput(List<Card> cardList) {
    List<Integer> adressedArrayInput = new ArrayList<>();
    for (Card card : cardList) {
      adressedArrayInput.add(transferWordToNum(card.getCardName().substring(0, 1)));
    }
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

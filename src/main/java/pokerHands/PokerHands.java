package pokerHands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PokerHands {

  public String judge(List<Card> cardList1, List<Card> cardList2) {
    int resultNum = cardList1
        .get(0)
        .getCardName()
        .substring(0, 1)
        .compareTo(cardList2.get(0).getCardName().substring(0, 1));
    if (resultNum > 0) {
      return "player 1 win!";
    }
    return "";
  }
}

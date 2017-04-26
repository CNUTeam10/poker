package com.edu.cnu.poker;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cse on 2017-04-17.
 */
public class Evaluator {
    public int evaluate(List<Card> cardList) {
        Map<Suit, Integer> tempMap = new HashMap<Suit, Integer>()

        //무늬별로 갯수에 대하 정보를 tempMap에 집어넣음
        for (Card card : cardList) {
            if (tempMap.containsKey(card.getSuit())) {
                Integer count = tempMap.get(card.getSuit());
                count = new Integer(count.intValue() + 1);
                tempMap.put(card.getSuit(), count);
            } else {
                tempMap.put(card.getSuit(), new Integer(1));
            }
        }

//        for (Suit key : tempMap.keySet()) {
//            if (tempMap.get(key) == 5) {
//                return 1;
//            }
//        }

        if (check_continuity()) {
            if (check_suits_are_all_same()) {
                if (is_royalStraightFlush()) return 1;
                else if (is_backStraightFlush()) return 2;
                else return 3;
            } else {
                if (is_mountain()) return 7;
                else if (is_backStraight()) return 8;
            }
        } else if (check_suits_are_all_same()) return 6;
        else {
            List<Card> sortCard;
            sortCard = sort(cardList);
            int i , j;
            int sameNumber1 = 0, sameNumber2 = 0;
            for(i = 0; i<4;i++) {
                for (j = 1 + i; j < 5; j++) {
                    if (sortCard.get(i).getRank == sortCard.get(j).getRank) {
                        while (sortCard.get(i).getRank == sortCard.get(j).getRank) {
                            sameNumber1++;
                            if(sortCard.get(i).getRank!=sortCard.get(j).getRank)
                                break;
                        }
                    }

                }
            }
            for (j = 1 + i; j < 5; j++)
                if (sortCard.get(i).getRank == sortCard.get(j).getRank)
                    sameNumber2++;

            if (sameNumber1 == 4||sameNumber2==4)
                return 4;
            else if ((sameNumber1 == 3 && sameNumber2 == 2) || (sameNumber1 == 2 && sameNumber2 == 3))
                return 3;
            else if (sameNumber1 == 2 && sameNumber2 == 2)
                return 10;
            else if (sameNumber1 == 2||sameNumber2 == 2)
                return 12;
            else
                return 13;
        }
        return 0;
    }
        public List<Card> sort(List<Card> cardList) {
            Collections.sort(cardList);

            return cardList;
        }
    /*
    public boolean check_continuity() {}
    public boolean check_suits_are_all_same() {}
    public boolean is_royalStraightFlush() {}
    public boolean is_backStraightFlush() {}
    public boolean is_mountain() {}
    public boolean is_backStraight() {}
    */
}

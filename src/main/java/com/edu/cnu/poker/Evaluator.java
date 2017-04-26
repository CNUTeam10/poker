package com.edu.cnu.poker;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cse on 2017-04-17.
 */
public class Evaluator {
    public int evaluate(List<Card> cardList) {
        Map<Suit, Integer> tempMap = new HashMap<Suit, Integer>();
        Card[] cards = new Card[5];
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
        if(check_continuity(cardList)){
            if (check_suits_are_all_same(tempMap)) {
                if (is_royalStraightFlush()) return 1;
                else if (is_backStraightFlush()) return 2;
                else return 3;
            }
            else {
                if (is_mountain()) return 7;
                else if (is_backStraight()) return 8;
            }
        }

        else if (check_suits_are_all_same()) return 6;
        return 0;
    }

    public boolean check_continuity(List<Card> cardList) {
    }
    public boolean check_suits_are_all_same(Map<> tempMap) {}
    public boolean is_royalStraightFlush() {}
    public boolean is_backStraightFlush() {}
    public boolean is_mountain() {}
    public boolean is_backStraight() {}
}

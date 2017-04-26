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
        Map<Suit, Integer> suitMap = new HashMap<Suit, Integer>();

        for (Card card : cardList) {
            if (suitMap.containsKey(card.getSuit())) {
                Integer count = suitMap.get(card.getSuit());
                count = new Integer(count.intValue() + 1);
                suitMap.put(card.getSuit(), count);
            } else {
                suitMap.put(card.getSuit(), new Integer(1));
            }
        }

        /*if (check_continuity(cardList)) {
            if (check_suits_are_all_same()) {
                if (is_royalStraightFlush()) return 1;
                else if (is_backStraightFlush()) return 2;
                else return 3;
            } else {

            }
        } else if (check_suits_are_all_same()) {
            if (is_mountain()) return 7;
            else if (is_backStraight()) return 8;
            else return 9;
        }*/
        return 0;
    }

    public List<Card> sort(List<Card> cardList) {
        Collections.sort(cardList);

        return cardList;
    }

    public boolean check_continuity(List<Card> cardList) {
        return false;
    }

    public boolean check_suits_are_all_same(Map<Suit, Integer> suitMap) {
        for (Suit key : suitMap.keySet()) {
            if (suitMap.get(key) == 5)
                return true;
        }

        return false;
    }

    public boolean is_royalStraightFlush() {
        return false;
    }

    public boolean is_backStraightFlush() {
        return false;
    }

    public boolean is_mountain() {
        return false;
    }

    public boolean is_backStraight() {
        return false;
    }
}
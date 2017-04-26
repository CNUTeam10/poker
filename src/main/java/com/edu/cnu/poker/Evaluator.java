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


        if (check_continuity(cardList)) {
            if (check_suits_are_all_same(suitMap)) {
                if (is_royalStraightFlush(cardList)) return 1;
                else if (is_backStraightFlush(cardList)) return 2;
                else return 3;
            }
            else {

            }
        }

        else if (check_suits_are_all_same(suitMap)) {
            if (is_mountain(cardList)) return 7;
            else if (is_backStraight(cardList)) return 8;
            else return 9;
        }
        return 0;
    }

    public boolean check_continuity(List<Card> cardList) {
        if (is_mountain(cardList) || is_backStraight(cardList) || cardList.get(4).getRank() - cardList.get(0).getRank() == 4)
            return true;

        return true;
    }
    public boolean check_suits_are_all_same(Map<Suit, Integer> suitMap) {
        for (Suit key : suitMap.keySet()) {
            if (suitMap.get(key) == 5) {
                return true;
            }
        }
        return false;
    }
    public boolean is_royalStraightFlush(List<Card> cardList) {
        int royalStraightFlush[] = {1, 10, 11, 12, 13};

        for(int i=0; i<cardList.size(); i++){
            if (cardList.get(i).getRank() != royalStraightFlush[i])
                return false;
        }
        return true;
    }
    public boolean is_backStraightFlush(List<Card> cardList) {
        for(int i=0; i<cardList.size()-1; i++){
            if (cardList.get(i+1).getRank() - cardList.get(i).getRank() != 1)
                return false;
        }
        return true;
    }
    public boolean is_mountain(List<Card> cardList) {
        int mountain[] = {1, 10, 11, 12, 13};

        for(int i=0; i<cardList.size(); i++){
            if (cardList.get(i).getRank() != mountain[i])
                return false;
        }
        return true;
    }
    public boolean is_backStraight(List<Card> cardList) {
        for(int i=0; i<cardList.size()-1; i++){
            if (cardList.get(i+1).getRank() - cardList.get(i).getRank() != 1)
                return false;
        }
        return true;
    }
}

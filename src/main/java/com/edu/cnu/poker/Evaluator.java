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
        Map<Suit, Integer> rankMap = new HashMap<Suit, Integer>();
        Map<Suit, Integer> suitMap = new HashMap<Suit, Integer>();

        //무늬별로 갯수에 대하 정보를 tempMap에 집어넣음
        for (Card card : cardList) {
            if (suitMap.containsKey(card.getSuit())) {
                Integer count = suitMap.get(card.getSuit());
                count = new Integer(count.intValue() + 1);
                suitMap.put(card.getSuit(), count);
            } else {
                suitMap.put(card.getSuit(), new Integer(1));
            }
        }
      
        for(Card card : cardList) {
            if (rankMap.containsKey(card.getRank())) {
                Integer count = rankMap.get(card.getRank());
                count = new Integer(count.intValue() + 1);
                rankMap.put(card.getRank(), count);
            } else
                rankMap.put(card.getRank(), new Integer(1));
              
        this.sort(cardList);

        if (check_continuity(cardList)) {
            if (check_suits_are_all_same(suitMap)) {
                if (is_royalStraightFlush())
                    return 1;
                else if (is_backStraightFlush())
                    return 2;
                else
                    return 3;
            } else {
                if (is_mountain())
                    return 7;
                else if (is_backStraight())
                    return 8;
                else
                   return 9;
            }
        } else if (check_suits_are_all_same(suitMap))
              return 6;
        else {
            for (Integer key : rankMap.keySet()) {
                if (is_fourCard(rankMap)) return 4;
                else if (is_fullHouse(rankMap)) return 5;
                else if (is_triple(rankMap)) return  10;
                else if (is_twoPair(rankMap)) return  11;
                else if (is_onePair(rankMap)) return  12;
                else return 13;
            }
        }
        return 0;
    }
        public List<Card> sort(List<Card> cardList) {
            Collections.sort(cardList);

            return cardList;
        }
    public boolean is_fourCard(Map<Integer,Integer> rankMap) {
        for (Integer key : rankMap.keySet())
            if (rankMap.get(key) == 4) return true;

        return false;
    }
    public boolean is_fullHouse(Map<Integer,Integer> rankMap) {
        int numberOfSet=0;
        for (Integer key : rankMap.keySet())
            if (rankMap.get(key) == 3) numberOfSet++;

        if (numberOfSet == 2) return true;

        return false;
    }
    public boolean is_triple(Map<Integer,Integer> rankMap) {
        for (Integer key : rankMap.keySet())
            if (rankMap.get(key) == 3) return true;

        return false;
    }
    public boolean is_twoPair(Map<Integer,Integer> rankMap) {
        int numberOfSet=0;
        for (Integer key : rankMap.keySet())
            if (rankMap.get(key) == 2) numberOfSet++;

        if (numberOfSet == 2) return true;

        return false;
    }
    public boolean is_onePair(Map<Integer,Integer> rankMap) {
        for (Integer key : rankMap.keySet())
            if (rankMap.get(key) == 1) return true;

        return false;
    }

    public boolean check_continuity(List<Card> cardList) {
        if (is_mountain() || is_backStraight())
            return true;
        for (int i = 0; i < 5; i++)
            if (cardList.get(i + 1).getRank() - cardList.get(i).getRank() != 1)
                return false;

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

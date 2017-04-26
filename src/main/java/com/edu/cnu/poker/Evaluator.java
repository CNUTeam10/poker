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

        for(Card card : cardList) {
            if (rankMap.containsKey(card.getRank())) {
                Integer count = rankMap.get(card.getRank());
                count = new Integer(count.intValue() + 1);
                rankMap.put(card.getRank(), count);
            } else {
                rankMap.put(card.getRank(), new Integer(1));
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
    }

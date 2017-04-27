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
        Map<Integer, Integer> rankMap = new HashMap<Integer, Integer>();

        for (Card card : cardList) {
            if (suitMap.containsKey(card.getSuit())) {
                Integer count = suitMap.get(card.getSuit());
                count = new Integer(count.intValue() + 1);
                suitMap.put(card.getSuit(), count);
            } else {
                suitMap.put(card.getSuit(), new Integer(1));
            }
        }

        for (Card card : cardList) {
            if (rankMap.containsKey(card.getRank())) {
                Integer count = rankMap.get(card.getRank());
                count = new Integer(count.intValue() + 1);
                rankMap.put(card.getRank(), count);
            } else {
                rankMap.put(card.getRank(), new Integer(1));
            }
        }

        this.sort(cardList);

        if (check_continuity(cardList)) {
            if (is_royalStraightFlush_or_mountain(cardList)) {
                if (check_suits_are_all_same(suitMap)) return 1;

                return 7;
            } else if (is_backStraightFlush_or_backStraight(cardList)) {
                if (check_suits_are_all_same(suitMap)) return 2;

                return 8;
            } else {
                if (check_suits_are_all_same(suitMap)) return 3;

                return 9;
            }
        } else if (check_suits_are_all_same(suitMap)) return 6;

        else {
            for (Integer key : rankMap.keySet()) {
                if (is_fourCard(rankMap)) return 4;
                else if (is_fullHouse(rankMap)) return 5;
                else if (is_triple(rankMap)) return 10;
                else if (is_twoPair(rankMap)) return 11;
                else if (is_onePair(rankMap)) return 12;
                else return 13;
            }
        }

        return 0;
    }


    public List<Card> sort(List<Card> cardList) {
        Collections.sort(cardList);

        return cardList;
    }

    public boolean check_continuity(List<Card> cardList) {
        if (is_royalStraightFlush_or_mountain(cardList) || is_backStraightFlush_or_backStraight(cardList))
            return true;
        for (int i = 0; i < 4; i++)
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

    public boolean is_royalStraightFlush_or_mountain(List<Card> cardList) {
        int temp[] = {1, 10, 11, 12, 13};

        for (int i = 0; i < cardList.size(); i++) {
            if (cardList.get(i).getRank() != temp[i])
                return false;
        }
        return true;
    }

    public boolean is_backStraightFlush_or_backStraight(List<Card> cardList) {
        if (cardList.get(0).getRank() == 1) {
            for (int i = 0; i < cardList.size() - 1; i++) {
                if (cardList.get(i + 1).getRank() - cardList.get(i).getRank() != 1)
                    return false;
            }
            return true;
        }
        return false;
    }

    public boolean is_fourCard(Map<Integer, Integer> rankMap) {
        for (Integer key : rankMap.keySet())
            if (rankMap.get(key) == 4) return true;

        return false;
    }

    public boolean is_fullHouse(Map<Integer, Integer> rankMap) {
        int triple = 0;
        int pair = 0;
        for (Integer key : rankMap.keySet()) {
            if (rankMap.get(key) == 3)
                triple = 1;
            if (rankMap.get(key) == 2)
                pair = 1;
        }
        if (triple == 1 && pair == 1)
            return true;

        return false;
    }

    public boolean is_triple(Map<Integer, Integer> rankMap) {
        for (Integer key : rankMap.keySet())
            if (rankMap.get(key) == 3) return true;

        return false;
    }

    public boolean is_twoPair(Map<Integer, Integer> rankMap) {
        int numberOfSet = 0;
        for (Integer key : rankMap.keySet())
            if (rankMap.get(key) == 2) numberOfSet++;

        if (numberOfSet == 2) return true;

        return false;
    }

    public boolean is_onePair(Map<Integer, Integer> rankMap) {
        for (Integer key : rankMap.keySet())
            if (rankMap.get(key) == 2) return true;

        return false;
    }

    public Player sameRankEvaluate(Player player1, Player player2, int rank) {
        if (rank == 1 || rank == 2 || rank == 7 || rank == 8)
            return compareFlushSuit(player1, player2);
        else {
            if (rank == 3 || rank == 6 || rank == 9 || rank == 13)
                return compareEntireRank(player1, player2);
            else if (rank == 4 || rank == 5 || rank == 10)
                return compareCenterCard(player1, player2);
            else if (rank == 11)
                return compareTwopair(player1, player2);
            else
                return compareOnepair(player1, player2);
        }
    }

    private Player compareFlushSuit(Player player1, Player player2) {
        if (suitRank(player1.getPlayer_hand().getCardList().get(0).getSuit()) < suitRank(player2.getPlayer_hand().getCardList().get(0).getSuit()))
            return player1;
        else
            return player2;
    }

    private Player compareEntireRank(Player player1, Player player2) {
        int player1Acheck = player1.getPlayer_hand().getCardList().get(0).getRank();
        int player2Acheck = player2.getPlayer_hand().getCardList().get(0).getRank();
        Card player1FourthCard = player1.getPlayer_hand().getCardList().get(4);
        Card player2FourthCard = player2.getPlayer_hand().getCardList().get(4);

        if ((player1Acheck == 1 && player2Acheck == 1) || (player1FourthCard.getRank() == player2FourthCard.getRank()))
            return compareFlushSuit(player1, player2);
        if (player1Acheck == 1 && player2Acheck == 0)
            return player1;
        if (player1Acheck == 0 && player2Acheck == 1)
            return player2;
        if (player1FourthCard.getRank() < player2FourthCard.getRank())
            return player2;
        else
            return player1;
    }

    private Player compareCenterCard(Player player1, Player player2) {
        Card player1ThirdCard = player1.getPlayer_hand().getCardList().get(3);
        Card player2ThirdCard = player2.getPlayer_hand().getCardList().get(3);

        if (player1ThirdCard.getRank() == 1)
            return player1;
        if (player2ThirdCard.getRank() == 1)
            return player2;
        if (player1ThirdCard.getRank() > player2ThirdCard.getRank())
            return player1;
        else if (player1ThirdCard.getRank() < player2ThirdCard.getRank())
            return player2;
        else {
            if (suitRank(player1ThirdCard.getSuit()) < suitRank(player2ThirdCard.getSuit()))
                return player1;
            else
                return player2;
        }
    }

    private Player compareTwopair(Player player1, Player player2) {
        Card player1SecondCard = player1.getPlayer_hand().getCardList().get(2);
        Card player2SecondCard = player2.getPlayer_hand().getCardList().get(2);
        Card player1FourthCard = player1.getPlayer_hand().getCardList().get(4);
        Card player2FourthCard = player2.getPlayer_hand().getCardList().get(4);
        Card player1BigCard;
        Card player2BigCard;

        if (player1SecondCard.getRank() > player1FourthCard.getRank())
            player1BigCard = player1SecondCard;
        else
            player1BigCard = player1FourthCard;
        if (player2SecondCard.getRank() > player2FourthCard.getRank())
            player2BigCard = player2SecondCard;
        else
            player2BigCard = player2FourthCard;

        if (player1BigCard.getRank() >= player2BigCard.getRank())
            return player1;
        else
            return player2;
    }

    private Player compareOnepair(Player player1, Player player2) {
        int checkPair1[] = new int[13];
        int checkPair2[] = new int[13];
        int player1PairIndex = 0;
        int player2PairIndex = 0;

        for (int i = 0; i < 5; i++) {
            if (checkPair1[player1.getPlayer_hand().getCardList().get(i).getRank()]++ == 1)
                player1PairIndex = i;
            if (checkPair2[player2.getPlayer_hand().getCardList().get(i).getRank()]++ == 1)
                player2PairIndex = i;
        }

        if (player1.getPlayer_hand().getCardList().get(player1PairIndex).getRank() >= player2.getPlayer_hand().getCardList().get(player2PairIndex).getRank())
            return player1;
        else
            return player2;
    }

    private int suitRank(Suit suit) {
        if (suit.equals(Suit.SPADES))
            return 1;
        else if (suit.equals(Suit.HEARTS))
            return 2;
        else if (suit.equals(Suit.CLUBS))
            return 3;
        else
            return 4;
    }
}
package com.edu.cnu.poker;

import lombok.Data;

/**
 * Created by Hyunji Kim on 2017-04-27.
 */

@Data
public class Player {
    private Hand player_hand;
    private int bettingMoney=0;
    private int money = 100;
    private String name;


    public Player(Deck player_deck, String name){
        this.name = name;
        player_hand = new Hand(player_deck, PokerType.FIVE);
    }

    public void reset(Deck deck) {
        player_hand = new Hand(deck, PokerType.FIVE);
    }

    public Hand getPlayer_hand(){
        return player_hand;
    }

    public int getBettingMoney() {
        return bettingMoney;
    }

    public void winner() {
        Evaluator evaluator = new Evaluator();

        money += bettingMoney;
        bettingMoney = 0;
        System.out.println(name+ " Win!!");
        System.out.println(player_hand.getCardList()+ " rank : "+evaluator.evaluate(player_hand.getCardList()));
    }

    public void loser() {
        money -= bettingMoney;
        bettingMoney = 0;
    }
}
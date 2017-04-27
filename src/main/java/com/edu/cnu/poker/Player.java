package com.edu.cnu.poker;

import lombok.Data;

/**
 * Created by Hyunji Kim on 2017-04-27.
 */

@Data
public class Player {
    private Hand player_hand;
    private int amountOfBet=0;
    private int money = 100;


    public Player(Deck player_deck){
        player_hand = new Hand(player_deck, PokerType.FIVE);
    }

    public Hand getPlayer_hand(){
        return player_hand;
    }

}

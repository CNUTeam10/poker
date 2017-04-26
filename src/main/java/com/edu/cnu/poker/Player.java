package com.edu.cnu.poker;

/**
 * Created by Hyunji Kim on 2017-04-27.
 */
public class Player {
    Hand player_hand;

    public Player(Deck player_deck){
        player_hand = new Hand(player_deck, PokerType.FIVE);
    }

    public Hand getPlayer_hand(){
        return player_hand;
    }

}

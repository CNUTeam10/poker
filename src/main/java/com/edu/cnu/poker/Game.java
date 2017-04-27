package com.edu.cnu.poker;

/**
 * Created by HwangTaeWook on 2017-04-27.
 */
public class Game {
    final private int singleDeck = 52;
    private Deck deck = new Deck(singleDeck);
    private Evaluator evaluator = new Evaluator();
    private Player player1 = new Player(deck);
    private Player player2 = new Player(deck);

    public void startGame() {

    }

    public Player compare() {
        int player1_rank = evaluator.evaluate(player1.getPlayer_hand().getCardList());
        int player2_rank = evaluator.evaluate(player2.getPlayer_hand().getCardList());

        if (player1_rank == player2_rank)
            return player1;
        else if (player1_rank < player2_rank)
            return player1;
        else
            return player2;
    }

    public void firstDeal(Player player1, Player player2) {
        for (int i=0; i<2; i++){
            player1.getPlayer_hand().addCardList(deck.drawCard());
            player2.getPlayer_hand().addCardList(deck.drawCard());
        }
    }
}

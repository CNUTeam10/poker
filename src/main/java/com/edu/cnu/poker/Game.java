package com.edu.cnu.poker;

/**
 * Created by HwangTaeWook on 2017-04-27.
 */
public class Game {
    final private int singleDeck = 52;
    private Deck deck = new Deck(singleDeck);
    private Evaluator evaluator = new Evaluator();
    private Player player1;
    private Player player2;

    public void Game() {
        player1 = new Player(deck);
        player2 = new Player(deck);
    }
}

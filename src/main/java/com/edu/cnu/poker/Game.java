package com.edu.cnu.poker;

import java.util.Scanner;

/**
 * Created by HwangTaeWook on 2017-04-27.
 */


public class Game {
    final private int singleDeck = 52;
    private Deck deck = new Deck(singleDeck);
    private Evaluator evaluator;
    private Player player1 = new Player(deck, "user");
    ;
    private Player player2 = new Player(deck, "computer");
    Scanner scan = new Scanner(System.in);

//    public void startGame() {
//        System.out.println("Welcome, Let's start the Game");
//        firstDeal(player1,player2);
//    }

    public void showAllMoney() {
        System.out.println(player1.getMoney());
        System.out.println(player2.getMoney());

        betting();
        firstDeal(player1, player2);
    }

    public void reset() {
        deck = new Deck(singleDeck);
        player1.reset(deck);
        player2.reset(deck);
    }

    private Player winner() {
        evaluator = new Evaluator();

        int player1_rank = evaluator.evaluate(player1.getPlayer_hand().getCardList());
        int player2_rank = evaluator.evaluate(player2.getPlayer_hand().getCardList());

        if (player1_rank == player2_rank)
            return evaluator.sameRankEvaluate(player1, player2, player1_rank);
        else if (player1_rank < player2_rank)
            return player1;
        else
            return player2;
    }

    private Player loser() {
        evaluator = new Evaluator();

        int player1_rank = evaluator.evaluate(player1.getPlayer_hand().getCardList());
        int player2_rank = evaluator.evaluate(player2.getPlayer_hand().getCardList());

        if (player1_rank == player2_rank) {
            if (evaluator.sameRankEvaluate(player1, player2, player1_rank).equals(player1))
                return player2;
            else
                return player1;
        }
        else if (player1_rank > player2_rank)
            return player1;
        else
            return player2;
    }

    public void betting() {
        int money = 0;
        System.out.print("Player1 Bet Money : ");
        money = scan.nextInt();
        player1.setBettingMoney(player1.getBettingMoney() + money);
        player2.setBettingMoney(player2.getBettingMoney() + money);
        while (cannotBetting(player1.getBettingMoney(), player1)) {
            System.out.print("Amount of bet is more than player's money\n" + "Rebet (Available : " + player1.getMoney() + ") : ");
            player1.setBettingMoney(player1.getBettingMoney() + money);
            player2.setBettingMoney(player2.getBettingMoney() + money);
        }
    }

    public boolean cannotBetting(int betMoney, Player player) {
        return betMoney > player.getMoney();
    }

    public void firstDeal(Player player1, Player player2) {
        for (int i = 0; i < 2; i++) {
            player1.getPlayer_hand().addCardList(deck.drawCard());
            player2.getPlayer_hand().addCardList(deck.drawCard());
        }

        chooseWhichCardwillbeshowed(player1);
    }

    public void continueDeal(Player player1, Player player2) {
        player1.getPlayer_hand().addCardList(deck.drawCard());
        player2.getPlayer_hand().addCardList(deck.drawCard());

        System.out.println("Player's Card is " + player1.getPlayer_hand().getCardList().get(player1.getPlayer_hand().getCardList().size() - 1).getSuit().name()+ " " +player1.getPlayer_hand().getCardList().get(player1.getPlayer_hand().getCardList().size() - 1).getRank());
        System.out.println("Computer's Card is " + player2.getPlayer_hand().getCardList().get(player1.getPlayer_hand().getCardList().size() - 1).getSuit().name()+ " " +player2.getPlayer_hand().getCardList().get(player1.getPlayer_hand().getCardList().size() - 1).getRank());
    }

    public void finalDeal(Player player1, Player player2) {
        player1.getPlayer_hand().addCardList(deck.drawCard());
        player2.getPlayer_hand().addCardList(deck.drawCard());

        betting();
        winner().winner();
        loser().loser();
        reset();
    }

    public void chooseWhichCardwillbeshowed(Player player) {
        System.out.println("which card will be showed?");
        System.out.println("1) " + player.getPlayer_hand().getCardList().get(0) + " 2) " + player.getPlayer_hand().getCardList().get(1));
        System.out.print("Your choice : ");

        int numEnteredbyUser = scan.nextInt();
        System.out.println("Player's Card is " + player.getPlayer_hand().getCardList().get(numEnteredbyUser - 1).getSuit().name()+ " " +player.getPlayer_hand().getCardList().get(numEnteredbyUser - 1).getRank());
        System.out.println("Computer's Card is " + player2.getPlayer_hand().getCardList().get(numEnteredbyUser - 1).getSuit().name()+ " " +player2.getPlayer_hand().getCardList().get(numEnteredbyUser - 1).getRank());
        betting();
        continueDeal(player1, player2);
        betting();
        continueDeal(player1, player2);
        betting();
        finalDeal(player1, player2);
    }
}
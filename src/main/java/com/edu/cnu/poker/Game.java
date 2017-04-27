package com.edu.cnu.poker;

import java.util.Scanner;

/**
 * Created by HwangTaeWook on 2017-04-27.
 */


public class Game {
    final private int singleDeck = 52;
    private Deck deck = new Deck(singleDeck);
    private Evaluator evaluator = new Evaluator();
    private Player player1 = new Player(deck);
    ;
    private Player player2 = new Player(deck);
    Scanner scan = new Scanner(System.in);

    public void Game() {
        player1 = new Player(deck);
        player2 = new Player(deck);
    }


    private Player compare() {
        int player1_rank = evaluator.evaluate(player1.getPlayer_hand().getCardList());
        int player2_rank = evaluator.evaluate(player2.getPlayer_hand().getCardList());

        if (player1_rank == player2_rank)
            return player1;
        else if (player1_rank < player2_rank)
            return player1;
        else
            return player2;
    }

    public void bet() {
        System.out.print("Player1 Bet Money : ");
        int betMore = scan.nextInt();
        int checkMoney = player1.getMoney() - betMore;
        while (MoneyIsLsesThanZero(checkMoney)) {
            System.out.print("Amount of bet is more than money\n" + "Rebet (Available : " + player1.getMoney() + ") : ");
            betMore = scan.nextInt();
            checkMoney = player1.getMoney() - betMore;
        }

        System.out.print("Player2 Bet Money : ");
        betMore = scan.nextInt();
        checkMoney = player2.getMoney() - betMore;
        while (MoneyIsLsesThanZero(checkMoney)) {
            System.out.print("Amount of bet is more than money\n" + "Rebet (Available : " + player2.getMoney() + ") : ");
            betMore = scan.nextInt();
            checkMoney = player2.getMoney() - betMore;
        }
        finishedTheBet();
    }

    public void finishedTheBet() {
        while (true)
            if (betMoneyIsEqual()) {
                System.out.println("Betting is completed");
                break;
            } else {
                if (player1BetMore()) {
                    System.out.print("Player1 Need to bet More\tBet Money : ");
                    int betMore = scan.nextInt();
                    int checkMoney = player1.getMoney() - betMore;

                    while (MoneyIsLsesThanZero(checkMoney)) {
                        System.out.print("Amount of bet is more than money\n" + "Rebet (Available : " + player1.getMoney() + ") : ");
                        betMore = scan.nextInt();
                        checkMoney = player1.getMoney() - betMore;
                    }
                    player1.setAmountOfBet(player1.getAmountOfBet() + betMore);
                    player1.setMoney(checkMoney);
                } else {
                    System.out.println("Player2 Need to bet More\tBet Money : ");
                    int betMore = scan.nextInt();
                    int checkMoney = player2.getMoney() - betMore;

                    while (MoneyIsLsesThanZero(checkMoney)) {
                        System.out.print("Amount of bet is more than money\n" + "Rebet (Available : " + player2.getMoney() + ") : ");
                        betMore = scan.nextInt();
                        checkMoney = player2.getMoney() - betMore;
                    }
                    player2.setAmountOfBet(player2.getAmountOfBet() + betMore);
                    player2.setMoney(checkMoney);
                }
            }
    }

    public boolean betMoneyIsEqual() {
        if (player1.getAmountOfBet() == player2.getAmountOfBet() && player1.getAmountOfBet() != 0)
            return true;
        return false;
    }

    public boolean player1BetMore() {
        if (player1.getAmountOfBet() > player2.getAmountOfBet())
            return true;
        return false;
    }

    public boolean MoneyIsLsesThanZero(int checkMoney) {
        if (checkMoney < 0)
            return true;
        return false;
    }
}
package com.edu.cnu.poker;

import java.util.Scanner;

/**
 * Created by cse on 2017-04-17.
 * CARD - rank, suit
 * DECK
 * HAND
 * EVALUATOR
 * PLAYER
 * GAME
 */
public class PokerApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String check;
        System.out.println("Hello Poker");
        Game game = new Game();

        do {
            game.showAllMoney();

            System.out.print("게임을 계속 하시겠습니까?(y/n) ");
            check = sc.next();
        } while(check.equals("y"));
    }
}

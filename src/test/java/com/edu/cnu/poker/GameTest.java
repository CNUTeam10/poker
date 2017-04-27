package com.edu.cnu.poker;

import org.junit.Test;

/**
 * Created by GAYEON on 2017-04-27.
 */
public class GameTest {

    @Test
    public void 게임을_시작하면_각자_2장씩_카드를_받아야한다(){
        Game game = new Game();
        Deck deck = new Deck(52);
        Player player1 = new Player(deck);
        Player player2 = new Player(deck);

        game.firstDeal(player1,player2);

        assertThat(player1.getPlayer_hand().getTotalCard(), player1.getPlayer_hand().getTotalCard());
    }

    @Test
    public void 배팅완료_후에는_두플레이어의_배팅금액은_동일하다(){
        Game game = new Game();
        Deck deck = new Deck(52);
        Player player1 = new Player(deck);
        Player player2 = new Player(deck);

        game.finishedTheBet(player1,player2);

        assertThat(player1.getAmountOfBet(),player2.getAmountOfBet());
    }

    @Test
    public void 플레이어가_더_이상_게임을_원하지_않으면_중단한다(){
        Game game = new Game();
        Deck deck = new Deck(52);
        Player player1 = new Player(deck);
        Player player2 = new Player(deck);
        int winnersMoney = player1.getAmountOfBet() + player2.getAmountOfBet();

        game.quitTheGame(player1);

        assertThat(player2.getMoney(), winnersMoney);
    }
}

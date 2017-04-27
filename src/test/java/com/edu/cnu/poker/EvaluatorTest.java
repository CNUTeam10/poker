package com.edu.cnu.poker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by cse on 2017-04-17.
 */
public class EvaluatorTest {

    @Test
    public void 플러쉬에_10JQKA이면_로티플이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(10,Suit.CLUBS),
                new Card(11,Suit.CLUBS),
                new Card(12,Suit.CLUBS),
                new Card(13,Suit.CLUBS),
                new Card(1,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList);
        assertThat(result, is(1));
    }

    @Test
    public void 플러쉬에_A2345이면_백티플이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2,Suit.CLUBS),
                new Card(3,Suit.CLUBS),
                new Card(4,Suit.CLUBS),
                new Card(5,Suit.CLUBS),
                new Card(1,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList);
        assertThat(result, is(2));
    }

    @Test
    public void 플러쉬에_스트레이트이면_스티플이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2,Suit.CLUBS),
                new Card(3,Suit.CLUBS),
                new Card(4,Suit.CLUBS),
                new Card(5,Suit.CLUBS),
                new Card(6,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList);
        assertThat(result, is(3));
    }

    @Test
    public void 같은_숫자가_4개이면_포카드다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(10,Suit.CLUBS),
                new Card(10,Suit.SPADES),
                new Card(10,Suit.HEARTS),
                new Card(10,Suit.DIAMONDS),
                new Card(2,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList);
        assertThat(result, is(4));
    }

    @Test
    public void 같은_숫자가_3개_2개이면_풀하우스다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(7,Suit.CLUBS),
                new Card(7,Suit.SPADES),
                new Card(7,Suit.HEARTS),
                new Card(3,Suit.CLUBS),
                new Card(3,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList);
        assertThat(result, is(5));
    }

    @Test
    public void SUIT가_5개가동일하면_플러쉬다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(4,Suit.CLUBS),
                new Card(8,Suit.CLUBS),
                new Card(13,Suit.CLUBS),
                new Card(2,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList);
        assertThat(result, is(6));
    }

    @Test
    public void 스트레이트인데_10JQKA이면_마운틴이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(10,Suit.SPADES),
                new Card(11,Suit.CLUBS),
                new Card(12,Suit.DIAMONDS),
                new Card(13,Suit.HEARTS),
                new Card(1,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList);
        assertThat(result, is(7));
    }

    @Test
    public void 스트레이트인데_A2345이면_백스트레이트이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2,Suit.DIAMONDS),
                new Card(3,Suit.DIAMONDS),
                new Card(4,Suit.SPADES),
                new Card(5,Suit.CLUBS),
                new Card(1,Suit.HEARTS)
        );
        int result = evaluator.evaluate(cardList);
        assertThat(result, is(8));
    }

    @Test
    public void 연속된_숫자가_5장이면_스트레이트이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2,Suit.DIAMONDS),
                new Card(3,Suit.DIAMONDS),
                new Card(4,Suit.SPADES),
                new Card(5,Suit.CLUBS),
                new Card(6,Suit.HEARTS)
        );
        int result = evaluator.evaluate(cardList);
        assertThat(result, is(9));
    }

    @Test
    public void 같은_숫자가_3개이면_트리플이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(7,Suit.CLUBS),
                new Card(7,Suit.SPADES),
                new Card(7,Suit.HEARTS),
                new Card(1,Suit.CLUBS),
                new Card(3,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList);
        assertThat(result, is(10));
    }

    @Test
    public void 같은_숫자가_2개_2개이면_투페어다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(7,Suit.CLUBS),
                new Card(7,Suit.SPADES),
                new Card(3,Suit.HEARTS),
                new Card(3,Suit.CLUBS),
                new Card(2,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList);
        assertThat(result, is(11));
    }

    @Test
    public void 같은_숫자가_2개이면_원페어다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3,Suit.CLUBS),
                new Card(4,Suit.SPADES),
                new Card(5,Suit.HEARTS),
                new Card(6,Suit.CLUBS),
                new Card(6,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList);
        assertThat(result, is(12));
    }

    @Test
    public void 같은_숫자가_없다면_노페어다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3,Suit.CLUBS),
                new Card(4,Suit.SPADES),
                new Card(5,Suit.HEARTS),
                new Card(6,Suit.CLUBS),
                new Card(8,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList);
        assertThat(result, is(13));
    }

    @Test
    public void who_win_with_same_rank1(){
        Evaluator evaluator = new Evaluator();
        Player player1 = new Player(new Deck(52));
        player1.getPlayer_hand().addCardList(new Card(10, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(11, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(12, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(13, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(1, Suit.CLUBS));


        Player player2 = new Player(new Deck(52));
        player2.getPlayer_hand().addCardList(new Card(10, Suit.HEARTS));
        player2.getPlayer_hand().addCardList(new Card(11, Suit.HEARTS));
        player2.getPlayer_hand().addCardList(new Card(12, Suit.HEARTS));
        player2.getPlayer_hand().addCardList(new Card(13, Suit.HEARTS));
        player2.getPlayer_hand().addCardList(new Card(1, Suit.HEARTS));

        Player result = evaluator.sameRankEvaluate(player1, player2, 1);
        assertThat(result, is(player2));
    }

    @Test
    public void who_win_with_same_rank2(){
        Evaluator evaluator = new Evaluator();
        Player player1 = new Player(new Deck(52));
        player1.getPlayer_hand().addCardList(new Card(1, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(2, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(3, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(4, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(5, Suit.CLUBS));

        Player player2 = new Player(new Deck(52));
        player2.getPlayer_hand().addCardList(new Card(1, Suit.HEARTS));
        player2.getPlayer_hand().addCardList(new Card(2, Suit.HEARTS));
        player2.getPlayer_hand().addCardList(new Card(3, Suit.HEARTS));
        player2.getPlayer_hand().addCardList(new Card(4, Suit.HEARTS));
        player2.getPlayer_hand().addCardList(new Card(5, Suit.HEARTS));

        Player result = evaluator.sameRankEvaluate(player1, player2, 2);
        assertThat(result, is(player2));
    }

    @Test
    public void who_win_with_same_rank3(){
        Evaluator evaluator = new Evaluator();
        Player player1 = new Player(new Deck(52));
        player1.getPlayer_hand().addCardList(new Card(4, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(5, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(6, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(7, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(8, Suit.CLUBS));

        Player player2 = new Player(new Deck(52));
        player2.getPlayer_hand().addCardList(new Card(4, Suit.HEARTS));
        player2.getPlayer_hand().addCardList(new Card(5, Suit.HEARTS));
        player2.getPlayer_hand().addCardList(new Card(6, Suit.HEARTS));
        player2.getPlayer_hand().addCardList(new Card(7, Suit.HEARTS));
        player2.getPlayer_hand().addCardList(new Card(8, Suit.HEARTS));

        Player result = evaluator.sameRankEvaluate(player1, player2, 3);
        assertThat(result, is(player2));
    }

    @Test
    public void who_win_with_same_rank4(){
        Evaluator evaluator = new Evaluator();
        Player player1 = new Player(new Deck(52));
        player1.getPlayer_hand().addCardList(new Card(10, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(10, Suit.HEARTS));
        player1.getPlayer_hand().addCardList(new Card(10, Suit.DIAMONDS));
        player1.getPlayer_hand().addCardList(new Card(10, Suit.SPADES));
        player1.getPlayer_hand().addCardList(new Card(4, Suit.CLUBS));

        Player player2 = new Player(new Deck(52));
        player2.getPlayer_hand().addCardList(new Card(1, Suit.SPADES));
        player2.getPlayer_hand().addCardList(new Card(1, Suit.DIAMONDS));
        player2.getPlayer_hand().addCardList(new Card(1, Suit.HEARTS));
        player2.getPlayer_hand().addCardList(new Card(1, Suit.CLUBS));
        player2.getPlayer_hand().addCardList(new Card(4, Suit.HEARTS));

        Player result = evaluator.sameRankEvaluate(player1, player2, 4);
        assertThat(result, is(player2));
    }

    @Test
    public void who_win_with_same_rank5(){
        Evaluator evaluator = new Evaluator();
        Player player1 = new Player(new Deck(52));
        player1.getPlayer_hand().addCardList(new Card(10, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(10, Suit.HEARTS));
        player1.getPlayer_hand().addCardList(new Card(10, Suit.DIAMONDS));
        player1.getPlayer_hand().addCardList(new Card(4, Suit.SPADES));
        player1.getPlayer_hand().addCardList(new Card(4, Suit.CLUBS));

        Player player2 = new Player(new Deck(52));
        player2.getPlayer_hand().addCardList(new Card(1, Suit.SPADES));
        player2.getPlayer_hand().addCardList(new Card(1, Suit.DIAMONDS));
        player2.getPlayer_hand().addCardList(new Card(1, Suit.HEARTS));
        player2.getPlayer_hand().addCardList(new Card(7, Suit.SPADES));
        player2.getPlayer_hand().addCardList(new Card(7, Suit.CLUBS));

        Player result = evaluator.sameRankEvaluate(player1, player2, 5);
        assertThat(result, is(player2));
    }

    @Test
    public void who_win_with_same_rank6(){
        Evaluator evaluator = new Evaluator();
        Player player1 = new Player(new Deck(52));
        player1.getPlayer_hand().addCardList(new Card(2, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(4, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(6, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(8, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(10, Suit.CLUBS));

        Player player2 = new Player(new Deck(52));
        player2.getPlayer_hand().addCardList(new Card(10, Suit.SPADES));
        player2.getPlayer_hand().addCardList(new Card(8, Suit.SPADES));
        player2.getPlayer_hand().addCardList(new Card(6, Suit.SPADES));
        player2.getPlayer_hand().addCardList(new Card(4, Suit.SPADES));
        player2.getPlayer_hand().addCardList(new Card(2, Suit.SPADES));

        Player result = evaluator.sameRankEvaluate(player1, player2, 6);
        assertThat(result, is(player2));
    }

    @Test
    public void who_win_with_same_rank7(){
        Evaluator evaluator = new Evaluator();
        Player player1 = new Player(new Deck(52));
        player1.getPlayer_hand().addCardList(new Card(10, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(11, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(12, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(13, Suit.HEARTS));
        player1.getPlayer_hand().addCardList(new Card(1, Suit.DIAMONDS));

        Player player2 = new Player(new Deck(52));
        player2.getPlayer_hand().addCardList(new Card(10, Suit.SPADES));
        player2.getPlayer_hand().addCardList(new Card(11, Suit.SPADES));
        player2.getPlayer_hand().addCardList(new Card(12, Suit.SPADES));
        player2.getPlayer_hand().addCardList(new Card(13, Suit.CLUBS));
        player2.getPlayer_hand().addCardList(new Card(1, Suit.HEARTS));

        Player result = evaluator.sameRankEvaluate(player1, player2, 7);
        assertThat(result, is(player2));
    }

    @Test
    public void who_win_with_same_rank11(){
        Evaluator evaluator = new Evaluator();
        Player player1 = new Player(new Deck(52));
        player1.getPlayer_hand().addCardList(new Card(7, Suit.HEARTS));
        player1.getPlayer_hand().addCardList(new Card(7, Suit.DIAMONDS));
        player1.getPlayer_hand().addCardList(new Card(3, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(3, Suit.SPADES));
        player1.getPlayer_hand().addCardList(new Card(1, Suit.DIAMONDS));

        Player player2 = new Player(new Deck(52));
        player2.getPlayer_hand().addCardList(new Card(11, Suit.HEARTS));
        player2.getPlayer_hand().addCardList(new Card(11, Suit.DIAMONDS));
        player2.getPlayer_hand().addCardList(new Card(5, Suit.CLUBS));
        player2.getPlayer_hand().addCardList(new Card(5, Suit.CLUBS));
        player2.getPlayer_hand().addCardList(new Card(1, Suit.HEARTS));

        Player result = evaluator.sameRankEvaluate(player1, player2, 11);
        assertThat(result, is(player2));
    }

    @Test
    public void who_win_with_same_rank12(){
        Evaluator evaluator = new Evaluator();
        Player player1 = new Player(new Deck(52));
        player1.getPlayer_hand().addCardList(new Card(7, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(7, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(2, Suit.HEARTS));
        player1.getPlayer_hand().addCardList(new Card(5, Suit.HEARTS));
        player1.getPlayer_hand().addCardList(new Card(10, Suit.DIAMONDS));

        Player player2 = new Player(new Deck(52));
        player2.getPlayer_hand().addCardList(new Card(7, Suit.SPADES));
        player2.getPlayer_hand().addCardList(new Card(7, Suit.SPADES));
        player2.getPlayer_hand().addCardList(new Card(3, Suit.CLUBS));
        player2.getPlayer_hand().addCardList(new Card(8, Suit.DIAMONDS));
        player2.getPlayer_hand().addCardList(new Card(1, Suit.HEARTS));

        Player result = evaluator.sameRankEvaluate(player1, player2, 12);
        assertThat(result, is(player2));
    }

    @Test
    public void sortTest() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(7,Suit.CLUBS),
                new Card(7,Suit.SPADES),
                new Card(3,Suit.HEARTS),
                new Card(3,Suit.CLUBS),
                new Card(2,Suit.CLUBS)
        );
        evaluator.sort(cardList);
        for (int i = 0; i < 5; i++)
            System.out.println(cardList.get(i));
    }

    @Test
    public void 두플레이어가_모두_백스트레이트일때_A의_무늬로_승패를_가린다() {
        Evaluator evaluator = new Evaluator();
        Player player1 = new Player(new Deck(52));
        player1.getPlayer_hand().addCardList(new Card(1, Suit.HEARTS));
        player1.getPlayer_hand().addCardList(new Card(2, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(3, Suit.DIAMONDS));
        player1.getPlayer_hand().addCardList(new Card(4, Suit.SPADES));
        player1.getPlayer_hand().addCardList(new Card(5, Suit.DIAMONDS));

        Player player2 = new Player(new Deck(52));
        player2.getPlayer_hand().addCardList(new Card(1, Suit.SPADES));
        player2.getPlayer_hand().addCardList(new Card(2, Suit.HEARTS));
        player2.getPlayer_hand().addCardList(new Card(3, Suit.HEARTS));
        player2.getPlayer_hand().addCardList(new Card(4, Suit.CLUBS));
        player2.getPlayer_hand().addCardList(new Card(5, Suit.HEARTS));

        Player result = evaluator.sameRankEvaluate(player1, player2, 8);
        assertThat(result, is(player2));
    }
    @Test
    public void 두플레이어가_모두_스트레이트일때_숫자의_대소로_승패를_가린다() {
        Evaluator evaluator = new Evaluator();
        Player player1 = new Player(new Deck(52));
        player1.getPlayer_hand().addCardList(new Card(2, Suit.HEARTS));
        player1.getPlayer_hand().addCardList(new Card(3, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(4, Suit.DIAMONDS));
        player1.getPlayer_hand().addCardList(new Card(5, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(6, Suit.DIAMONDS));

        Player player2 = new Player(new Deck(52));
        player2.getPlayer_hand().addCardList(new Card(5, Suit.SPADES));
        player2.getPlayer_hand().addCardList(new Card(6, Suit.HEARTS));
        player2.getPlayer_hand().addCardList(new Card(7, Suit.HEARTS));
        player2.getPlayer_hand().addCardList(new Card(8, Suit.CLUBS));
        player2.getPlayer_hand().addCardList(new Card(9, Suit.HEARTS));

        Player result = evaluator.sameRankEvaluate(player1, player2, 9);
        assertThat(result, is(player2));
    }
    @Test
    public void 두플레이어가_모두_트리플일때_숫자의_대소로_승패를_가린다() {
        Evaluator evaluator = new Evaluator();
        Player player1 = new Player(new Deck(52));
        player1.getPlayer_hand().addCardList(new Card(2, Suit.HEARTS));
        player1.getPlayer_hand().addCardList(new Card(2, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(2, Suit.DIAMONDS));
        player1.getPlayer_hand().addCardList(new Card(5, Suit.CLUBS));
        player1.getPlayer_hand().addCardList(new Card(6, Suit.DIAMONDS));

        Player player2 = new Player(new Deck(52));
        player2.getPlayer_hand().addCardList(new Card(11, Suit.SPADES));
        player2.getPlayer_hand().addCardList(new Card(11, Suit.HEARTS));
        player2.getPlayer_hand().addCardList(new Card(11, Suit.CLUBS));
        player2.getPlayer_hand().addCardList(new Card(8, Suit.CLUBS));
        player2.getPlayer_hand().addCardList(new Card(9, Suit.HEARTS));

        Player result = evaluator.sameRankEvaluate(player1, player2, 8);
        assertThat(result, is(player2));
    }

}
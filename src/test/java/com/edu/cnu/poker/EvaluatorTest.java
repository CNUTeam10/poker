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
        assertThat(result, is(1));
    }

    @Test
    public void 같은_숫자가_4개이면_포카드다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(10,Suit.CLUBS),
                new Card(10,Suit.SPACE),
                new Card(10,Suit.HEART),
                new Card(10,Suit.DIAMOND),
                new Card(2,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList);
        assertThat(result, is(1));
    }

    @Test
    public void 같은_숫자가_3개가_2개이면_풀하우스다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(7,Suit.CLUBS),
                new Card(7,Suit.SPACE),
                new Card(7,Suit.HEART),
                new Card(3,Suit.CLUBS),
                new Card(3,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList);
        assertThat(result, is(1));
    }

    @Test
    public void 같은_숫자가_3개이면_트리플이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(7,Suit.CLUBS),
                new Card(7,Suit.SPACE),
                new Card(7,Suit.HEART),
                new Card(1,Suit.CLUBS),
                new Card(3,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList);
        assertThat(result, is(0));
    }

    @Test
    public void 같은_숫자가_2개가_2개이면_투페어다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(7,Suit.CLUBS),
                new Card(7,Suit.SPACE),
                new Card(3,Suit.HEART),
                new Card(3,Suit.CLUBS),
                new Card(2,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList);
        assertThat(result, is(0);
    }

    @Test
    public void 같은_숫자가_2개이면_원페어다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3,Suit.CLUBS),
                new Card(4,Suit.SPACE),
                new Card(5,Suit.HEART),
                new Card(6,Suit.CLUBS),
                new Card(6,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList);
        assertThat(result, is(0));
    }
}
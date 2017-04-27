﻿package com.edu.cnu.poker;

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
                new Card(6,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList);
        assertThat(result, is(13));
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
}
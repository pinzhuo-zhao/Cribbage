package cribbage;

import ch.aplu.jcardgame.Card;

/**
 * @program: Cribbage
 * @description:
 * @author: Pinzhuo Zhao, StudentID:1043915
 * @create: 2021-05-13 17:26
 **/
public class CardAdapter implements ICribbageAdapter {
    private Card card;

    public CardAdapter(Card card) {
        this.card = card;
    }

    @Override
    public String getCanonical() {
        return Cribbage.cribbage.canonical(card);
    }

    @Override
    public int getValue() {
        return Cribbage.cardValue(card);
    }

    public Card getCard() {
        return card;
    }
}

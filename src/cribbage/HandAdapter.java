package cribbage;

import ch.aplu.jcardgame.Hand;

/**
 * @program: Cribbage
 * @description:
 * @author: Pinzhuo Zhao, StudentID:1043915
 * @create: 2021-05-13 17:26
 **/
public class HandAdapter implements ICribbageAdapter {
    private Hand hand;

    public HandAdapter(Hand hand) {
        this.hand = hand;
    }

    @Override
    public String getCanonical() {
        return Cribbage.cribbage.canonical(hand);
    }

    @Override
    public int getValue() {
        return Cribbage.cribbage.total(hand);
    }
}

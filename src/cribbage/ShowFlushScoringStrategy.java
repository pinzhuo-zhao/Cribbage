package cribbage;

import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Deck;
import ch.aplu.jcardgame.Hand;

import java.util.ArrayList;

/**
 * @program: Cribbage
 * @description:
 * @author: Pinzhuo Zhao, StudentID:1043915
 * @create: 2021-05-15 16:18
 **/
public class ShowFlushScoringStrategy extends IScoringStrategy{
    @Override
    int getScore(ICribbageAdapter starter, int player, int totalPoints, ICribbageAdapter dealtHand) {
        int total = 0;
        Hand hand = ((HandAdapter) dealtHand).getHand();
        ArrayList<ArrayList<Card>> lists = new ArrayList<>();
        ArrayList<Card> clubCards = hand.getCardsWithSuit(Cribbage.Suit.CLUBS);
        lists.add(clubCards);
        ArrayList<Card> diamondCards = hand.getCardsWithSuit(Cribbage.Suit.DIAMONDS);
        lists.add(diamondCards);
        ArrayList<Card> heartCards = hand.getCardsWithSuit(Cribbage.Suit.HEARTS);
        lists.add(heartCards);
        ArrayList<Card> spadesCards = hand.getCardsWithSuit(Cribbage.Suit.SPADES);
        lists.add(spadesCards);

        for (ArrayList<Card> cards: lists){
            if (cards.size() == 4){
                total += Scoring.FLUSH4.points;
                Hand flushHand = new Hand(new Deck(Cribbage.Suit.values(), Cribbage.Rank.values(), "cover", Cribbage.cribbage.new MyCardValues()));
                for (Card card : cards) {
                    flushHand.insert(card.getSuit(), card.getRank(), false);
                }
                notifyObservers("score", totalPoints + Scoring.FLUSH4.points, player, Scoring.FLUSH4, new HandAdapter(flushHand));
            }
            else if (cards.size() ==5){
                total += Scoring.FLUSH5.points;
                Hand flushHand = new Hand(new Deck(Cribbage.Suit.values(), Cribbage.Rank.values(), "cover", Cribbage.cribbage.new MyCardValues()));
                for (Card card : cards) {
                    flushHand.insert(card.getSuit(), card.getRank(), false);
                }
                notifyObservers("score", totalPoints + Scoring.FLUSH5.points, player, Scoring.FLUSH5, new HandAdapter(flushHand));
            }

        }
        return total;
    }
}

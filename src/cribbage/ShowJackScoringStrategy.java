package cribbage;

import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Deck;
import ch.aplu.jcardgame.Hand;

import java.util.ArrayList;

/**
 * @program: Cribbage
 * @description:
 * @author: Pinzhuo Zhao, StudentID:1043915
 * @create: 2021-05-15 17:01
 **/
public class ShowJackScoringStrategy extends IScoringStrategy{
    @Override
    int getScore(ICribbageAdapter starter, int player, int totalPoints, ICribbageAdapter dealtHand) {
        int total = 0;
        Card starterCard = ((CardAdapter) starter).getCard();
        ArrayList<Card> hand = ((HandAdapter) dealtHand).getHand().getCardList();
        Enum starterSuit = starterCard.getSuit();


        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i).getRank().toString().equals("JACK") && hand.get(i).getSuit().toString().equals(starterSuit.toString())){
                total += Scoring.JACK.points;
                Hand jack = new Hand(new Deck(Cribbage.Suit.values(), Cribbage.Rank.values(), "cover", Cribbage.cribbage.new MyCardValues()));
                jack.insert(hand.get(i).getSuit(), hand.get(i).getRank(), false);
                notifyObservers("score", totalPoints+Scoring.JACK.points, player, Scoring.JACK, new HandAdapter(jack));
            }
        }

        return total;
    }

}

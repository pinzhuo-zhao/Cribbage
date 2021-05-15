package cribbage;

import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Deck;
import ch.aplu.jcardgame.Hand;

import java.util.ArrayList;

/**
 * @program: Cribbage
 * @description:
 * @author: Pinzhuo Zhao, StudentID:1043915
 * @create: 2021-05-15 15:35
 **/
public class ShowPairScoringStrategy extends IScoringStrategy {
    @Override
    int getScore(ICribbageAdapter adapter1, int player, int totalPoints, ICribbageAdapter dealtHand) {
        int total = 0;
        int tempScore = totalPoints;
        ArrayList<ArrayList<Card>> lists = new ArrayList<>();
        Hand hand = ((HandAdapter) dealtHand).getHand();
        ArrayList<Card> aceCard = hand.getCardsWithRank(Cribbage.Rank.ACE);
        lists.add(aceCard);
        ArrayList<Card> twoCard = hand.getCardsWithRank(Cribbage.Rank.TWO);
        lists.add(twoCard);
        ArrayList<Card> ThreeCard = hand.getCardsWithRank(Cribbage.Rank.THREE);
        lists.add(ThreeCard);
        ArrayList<Card> fourCard = hand.getCardsWithRank(Cribbage.Rank.FOUR);
        lists.add(fourCard);
        ArrayList<Card> fiveCard = hand.getCardsWithRank(Cribbage.Rank.FIVE);
        lists.add(fiveCard);
        ArrayList<Card> sixCard = hand.getCardsWithRank(Cribbage.Rank.SIX);
        lists.add(sixCard);
        ArrayList<Card> sevenCard = hand.getCardsWithRank(Cribbage.Rank.SEVEN);
        lists.add(sevenCard);
        ArrayList<Card> eightCard = hand.getCardsWithRank(Cribbage.Rank.EIGHT);
        lists.add(eightCard);
        ArrayList<Card> nineCard = hand.getCardsWithRank(Cribbage.Rank.NINE);
        lists.add(nineCard);
        ArrayList<Card> tenCard = hand.getCardsWithRank(Cribbage.Rank.TEN);
        lists.add(tenCard);
        ArrayList<Card> jCard = hand.getCardsWithRank(Cribbage.Rank.JACK);
        lists.add(jCard);
        ArrayList<Card> qCard = hand.getCardsWithRank(Cribbage.Rank.QUEEN);
        lists.add(qCard);
        ArrayList<Card> kCard = hand.getCardsWithRank(Cribbage.Rank.KING);
        lists.add(kCard);

        for (ArrayList<Card> cards : lists) {
            if (cards.size() == 2) {
                total += Scoring.PAIR2.points;
                tempScore += Scoring.PAIR2.points;
                Hand fifteenHand = new Hand(new Deck(Cribbage.Suit.values(), Cribbage.Rank.values(), "cover", Cribbage.cribbage.new MyCardValues()));
                for (Card card : cards) {
                    fifteenHand.insert(card.getSuit(), card.getRank(), false);
                }
                notifyObservers("score", tempScore, player, Scoring.PAIR2, new HandAdapter(fifteenHand));
            }
            else if (cards.size() == 3){
                total += Scoring.PAIR3.points;
                tempScore += Scoring.PAIR3.points;
                Hand fifteenHand = new Hand(new Deck(Cribbage.Suit.values(), Cribbage.Rank.values(), "cover", Cribbage.cribbage.new MyCardValues()));
                for (Card card : cards) {
                    fifteenHand.insert(card.getSuit(), card.getRank(), false);
                }
                notifyObservers("score", tempScore, player, Scoring.PAIR3, new HandAdapter(fifteenHand));
            }
            else if (cards.size() ==4){
                total += Scoring.PAIR4.points;
                tempScore += Scoring.PAIR4.points;

                Hand fifteenHand = new Hand(new Deck(Cribbage.Suit.values(), Cribbage.Rank.values(), "cover", Cribbage.cribbage.new MyCardValues()));
                for (Card card : cards) {
                    fifteenHand.insert(card.getSuit(), card.getRank(), false);
                }
                notifyObservers("score", tempScore, player, Scoring.PAIR4, new HandAdapter(fifteenHand));

            }
        }
        return total;
    }

}

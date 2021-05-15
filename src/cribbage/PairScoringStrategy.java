package cribbage;

import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Hand;

import java.util.ArrayList;

/**
 * @program: Cribbage
 * @description:
 * @author: Pinzhuo Zhao, StudentID:1043915
 * @create: 2021-05-14 17:59
 **/
public class PairScoringStrategy extends IScoringStrategy{
    @Override
    int getScore(ICribbageAdapter cardPlayed, int player, int totalPoints, ICribbageAdapter playedHand) {
        int score = 0;
        Card card = ((CardAdapter)cardPlayed).getCard();
        ArrayList<Card> cards = ((HandAdapter)playedHand).getHand().getCardList();
        if (card == null){
            return 0;
        }
        int pair = 1;

        for (int i = cards.size() - 2; i >= 0; i--) {
            if (((Cribbage.Rank)(card.getRank())).order == ((Cribbage.Rank)(cards.get(i).getRank())).order){
                pair += 1;
            }
            else {
                break;
            }
        }

        if (pair == 2){
            score += Scoring.PAIR.points;
            notifyObservers("score",totalPoints+Scoring.PAIR.points,player,Scoring.PAIR);
        }
        else if (pair == 3){
            score += Scoring.PAIR3.points;
            notifyObservers("score",totalPoints+Scoring.PAIR3.points,player,Scoring.PAIR3);
        }
        else if (pair >= 4){
            score += Scoring.PAIR4.points;
            notifyObservers("score",totalPoints+Scoring.PAIR4.points,player,Scoring.PAIR4);
        }
        return score;
    }

}

package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

/**
 * @program: Cribbage
 * @description:
 * @author: Pinzhuo Zhao, StudentID:1043915
 * @create: 2021-05-12 19:52
 **/
public class StarterScoringStrategy extends IScoringStrategy {

    public StarterScoringStrategy() {
        super();
    }

    @Override
    public int getScore(ICribbageAdapter cardPlayed, int player, int totalPoints, ICribbageAdapter adapter) {
        int score = 0;
        CardAdapter cardAdapter = null;
        if (cardPlayed instanceof CardAdapter){
           cardAdapter = (CardAdapter) cardPlayed;
        }
        if (cardAdapter.getCard().getRank() == Cribbage.Rank.JACK){
            score += Scoring.STARTER.points;
            notifyObservers("starter",totalPoints+Scoring.STARTER.points,player,Scoring.STARTER,adapter);
        }
        return score;
    }


}

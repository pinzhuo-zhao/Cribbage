package cribbage;

import ch.aplu.jcardgame.Card;

/**
 * @program: Cribbage
 * @description:
 * @author: Pinzhuo Zhao, StudentID:1043915
 * @create: 2021-05-12 19:52
 **/
public class StarterScoringStrategy implements IScoringStrategy {

    @Override
    public int getScore(Card cardPlayed) {
        int score = 0;
        if (cardPlayed.getRank() == Cribbage.Rank.JACK){
            score += Scoring.STARTER.points;
        }
        return score;
    }
}

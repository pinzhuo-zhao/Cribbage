package cribbage;

import ch.aplu.jcardgame.Card;

/**
 * @program: Cribbage
 * @description:
 * @author: Pinzhuo Zhao, StudentID:1043915
 * @create: 2021-05-13 21:05
 **/
public class FifteenOrThirtyOneScoringStrategy extends IScoringStrategy {
    @Override
    int getScore(ICribbageAdapter cardPlayed, int player, int totalPoints, ICribbageAdapter adapter) {
        int score =0;
        if (totalPoints == 15){
            score +=Scoring.FIFTEEN.points;

        }
        else if (totalPoints == 31){
            score +=Scoring.THIRTYONE.points;
        }
        return score;

    }
}

package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

/**
 * @program: Cribbage
 * @description:
 * @author: Pinzhuo Zhao, StudentID:1043915
 * @create: 2021-05-13 21:05
 **/
public class TotalAndLastCardScoringStrategy extends IScoringStrategy {
    @Override
    int getScore(ICribbageAdapter cardPlayed, int player, int totalPoints, ICribbageAdapter playedHand) {
        int score =0;
        if (playedHand.getValue() == 15){
            score +=Scoring.FIFTEEN.points;
            notifyObservers("score",totalPoints+Scoring.FIFTEEN.points,player,Scoring.FIFTEEN,playedHand);

        }
        else if (playedHand.getValue() == 31){
            score +=Scoring.THIRTYONE.points;

            notifyObservers("score",totalPoints+Scoring.THIRTYONE.points,player,Scoring.THIRTYONE);
        }
        else if (((CardAdapter)cardPlayed).getCard() == null){
            score += Scoring.GO.points;
            notifyObservers("score",totalPoints+Scoring.GO.points,player,Scoring.GO);
        }
        return score;

    }
}

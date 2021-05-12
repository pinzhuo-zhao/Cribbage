package cribbage;

import ch.aplu.jcardgame.Card;

/**
 * @program: Cribbage
 * @description:
 * @author: Pinzhuo Zhao, StudentID:1043915
 * @create: 2021-05-12 14:55
 **/
public interface IScoringStrategy {
    int getScore(Card cardPlayed);
}

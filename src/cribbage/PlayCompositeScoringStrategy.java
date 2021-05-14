package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

/**
 * @program: Cribbage
 * @description:
 * @author: Pinzhuo Zhao, StudentID:1043915
 * @create: 2021-05-14 17:02
 **/
public class PlayCompositeScoringStrategy extends IScoringStrategy{
    ArrayList<IScoringStrategy> strategies = new ArrayList<>();

    public PlayCompositeScoringStrategy() {
        super();
    }

    public void addStrategy(IScoringStrategy strategy){
        strategies.add(strategy);
    }

    @Override
    int getScore(ICribbageAdapter adapter1, int player, int totalPoints, ICribbageAdapter adapter2,ArrayList<Card> cards) {
        int total = 0;
        for (IScoringStrategy strategy : strategies){
            total += strategy.getScore(adapter1, player, totalPoints, adapter2,cards);
        }
        return total;
    }
}

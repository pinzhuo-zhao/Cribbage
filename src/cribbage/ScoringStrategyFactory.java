package cribbage;

/**
 * @program: Cribbage
 * @description:
 * @author: Pinzhuo Zhao, StudentID:1043915
 * @create: 2021-05-12 20:13
 **/
public class ScoringStrategyFactory {
    private static ScoringStrategyFactory instance;

    private ScoringStrategyFactory() {
    }

    public static synchronized ScoringStrategyFactory getInstance() {
        if (instance == null) {
            instance = new ScoringStrategyFactory();
        }
        return instance;
    }

    public IScoringStrategy getScoringStrategy(String stage){
        IScoringStrategy strategy = null;
        if (stage.equals("starter")){
           strategy = new StarterScoringStrategy();
        }
        strategy.subscribe(new LogObserver());
        return strategy;

    }
}

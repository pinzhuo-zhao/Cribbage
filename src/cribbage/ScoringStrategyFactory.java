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
        else if (stage.equals("play")){
            CompositeScoringStrategy playCompositeScoringStrategy = new CompositeScoringStrategy();
            playCompositeScoringStrategy.addStrategy(new TotalAndLastCardScoringStrategy());
            playCompositeScoringStrategy.addStrategy(new RunScoringStrategy());
            playCompositeScoringStrategy.addStrategy(new PairScoringStrategy());
            strategy = playCompositeScoringStrategy;

        }
        else if (stage.equals("show")){
            CompositeScoringStrategy showCompositeScoringStrategy = new CompositeScoringStrategy();
            showCompositeScoringStrategy.addStrategy(new ShowFifteenScoringStrategy());
            showCompositeScoringStrategy.addStrategy(new ShowPairScoringStrategy());
            showCompositeScoringStrategy.addStrategy(new RunScoringStrategy());
            showCompositeScoringStrategy.addStrategy(new ShowFlushScoringStrategy());
            showCompositeScoringStrategy.addStrategy(new ShowJackScoringStrategy());
            strategy = showCompositeScoringStrategy;
        }
        return strategy;

    }

}

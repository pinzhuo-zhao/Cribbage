package cribbage;

/**
 * @program: Cribbage
 * @description:
 * @author: Pinzhuo Zhao, StudentID:1043915
 * @create: 2021-05-13 16:56
 **/
public class LogObserver implements ICribbageObserver {
    LogFacade facade = LogFacade.getInstance();
    @Override
    public void onEvent(String prefix, ICribbageAdapter adapter,IPlayer player) {
        if (prefix.equals("deal")){
            facade.logDealAndDiscarded(prefix,adapter,player);
        }
        else if (prefix.equals("discard")){
            facade.logDealAndDiscarded(prefix,adapter,player);
        }
    }

    @Override
    public void onEvent(String prefix, ICribbageAdapter adapter,IPlayer player, int totalPoints) {

    }

    @Override
    public void onEvent(String prefix, ICribbageAdapter adapter) {
        if (prefix.equals("starter")){
            facade.logStarter(prefix,adapter);
        }
    }

    @Override
    public void onEvent(String prefix, int totalPoints, int player, Scoring scoring, ICribbageAdapter adapter) {
        facade.logScore(prefix,totalPoints,player,scoring,adapter);
    }

    @Override
    public void onEvent(String prefix, ICribbageAdapter adapter, int player, int total) {
        facade.logPlay(prefix, adapter,player,total);
    }
}

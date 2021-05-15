package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

/**
 * @program: Cribbage
 * @description:
 * @author: Pinzhuo Zhao, StudentID:1043915
 * @create: 2021-05-12 14:55
 **/
public abstract class IScoringStrategy {
    protected volatile ArrayList<ICribbageObserver> observers = new ArrayList<>();

    public IScoringStrategy() {
        observers.add(new LogObserver());
    }

    protected void subscribe(ICribbageObserver observer){
        observers.add(observer);
    }
    protected  void notifyObservers(String prefix, ICribbageAdapter adapter,IPlayer player){
        for (ICribbageObserver observer: observers){
            observer.onEvent(prefix, adapter,player);
        }
    }
    protected  void notifyObservers(String prefix,IPlayer player, ICribbageAdapter adapter, int totalPoints){
        for (ICribbageObserver observer: observers){
            observer.onEvent(prefix, adapter,player,totalPoints);
        }
    }
    protected  void notifyObservers(String prefix, ICribbageAdapter adapter){
        for (ICribbageObserver observer: observers){
            observer.onEvent(prefix, adapter);
        }
    }
    protected  void notifyObservers(String prefix, int totalPoints, int player, Scoring scoring, ICribbageAdapter adapter){
        for (ICribbageObserver observer: observers){
            observer.onEvent(prefix,totalPoints,player,scoring,adapter);
        }
    }
    protected  void notifyObservers(String prefix, int totalPoints, int player, Scoring scoring){
        for (ICribbageObserver observer: observers){
            observer.onEvent(prefix,totalPoints,player,scoring);
        }
    }
    abstract int getScore(ICribbageAdapter adapter1, int player, int totalPoints, ICribbageAdapter adapter2);
}

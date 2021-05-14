package cribbage;

/**
 * @program: Cribbage
 * @description:
 * @author: Pinzhuo Zhao, StudentID:1043915
 * @create: 2021-05-13 16:53
 **/
public interface ICribbageObserver {
    void onEvent(String prefix, ICribbageAdapter adapter,IPlayer player);
    void onEvent(String prefix, ICribbageAdapter adapter,IPlayer player, int totalPoints);
    void onEvent(String prefix, ICribbageAdapter adapter);
    void onEvent(String prefix, int totalPoints, int player, Scoring scoring, ICribbageAdapter adapter);
    void onEvent(String prefix, int totalPoints, int player, Scoring scoring);
    void onEvent(String prefix, ICribbageAdapter adapter, int player, int total);
    void onEvent(String prefix,IPlayer player, ICribbageAdapter starter, ICribbageAdapter hands);


}

package cribbage;

import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Deck;
import ch.aplu.jcardgame.Hand;

import java.util.ArrayList;

/**
 * @program: Cribbage
 * @description:
 * @author: Pinzhuo Zhao, StudentID:1043915
 * @create: 2021-05-15 13:17
 **/
public class ShowFifteenScoringStrategy extends IScoringStrategy{
    @Override
    int getScore(ICribbageAdapter starter, int player, int totalPoints, ICribbageAdapter dealtHand) {
//        Card card = ((CardAdapter) starter).getCard();
        int score = 0;
        int tempScore = totalPoints;
        ArrayList<Card> cardList = ((HandAdapter) dealtHand).getHand().getCardList();
        for (int i = 0; i < cardList.size() - 1; i++) {
            for (int j = i+1; j<cardList.size(); j++) {
                for (int k = j; k < cardList.size(); k++){
                    String result = totalFifteen(cardList,i, j, k);
                    if (result.equals("fifteen")) {
                        Hand fifteenHand = makeHand(cardList, i, j, k);
                        score += Scoring.FIFTEEN.points;
                        tempScore += Scoring.FIFTEEN.points;
                        notifyObservers("score", tempScore, player, Scoring.FIFTEEN, new HandAdapter(fifteenHand));

                    }
                    else if (result.equals("exceeded")){

                        break;
                    }
                    else if (result.equals("not enough")){
                        continue;
                        }
                }
            }
        }


        return score;
    }

    private String totalFifteen(ArrayList<Card> cards ,int start,int mid, int end){
        int total = 0;
        int deduction = 0;
        for (int i = start; i <= end; i++){
            total += (((Cribbage.Rank)cards.get(i).getRank()).value);
        }
        if (mid>=0) {
            for (int i = start + 1; i <= mid - 1; i++) {
                deduction += (((Cribbage.Rank) cards.get(i).getRank()).value);
            }
        }
        total = total-deduction;
        if (total == 15){
            return "fifteen";
        }
        else if (total > 15){
            return "exceeded";
        }
        else return "not enough";
    }
    private Hand makeHand(ArrayList<Card> cards, int start, int mid, int end){
        Hand fifteenHand = new Hand(new Deck(Cribbage.Suit.values(), Cribbage.Rank.values(), "cover", Cribbage.cribbage.new MyCardValues()));
        for (int i = start; i <= end ; i++){
            fifteenHand.insert(cards.get(i).getSuit(), cards.get(i).getRank(), false);
        }
        if (mid >=0){
            for (int i = start +1; i <=mid - 1; i++){
                fifteenHand.remove(cards.get(i),false);
            }
        }
        return fifteenHand;
    }
}

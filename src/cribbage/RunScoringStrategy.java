package cribbage;

import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Deck;
import ch.aplu.jcardgame.Hand;

import java.util.ArrayList;

/**
 * @program: Cribbage
 * @description:
 * @author: Pinzhuo Zhao, StudentID:1043915
 * @create: 2021-05-13 22:52
 **/
public class RunScoringStrategy extends IScoringStrategy {
    public RunScoringStrategy() {
        super();
    }

    @Override
    int getScore(ICribbageAdapter playedCard, int player, int totalPoints, ICribbageAdapter playedHand) {
        int score = 0;
        Card cardPlayed = ((CardAdapter)playedCard).getCard();
        if (cardPlayed == null){
            return 0;
        }
        if (playedHand instanceof HandAdapter){
            HandAdapter handAdapter = (HandAdapter) playedHand;
            Hand hand = handAdapter.getHand();
            Hand copy = new Hand(new Deck(Cribbage.Suit.values(), Cribbage.Rank.values(), "cover", Cribbage.cribbage.new MyCardValues()));
            for (Card C: hand.getCardList()) copy.insert(C.getSuit(), C.getRank(), false);
            ArrayList<Card> cardList = copy.getCardList();
            cardList.sort((o1, o2) -> ((Cribbage.Rank) o1.getRank()).order - ((Cribbage.Rank)o2.getRank()).order);
            ArrayList<Card> runList = new ArrayList<>();
            int run = 1;
            int currentRun = 1;
            ArrayList<Card> currentRunList = new ArrayList<>();

            for (int i = 0; i< cardList.size() - 1; i++) {
                currentRunList.add(cardList.get(i));
                if (((Cribbage.Rank)cardList.get(i).getRank()).order +1 == ((Cribbage.Rank)cardList.get(i+1).getRank()).order){
                    currentRun++;
                    currentRunList.add(cardList.get(i+1));
                }
                else {
                    if (run < currentRun){
                        run = currentRun;
                        runList = currentRunList;

                    }
                    currentRun = 1;
                    currentRunList = new ArrayList<>();
                }
            }
            if (run < currentRun){
                run = currentRun;
                runList = currentRunList;
            }


            Hand runHand = new Hand(new Deck(Cribbage.Suit.values(), Cribbage.Rank.values(), "cover", Cribbage.cribbage.new MyCardValues()));
            for (Card card:runList){
                runHand.insert(card.getSuit(),card.getRank(),false);
            }

            if (run == 3){
                score += Scoring.RUN3.points;
                notifyObservers("score",totalPoints+Scoring.RUN3.points,player,Scoring.RUN3,new HandAdapter(runHand));

            }
            else if (run == 4){
                score += Scoring.RUN4.points;
                notifyObservers("score",totalPoints+Scoring.RUN4.points,player,Scoring.RUN4,new HandAdapter(runHand));
            }
            else if (run == 5){
                score += Scoring.RUN5.points;
                notifyObservers("score",totalPoints+Scoring.RUN5.points,player,Scoring.RUN5,new HandAdapter(runHand));
            }
            else if (run == 6){
                score += Scoring.RUN6.points;
                notifyObservers("score",totalPoints+Scoring.RUN6.points,player,Scoring.RUN6,new HandAdapter(runHand));
            }
            else if (run == 7){
                score += Scoring.RUN7.points;
                notifyObservers("score",totalPoints+Scoring.RUN7.points,player,Scoring.RUN7,new HandAdapter(runHand));
            }


        }
        return score;
    }

}

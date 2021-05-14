package cribbage;

import ch.aplu.jcardgame.Hand;

import java.io.*;

/**
 * @program: Cribbage
 * @description:
 * @author: Pinzhuo Zhao, StudentID:1043915
 * @create: 2021-05-12 14:41
 **/
public class LogFacade {
    private static LogFacade instance;
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("cribbage.log",false)));
    private int counter = 0;

    private LogFacade() throws FileNotFoundException {
    }

    public static synchronized LogFacade getInstance() {
        if (instance == null){
            try {
                instance = new LogFacade();
            } catch (FileNotFoundException e) {
                System.out.println("The file does not exist");
            }
        }
        return instance;
    }

    public void logSeed(int seed){
        try {
            writer.write("seed,"+ seed);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void logPlayer(String playerType){
        try {
            writer.write(playerType + ",P" + counter++);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void logDealAndDiscarded(String prefix, ICribbageAdapter adapter, IPlayer player){
        try {
            writer.write(prefix + ",P" + player.id + "," + adapter.getCanonical());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void logStarter(String prefix, ICribbageAdapter adapter){
        try {
            writer.write(prefix +"," + adapter.getCanonical());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void logScore(String prefix, int totalPoints, int player, Scoring scoring, ICribbageAdapter adapter){
        try {
            writer.write(prefix +",P" + player +"," + totalPoints +","+scoring.points +"," + scoring.type +"," + adapter.getCanonical());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void logScore(String prefix, int totalPoints, int player, Scoring scoring){
        try {
            writer.write(prefix +",P" + player +"," + totalPoints +","+scoring.points +"," + scoring.type);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void logPlay(String prefix, ICribbageAdapter adapter, int player, int total){
        try {
            writer.write(prefix +",P" + player +"," + total +","+ adapter.getCanonical());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void logShow(String prefix, IPlayer player, ICribbageAdapter starter, ICribbageAdapter hands){
        try {
            writer.write(prefix +",P" + player.id +"," + starter.getCanonical() + "+" + hands.getCanonical());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }




//    String canonical(Cribbage.Suit s) { return s.toString().substring(0, 1); }

//    String canonical(Cribbage.Rank r) {
//        switch (r) {
//            case ACE:case KING:case QUEEN:case JACK:case TEN:
//                return r.toString().substring(0, 1);
//            default:
//                return String.valueOf(r.value);
//        }
//    }
//
//    String canonical(Card c) { return canonical((Cribbage.Rank) c.getRank()) + canonical((Cribbage.Suit) c.getSuit()); }

//    public String printCard(Card card){
//        String cardInfoLog = canonical(card);
//        return cardInfoLog;
//    }
}

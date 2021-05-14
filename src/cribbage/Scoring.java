package cribbage;

/**
 * @program: Cribbage
 * @description:
 * @author: Pinzhuo Zhao, StudentID:1043915
 * @create: 2021-05-12 20:58
 **/
public enum Scoring {
    STARTER(2,"starter"),FIFTEEN(2,"fifteen"),THIRTYONE(2,"thirtyone"),
    GO(1,"go"),RUN3(3,"run3"),RUN4(4,"run4"),RUN5(5,"run5"),
    RUN6(6,"run6"),RUN7(7,"run7"),PAIR(2,"pair"),PAIR2(2,"pair2"),
    PAIR3(6,"pair3"),PAIR4(12,"pair4"),FLUSH4(4,"flush4"),
    FLUSH5(5,"flush5"), JACK(1,"jack")
    ;

    public int points;
    public String type;

    Scoring(int points, String type) {
        this.points = points;
        this.type = type;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

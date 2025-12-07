package model;

public class Batsman  {

    private int runs;
    private int balls;
    private int outs;

    public Batsman(String name, int runs, int balls, int outs) {
        super(name);
        this.runs = runs;
        this.balls = balls;
        this.outs = outs;
    }

    public double getStrikeRate() {
        if (balls == 0) {
            return 0;
        } else {
            return (runs * 100.0) / balls;
        }
    }

    public double getAverage() {
        if (outs == 0) {
            return runs;
        } else {
            return (runs * 1.0) / outs;
        }
    }

    public int getRuns() {
        return runs;
    }

    public int getBalls() {
        return balls;
    }

    public int getOuts() {
        return outs;
    }
}

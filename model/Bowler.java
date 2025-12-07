ackage model;

public class Bowler{
    private int runsConceded;
    private double overs;
    private int wickets;

    public Bowler(String name, int runsConceded, double overs, int wickets) {
        super(name);
        this.runsConceded = runsConceded;
        this.overs = overs;
        this.wickets = wickets;
    }

    public double getEconomy() {
        if (overs == 0) {
            return 0;
        } else {
            return runsConceded / overs;
        }
    }

    public double getAverage() {
        if (wickets == 0) {
            return runsConceded;
        } else {
            return (runsConceded * 1.0) / wickets;
        }
    }

    public int getRunsConceded() {
        return runsConceded;
    }

    public double getOvers() {
        return overs;
    }

    public int getWickets() {
        return wickets;
    }
}

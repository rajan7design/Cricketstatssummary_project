

package model;

public class Bowler {
    private String name;
    private int runsConceded;
    private int wickets;
    private double oversBowled;

    public Bowler(String name, int runsConceded, int wickets, double oversBowled) {
        this.name = name;
        this.runsConceded = runsConceded;
        this.wickets = wickets;
        this.oversBowled = oversBowled;
    }

    public double calculateBowlingAverage() {
        if (wickets == 0) return 0;
        return (double) runsConceded / wickets;
    }

    public double calculateEconomy() {
        if (oversBowled == 0) return 0;
        return runsConceded / oversBowled;
    }

    @Override
    public String toString() {
        return "Name: " + name +
               "\nRuns Conceded: " + runsConceded +
               "\nWickets: " + wickets +
               "\nOvers Bowled: " + oversBowled +
               "\nBowling Average: " + calculateBowlingAverage() +
               "\nEconomy Rate: " + calculateEconomy();
    }
}

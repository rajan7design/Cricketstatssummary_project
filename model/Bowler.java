

package model;

public class Bowler {

    private String name;
    private String nationality;
    private int age;
    private int wickets;
    private int runsConceded;
    private double overs;

    public Bowler(String name, String nationality, int age,
                  int wickets, int runsConceded, double overs) {

        this.name = name;
        this.nationality = nationality;
        this.age = age;
        this.wickets = wickets;
        this.runsConceded = runsConceded;
        this.overs = overs;
    }

    public double getEconomy() {

        if (overs == 0) return 0;

        return runsConceded / overs;
    }

    public double getAverage() {

        if (wickets == 0) return 0;

        return (double) runsConceded / wickets;
    }

    public String toFileString() {

        return "BOWLER," + name + "," + nationality + "," + age +
                "," + wickets + "," + runsConceded + "," + overs +
                "," + getEconomy() + "," + getAverage();
    }
}

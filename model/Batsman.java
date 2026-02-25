

package model;

public class Batsman {
    private String name;
    private String nationality;
    private int age;
    private int totalRuns;
    private int totalMatches;
    private int ballsFaced;

    public Batsman(String name, String nationality, int age, int totalRuns, int totalMatches, int ballsFaced) {
        this.name = name;
        this.nationality = nationality;
        this.age = age;
        this.totalRuns = totalRuns;
        this.totalMatches = totalMatches;
        this.ballsFaced = ballsFaced;
    }

    public String getName() {
        return name;
    }

    public double calculateAverage() {
        if (totalMatches == 0) return 0;
        return (double) totalRuns / totalMatches;
    }

    public double calculateStrikeRate() {
        if (ballsFaced == 0) return 0;
        return ((double) totalRuns / ballsFaced) * 100;
    }

    
    public String toString() {
        return "Name: " + name +
               "\nNationality: " + nationality +
               "\nAge: " + age +
               "\nTotal Runs: " + totalRuns +
               "\nMatches: " + totalMatches +
               "\nBalls Faced: " + ballsFaced +
               "\nBatting Average: " + calculateAverage() +
               "\nStrike Rate: " + calculateStrikeRate();
    }
}

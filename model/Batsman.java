package model;

public class Batsman {

    private String name;
    private String nationality;
    private int age;
    private int runs;
    private int balls;
    private int innings;

    public Batsman(String name, String nationality, int age,
                   int runs, int balls, int innings) {

        this.name = name;
        this.nationality = nationality;
        this.age = age;
        this.runs = runs;
        this.balls = balls;
        this.innings = innings;
    }

    public double getStrikeRate() {
        if (balls == 0) {
            return 0;
        }
        return (runs * 100.0) / balls;
    }

    public double getAverage() {
        if (innings == 0) {
            return 0;
        }
        return runs / (double) innings;
    }

    
    public String toString() {

        return "Name: " + name +
                "\nNationality: " + nationality +
                "\nAge: " + age +
                "\nRuns: " + runs +
                "\nStrike Rate: " + getStrikeRate() +
                "\nAverage: " + getAverage();
    }
}

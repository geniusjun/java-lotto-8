package lotto.domain;

public class Match {
    private int three;
    private int four;
    private int five;
    private int fiveBonus;
    private int six;

    public Match() {
        this.three = 0;
        this.four = 0;
        this.five = 0;
        this.fiveBonus = 0;
        this.six = 0;
    }

    public int getThree() {
        return three;
    }

    public int getFour() {
        return four;
    }

    public int getFive() {
        return five;
    }

    public int getFiveBonus() {
        return fiveBonus;
    }

    public int getSix() {
        return six;
    }

    public void plusThree() {
        this.three++;
    }

    public void plusFour() {
        this.four++;
    }

    public void plusFive() {
        this.five++;
    }

    public void plusFiveBonus() {
        this.fiveBonus++;
    }

    public void plusSix() {
        this.six++;
    }
}

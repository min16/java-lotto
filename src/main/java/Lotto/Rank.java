package lotto;

public enum Rank {
    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private int correctCount;
    private int prize;

    Rank(int correctCount, int prize) {
        this.correctCount = correctCount;
        this.prize = prize;
    }

    public static Rank RankOf(int correctCount, boolean matchedBonus) {
        if (correctCount == 5 && matchedBonus) return Rank.SECOND;
        for (Rank rank : Rank.values()) {
            if (rank.correctCount == correctCount) return rank;
        }

        return Rank.NONE;
    }

    public static Rank getRank(WinningLotto winner, Lotto myLotto) {
        return RankOf(winner.correctCount(myLotto), winner.matchedBonus(myLotto));
    }

    public boolean isNotNone() {
        return this != NONE;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getPrize() {
        return prize;
    }
}

package lotto;

import java.util.Objects;

public class LottoNumber {
    private static final String INVALID_NUMBER = "유효하지 않은 로또 번호입니다.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private int number;

    LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }

    private void validate(int number) {
        if (number >= MIN_NUMBER && number <= MAX_NUMBER) return;

        throw new IllegalArgumentException(INVALID_NUMBER);
    }
}

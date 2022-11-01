package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    private List<LottoNumber> numbers(int min, int max) {
        return IntStream.range(min, max).boxed().map(v -> new LottoNumber(v)).collect(Collectors.toList());
    }

    @Test
    void 랭킹_목록() {
        assertThat(Rank.values()).isEqualTo(Rank.values());
    }

    @Test
    void 당첨_1등() {
        assertThat(Rank.RankOf(6)).isEqualTo(Rank.FIRST);
    }

    @Test
    void 당첨된_랭킹_가져오기() {
        Lotto winner = new Lotto(numbers(1, 7));
        Lotto myLotto = new Lotto(numbers(1, 7));

        assertThat(Rank.getRank(winner, myLotto)).isEqualTo(Rank.FIRST);
    }

    @Test
    void NONE_Rank_인지_확인() {
        assertThat(Rank.FIRST.isNotNone()).isTrue();
    }
}

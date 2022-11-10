package lotto.domain.entity;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import lotto.infrastructure.GeneratorImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("정렬 된 로또 번호 확인 Test")
    @Test
    public void lottosSortedNumbersTest() throws Exception {
        Lottos lottos = Lottos.from(1, new GeneratorImpl());
        List<Lotto> lotto = lottos.currentLottos();
        Lotto oneLottoGame = lotto.get(0);

        List<Integer> numbers = oneLottoGame.currentLottoNumbers();
        List<Integer> compareNumbers = new ArrayList<>(numbers);
        Collections.sort(compareNumbers);

        Assertions.assertThat(numbers).isEqualTo(compareNumbers);
    }


}

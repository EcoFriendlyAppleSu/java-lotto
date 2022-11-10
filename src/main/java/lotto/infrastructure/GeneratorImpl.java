package lotto.infrastructure;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Generator;

public class GeneratorImpl implements Generator {


    @Override
    public String[] numberSeparator(String str) {
        return str.split(",");
    }

    @Override
    public List<Integer> lottoNumbersGenerator() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
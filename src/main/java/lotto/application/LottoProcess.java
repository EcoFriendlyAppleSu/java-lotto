package lotto.application;

import static lotto.common.message.ConsoleOut.*;

import java.util.List;
import lotto.domain.Generator;
import lotto.domain.entity.LottoMachine;
import lotto.domain.entity.Lottos;
import lotto.domain.entity.Money;
import lotto.domain.entity.LottoNumberMatcher;
import lotto.domain.entity.User;
import lotto.domain.vo.MatchReport;
import lotto.infrastructure.GeneratorImpl;

public class LottoProcess {

    private static Generator generator = new GeneratorImpl();

    public static void run() {
        System.out.println(INPUT_COST_MASSAGE);
        int generateMoney = generator.generateMoney();
        Money money = Money.from(generateMoney);
        Lottos lottos = Lottos.from(money.currentTime());

        User user = User.of(money, lottos);
        System.out.println(user.printCurrentTime() + AMOUNT_OF_LOTTOS_MESSAGE);
        user.printUserLottosNumbers();

        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String lottoNumber = generator.generateLotto();
        String[] numberSeparator = generator.numberSeparator(lottoNumber);

        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String bonusLottoNumber = generator.generateBonusLottoNumber();
        LottoMachine lottoMachine = LottoMachine.of(numberSeparator,
            Integer.valueOf(bonusLottoNumber));

        System.out.println(WINNING_RESULT_MESSAGE);
        System.out.println(THREE_DASHES_AFTER_WINNING_RESULT_MESSAGE);

        LottoNumberMatcher matcher = new LottoNumberMatcher();

        List<MatchReport> reportList = matcher.match(user.currentUserLottos(), lottoMachine);

    }
}

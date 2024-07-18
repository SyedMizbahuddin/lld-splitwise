package splitwise.service.divide;

import java.util.ArrayList;
import java.util.List;

import splitwise.exception.IncorrectDivisionException;
import splitwise.model.DividedAmount;

public class PercentStrategy extends DivideStrategy {

	public final static String STRATEGY_NAME = "PERCENT";

	@Override
	public List<DividedAmount> divide(int amount, List<Integer> users, List<Integer> division) {

		int sum = division.stream()
				.mapToInt(Integer::intValue)
				.sum();

		if (sum != 100) {
			throw new IncorrectDivisionException("Percent not split correctly");
		}

		List<DividedAmount> dividedAmounts = new ArrayList<>();

		for (int i = 0; i < users.size(); i++) {
			double share = division.get(i) / 100.0 * amount;
			share = convert(share);
			dividedAmounts.add(new DividedAmount(users.get(i), share));
		}

		return dividedAmounts;
	}

}

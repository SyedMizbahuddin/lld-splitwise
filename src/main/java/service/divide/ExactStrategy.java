package service.divide;

import java.util.ArrayList;
import java.util.List;

import exception.IncorrectDivisionException;
import model.DividedAmount;

public class ExactStrategy extends DivideStrategy {

	public final static String STRATEGY_NAME = "EXACT";

	@Override
	public List<DividedAmount> divide(int amount, List<Integer> users, List<Integer> division) {
		int sum = division.stream()
				.mapToInt(Integer::intValue)
				.sum();

		if (sum != amount) {
			throw new IncorrectDivisionException("Amount not split correctly");
		}

		List<DividedAmount> dividedAmounts = new ArrayList<>();

		for (int i = 0; i < users.size(); i++) {
			dividedAmounts.add(new DividedAmount(users.get(i), division.get(i)));
		}

		return dividedAmounts;
	}

}

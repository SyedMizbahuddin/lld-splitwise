package splitwise.service.divide;

import java.util.List;

import splitwise.model.DividedAmount;

public class ExactStrategy implements DivideStrategy {

	public final static String STRATEGY_NAME = "EXACT";

	@Override
	public List<DividedAmount> divide(int amount, List<Integer> users, List<Double> division) {

		return null;
	}

}

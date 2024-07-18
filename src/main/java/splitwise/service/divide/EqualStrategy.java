package splitwise.service.divide;

import java.util.List;

import splitwise.model.DividedAmount;

public class EqualStrategy implements DivideStrategy {

	public final static String STRATEGY_NAME = "EQUAL";

	@Override
	public List<DividedAmount> divide(int amount, List<Integer> users, List<Integer> division) {

		return null;
	}

}

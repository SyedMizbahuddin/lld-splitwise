package splitwise.service.divide;

import java.util.List;

import splitwise.model.DividedAmount;

public class PercentStrategy implements DivideStrategy {

	public final static String STRATEGY_NAME = "PERCENT";

	@Override
	public List<DividedAmount> divide(int amount, List<Integer> users, List<Double> division) {

		return null;
	}

}

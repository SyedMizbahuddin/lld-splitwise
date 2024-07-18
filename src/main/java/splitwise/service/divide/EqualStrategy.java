package splitwise.service.divide;

import java.util.ArrayList;
import java.util.List;

import splitwise.model.DividedAmount;

public class EqualStrategy extends DivideStrategy {

	public final static String STRATEGY_NAME = "EQUAL";

	@Override
	public List<DividedAmount> divide(int amount, List<Integer> users, List<Integer> division) {

		int count = users.size();
		double each = amount * 1.0 / count;
		each = convert(each);

		double extra = amount - each * count;
		extra = convert(extra);

		List<DividedAmount> dividedAmounts = new ArrayList<>();

		for (int i = 0; i < users.size(); i++) {
			double value = each;
			if (i == 0) {
				value += extra;
			}
			value = convert(value);
			dividedAmounts.add(new DividedAmount(users.get(i), value));
		}

		return dividedAmounts;
	}

}

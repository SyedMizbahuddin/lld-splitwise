package splitwise.service.divide;

import java.util.List;

import splitwise.model.DividedAmount;

public interface DivideStrategy {

	List<DividedAmount> divide(int amount, List<Integer> users, List<Integer> division);
}

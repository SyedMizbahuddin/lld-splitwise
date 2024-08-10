package service.divide;

import java.util.List;

import model.DividedAmount;

public abstract class DivideStrategy {

	public abstract List<DividedAmount> divide(int amount, List<Integer> users, List<Integer> division);

	double convert(double number) {
		return ((long) (number * 100)) / 100.0;
	}
}

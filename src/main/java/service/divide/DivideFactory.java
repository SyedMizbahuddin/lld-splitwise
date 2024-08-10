package service.divide;

import java.util.HashMap;
import java.util.Map;

import exception.InstanceNotFoundException;

public class DivideFactory {

	Map<String, DivideStrategy> divideStrategies;

	public DivideFactory() {
		divideStrategies = new HashMap<>();

		divideStrategies.put(EqualStrategy.STRATEGY_NAME, new EqualStrategy());
		divideStrategies.put(ExactStrategy.STRATEGY_NAME, new ExactStrategy());
		divideStrategies.put(PercentStrategy.STRATEGY_NAME, new PercentStrategy());
	}

	public DivideStrategy getDivideStrategy(String strategy) {

		if (!valid(strategy)) {
			throw new InstanceNotFoundException(strategy + " strategy not found");
		}

		DivideStrategy divideStrategy = divideStrategies.get(strategy);

		return divideStrategy;
	}

	public boolean valid(String strategy) {
		return divideStrategies.containsKey(strategy);
	}
}

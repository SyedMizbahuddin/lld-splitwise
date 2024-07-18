package splitwise.service.divide;

public class DivideFactory {

	public DivideStrategy getDivideStrategy(String strategy) {

		DivideStrategy divideStrategy = null;

		switch (strategy) {

		case EqualStrategy.STRATEGY_NAME:
			divideStrategy = new EqualStrategy();
			break;

		case ExactStrategy.STRATEGY_NAME:
			divideStrategy = new ExactStrategy();
			break;

		case PercentStrategy.STRATEGY_NAME:
			divideStrategy = new PercentStrategy();
			break;

		default:

		}
		return divideStrategy;
	}
}

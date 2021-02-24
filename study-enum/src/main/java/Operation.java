/*public enum Operation {
	PLUS, MINUS, TIMES, DIVIDE;

	public double apply(double x, double y) {
		switch (this) {
			case PLUS:
				return x + y;
			case MINUS:
				return x - y;
			case TIMES:
				return x * y;
			case DIVIDE:
				return x / y;
		}
		throw new AssertionError("Unknown op: " + this);
	}
}*/

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

/**
 * @author admin
 */
public enum Operation {
	/**
	 * 加
	 */
	PLUS("+") {
		@Override
		public double apply(double x, double y) {
			return x + y;
		}
	},
	/**
	 * 减
	 */
	MINUS("-") {
		@Override
		public double apply(double x, double y) {
			return x - y;
		}
	},
	/**
	 * 乘
	 */
	TIMES("*") {
		@Override
		public double apply(double x, double y) {
			return x * y;
		}
	},
	/**
	 * 除
	 */
	DIVIDE("/") {
		@Override
		public double apply(double x, double y) {
			return x / y;
		}
	};

	private final String symbol;

	Operation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}

	public abstract double apply(double x, double y);

	public static final Map<String, Operation> stringToEnum = Stream.of(values()).collect(
			toMap(Object::toString, e ->e)
	);

	public static Optional<Operation> fromString(String symbol){
		return Optional.ofNullable(stringToEnum.get(symbol));
	}
}

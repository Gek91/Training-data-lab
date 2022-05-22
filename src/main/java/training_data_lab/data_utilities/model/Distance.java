package training_data_lab.data_utilities.model;

import java.math.BigDecimal;

public class Distance extends ValueWithUnit<DistanceUnit> {

	public static Distance buildDistance(BigDecimal value, DistanceUnit unit) {
		return new Distance(value, unit);
	}

	private Distance(BigDecimal value, DistanceUnit unit) {
		super(value, unit);
	}

	@Override
	protected Distance getNewInstance(BigDecimal value, DistanceUnit unit) {
		return new Distance(value, unit);
	}
}

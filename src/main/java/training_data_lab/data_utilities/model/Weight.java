package training_data_lab.data_utilities.model;

import java.math.BigDecimal;

public class Weight extends ValueWithUnit<WeightUnit> {

	public static Weight buildWeight(BigDecimal value, WeightUnit unit) {
		return new Weight(value, unit);
	}

	private Weight(BigDecimal value, WeightUnit unit) {
		super(value, unit);
	}

	@Override
	protected Weight getNewInstance(BigDecimal value, WeightUnit unit) {
		return new Weight(value, unit);
	}

}

package training_data_lab.data_utilities.model.base;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidParameterException;

@Getter
public abstract class ValueWithUnit<T extends UnitType> {

	protected BigDecimal value;
	protected T unit;

	protected abstract <K extends ValueWithUnit> K getNewInstance(BigDecimal value, T unit);

	protected ValueWithUnit(BigDecimal value, T unit) {

		if(value == null || unit == null || value.compareTo(BigDecimal.ZERO) < 0){
			throw new InvalidParameterException();
		}

		this.value = value;
		this.unit = unit;
	}

	public <K extends ValueWithUnit> K convertToUnit(T unitTo) {
		return getNewInstance(this.value.multiply(this.unit.getConversionRateTo(unitTo)).setScale(2, RoundingMode.HALF_DOWN), unitTo);
	}
}

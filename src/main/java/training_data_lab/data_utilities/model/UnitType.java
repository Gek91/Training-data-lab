package training_data_lab.data_utilities.model;

import java.math.BigDecimal;

public interface UnitType {

	public BigDecimal getConversionRateTo(UnitType unitTo);
}

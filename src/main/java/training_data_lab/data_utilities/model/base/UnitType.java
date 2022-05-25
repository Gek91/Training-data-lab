package training_data_lab.data_utilities.model.base;

import java.math.BigDecimal;

public interface UnitType {

	BigDecimal getConversionRateTo(UnitType unitTo);
}

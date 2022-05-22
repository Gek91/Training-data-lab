package training_data_lab.data_utilities.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.Map;

public enum WeightUnit implements UnitType {

	KG(),
	POUND();

	static {
		KG.conversionRateMap = Map.ofEntries(
			new AbstractMap.SimpleEntry(WeightUnit.KG, new BigDecimal("1")),
			new AbstractMap.SimpleEntry(WeightUnit.POUND, new BigDecimal("2.2046226218"))
		);

		POUND.conversionRateMap =Map.ofEntries(
			new AbstractMap.SimpleEntry(WeightUnit.KG, new BigDecimal("0.45359237")),
			new AbstractMap.SimpleEntry(WeightUnit.POUND, new BigDecimal("1"))
		);
	}

	private Map<WeightUnit, BigDecimal> conversionRateMap;

	@Override
	public BigDecimal getConversionRateTo(UnitType unitTo) {
		return conversionRateMap.get(unitTo);
	}
}

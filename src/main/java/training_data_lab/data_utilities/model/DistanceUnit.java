package training_data_lab.data_utilities.model;

import training_data_lab.data_utilities.model.base.UnitType;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.Map;

public enum DistanceUnit implements UnitType {

	KM(),
	M(),
	FOOT(),
	MILE();

	static {
		KM.conversionRateMap = Map.ofEntries(
				new AbstractMap.SimpleEntry(DistanceUnit.KM, new BigDecimal("1")),
				new AbstractMap.SimpleEntry(DistanceUnit.M, new BigDecimal("1000")),
				new AbstractMap.SimpleEntry(DistanceUnit.FOOT, new BigDecimal("3280.8398950131")),
				new AbstractMap.SimpleEntry(DistanceUnit.MILE, new BigDecimal("0.6213711922"))
		);

		M.conversionRateMap = Map.ofEntries(
				new AbstractMap.SimpleEntry(DistanceUnit.KM, new BigDecimal("0.0001")),
				new AbstractMap.SimpleEntry(DistanceUnit.M, new BigDecimal("1")),
				new AbstractMap.SimpleEntry(DistanceUnit.FOOT, new BigDecimal("3.280839895")),
				new AbstractMap.SimpleEntry(DistanceUnit.MILE, new BigDecimal("0.0006213712"))
		);

		FOOT.conversionRateMap = Map.ofEntries(
				new AbstractMap.SimpleEntry(DistanceUnit.KM, new BigDecimal("0.0003048")),
				new AbstractMap.SimpleEntry(DistanceUnit.M, new BigDecimal("0.3048")),
				new AbstractMap.SimpleEntry(DistanceUnit.FOOT, new BigDecimal("1")),
				new AbstractMap.SimpleEntry(DistanceUnit.MILE, new BigDecimal("0.0001893939"))
		);

		MILE.conversionRateMap = Map.ofEntries(
				new AbstractMap.SimpleEntry(DistanceUnit.KM, new BigDecimal("1.609344")),
				new AbstractMap.SimpleEntry(DistanceUnit.M, new BigDecimal("1609.344")),
				new AbstractMap.SimpleEntry(DistanceUnit.FOOT, new BigDecimal("5280")),
				new AbstractMap.SimpleEntry(DistanceUnit.MILE, new BigDecimal("1"))
		);
	}

	private Map<DistanceUnit, BigDecimal> conversionRateMap;

	@Override
	public BigDecimal getConversionRateTo(UnitType unitTo) {
		return conversionRateMap.get(unitTo);
	}
}

package training_data_lab.data_utilities.model;

import java.math.BigDecimal;
import java.math.RoundingMode;


public enum AerobicExerciseType {

	RUN(new BigDecimal(12), new BigDecimal(12), new BigDecimal("200"), new BigDecimal("200")),
	ROW(new BigDecimal(20), new BigDecimal(15), new BigDecimal("250"), new BigDecimal("200")),
	SKI_ERG(new BigDecimal(20), new BigDecimal(15), new BigDecimal("250"), new BigDecimal("200")),
	BIKE_ERG(new BigDecimal(12), new BigDecimal(9), new BigDecimal("500"), new BigDecimal("400")),
	AIR_BIKE(new BigDecimal(15), new BigDecimal(10), new BigDecimal("500"), new BigDecimal("400"));

	private BigDecimal menCaloriesPerMinute;
	private BigDecimal womenCaloriesPerMinute;
	private BigDecimal menMeterPerMinute;
	private BigDecimal womenMeterPerMinute;

	private AerobicExerciseType(BigDecimal menCaloriesPerMinute, BigDecimal womenCaloriesPerMinute,
								BigDecimal menMeterPerMinute, BigDecimal womenMeterPerMinute) {
		this.menCaloriesPerMinute = menCaloriesPerMinute;
		this.womenCaloriesPerMinute = womenCaloriesPerMinute;
		this.menMeterPerMinute = menMeterPerMinute;
		this.womenMeterPerMinute = womenMeterPerMinute;
	}

	protected BigDecimal getMenCaloriesPerMinutes(BigDecimal minutes) {
		return this.menCaloriesPerMinute.multiply(minutes);
	}

	protected BigDecimal getWomenCaloriesPerMinutes(BigDecimal minutes) {
		return this.womenCaloriesPerMinute.multiply(minutes);
	}

	protected BigDecimal getMenMeterPerMinutes(BigDecimal minutes) {
		return this.menMeterPerMinute.multiply(minutes);
	}

	protected BigDecimal getWomenMeterPerMinutes(BigDecimal minutes) {
		return this.womenMeterPerMinute.multiply(minutes);
	}

	protected BigDecimal getMenToWomanDistanceConversionRate() {
		return this.womenMeterPerMinute.divide(this.menMeterPerMinute).setScale(2, RoundingMode.HALF_DOWN);
	}

	protected BigDecimal getMenToWomanCaloriesConversionRate() {
		return this.womenCaloriesPerMinute.divide(this.menCaloriesPerMinute).setScale(2, RoundingMode.HALF_DOWN);
	}

	protected BigDecimal getMenDistanceFromCalories(BigDecimal calories) {
		return calories.divide(this.menCaloriesPerMinute).multiply(this.menMeterPerMinute).setScale(2, RoundingMode.HALF_DOWN);
	}

	protected BigDecimal getWomenDistanceFromCalories(BigDecimal calories) {
		return calories.divide(this.womenCaloriesPerMinute).multiply(this.womenMeterPerMinute).setScale(2, RoundingMode.HALF_DOWN);
	}

	protected BigDecimal getMenCaloriesFromDistance(BigDecimal distance) {
		return distance.divide(this.menMeterPerMinute).multiply(this.menCaloriesPerMinute).setScale(2, RoundingMode.HALF_DOWN);
	}

	protected BigDecimal getWomenCaloriesFromDistance(BigDecimal distance) {
		return distance.divide(this.womenMeterPerMinute).multiply(this.womenCaloriesPerMinute).setScale(2, RoundingMode.HALF_DOWN);
	}

	protected BigDecimal getMenDistanceConversionRateTo(AerobicExerciseType unitTo) {
		return unitTo.menMeterPerMinute.divide(this.menMeterPerMinute, 6, RoundingMode.HALF_DOWN);
	}

	protected BigDecimal getMenCaloriesConversionRateTo(AerobicExerciseType unitTo) {
		return unitTo.menCaloriesPerMinute.divide(this.menCaloriesPerMinute,6, RoundingMode.HALF_DOWN);
	}

	protected BigDecimal getWomenDistanceConversionRateTo(AerobicExerciseType unitTo) {
		return unitTo.womenMeterPerMinute.divide(this.womenMeterPerMinute, 6, RoundingMode.HALF_DOWN);
	}

	protected BigDecimal getWomenCaloriesConversionRateTo(AerobicExerciseType unitTo) {
		return unitTo.womenCaloriesPerMinute.divide(this.womenCaloriesPerMinute, 6, RoundingMode.HALF_DOWN);
	}
}

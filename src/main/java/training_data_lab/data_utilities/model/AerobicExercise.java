package training_data_lab.data_utilities.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidParameterException;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class AerobicExercise {

	protected BigDecimal menDistance;
	protected BigDecimal womenDistance;
	protected BigDecimal menCalories;
	protected BigDecimal womenCalories;
	private AerobicExerciseType exercise;

	public static AerobicExercise buildExercicesWithMenDistance(BigDecimal menDistance, AerobicExerciseType exerciseType) {

		checkInputValue(menDistance, exerciseType);

		BigDecimal womenDistance = menDistance.multiply(exerciseType.getMenToWomanDistanceConversionRate()).setScale(2, RoundingMode.HALF_DOWN);

		return new AerobicExercise(
				menDistance,
				womenDistance,
				exerciseType.getMenCaloriesFromDistance(menDistance),
				exerciseType.getWomenCaloriesFromDistance(womenDistance),
				exerciseType
		);
	}

	public static AerobicExercise buildExercicesWithMenCalories(BigDecimal menCalories, AerobicExerciseType exerciseType) {

		checkInputValue(menCalories, exerciseType);

		BigDecimal womenCalories = menCalories.multiply(exerciseType.getMenToWomanCaloriesConversionRate()).setScale(2, RoundingMode.HALF_DOWN);

		return new AerobicExercise(
				exerciseType.getMenDistanceFromCalories(menCalories),
				exerciseType.getWomenDistanceFromCalories(womenCalories),
				menCalories,
				womenCalories,
				exerciseType
		);
	}

	private static void checkInputValue(BigDecimal value, AerobicExerciseType type) {
		if(value == null || type == null || value.compareTo(BigDecimal.ZERO) < 0){
			throw new InvalidParameterException();
		}
	}

	public static AerobicExercise buidExerciseFromTimeInMinutes(BigDecimal minutes, AerobicExerciseType exerciseType) {

		checkInputValue(minutes, exerciseType);

		return new AerobicExercise(
				exerciseType.getMenMeterPerMinutes(minutes),
				exerciseType.getWomenMeterPerMinutes(minutes),
				exerciseType.getMenCaloriesPerMinutes(minutes),
				exerciseType.getWomenCaloriesPerMinutes(minutes),
				exerciseType
		);
	}

	public AerobicExercise convertToExercise(AerobicExerciseType exerciseType) {

		return new AerobicExercise(
				this.exercise.getMenDistanceConversionRateTo(exerciseType).multiply(this.menDistance),
				this.exercise.getWomenDistanceConversionRateTo(exerciseType).multiply(this.womenDistance),
				this.exercise.getMenCaloriesConversionRateTo(exerciseType).multiply(this.menCalories),
				this.exercise.getWomenCaloriesConversionRateTo(exerciseType).multiply(this.womenCalories),
				exerciseType
		);
	}
}

package training_data_lab.data_utilities.unit;

import org.junit.Assert;
import org.junit.Test;
import training_data_lab.data_utilities.model.AerobicExercise;
import training_data_lab.data_utilities.model.AerobicExerciseType;

import java.math.BigDecimal;
import java.security.InvalidParameterException;

public class AerobicExerciseConversionTest {

	@Test
	public void buildAerobicExerciseFromCaloriesTest() {

		AerobicExercise row = AerobicExercise.buildExercicesWithMenCalories(new BigDecimal(10), AerobicExerciseType.ROW);
		Assert.assertEquals(AerobicExerciseType.ROW, row.getExercise());
		Assert.assertEquals(new BigDecimal(10).stripTrailingZeros(), row.getMenCalories().stripTrailingZeros());
		Assert.assertEquals(new BigDecimal(7.5).stripTrailingZeros(), row.getWomenCalories().stripTrailingZeros());
		Assert.assertEquals(new BigDecimal(125).stripTrailingZeros(), row.getMenDistance().stripTrailingZeros());
		Assert.assertEquals(new BigDecimal(100).stripTrailingZeros(), row.getWomenDistance().stripTrailingZeros());
	}

	@Test
	public void buildAerobicExerciseFromDistanceTest() {

		AerobicExercise row = AerobicExercise.buildExercicesWithMenDistance(new BigDecimal(125), AerobicExerciseType.ROW);
		Assert.assertEquals(AerobicExerciseType.ROW, row.getExercise());
		Assert.assertEquals(new BigDecimal(10).stripTrailingZeros(), row.getMenCalories().stripTrailingZeros());
		Assert.assertEquals(new BigDecimal(7.5).stripTrailingZeros(), row.getWomenCalories().stripTrailingZeros());
		Assert.assertEquals(new BigDecimal(125).stripTrailingZeros(), row.getMenDistance().stripTrailingZeros());
		Assert.assertEquals(new BigDecimal(100).stripTrailingZeros(), row.getWomenDistance().stripTrailingZeros());
	}

	@Test
	public void buildAerobicExerciseFromMinutesTest() {

		AerobicExercise row = AerobicExercise.buidExerciseFromTimeInMinutes(new BigDecimal(1), AerobicExerciseType.ROW);
		Assert.assertEquals(AerobicExerciseType.ROW, row.getExercise());
		Assert.assertEquals(new BigDecimal(20).stripTrailingZeros(), row.getMenCalories().stripTrailingZeros());
		Assert.assertEquals(new BigDecimal(15).stripTrailingZeros(), row.getWomenCalories().stripTrailingZeros());
		Assert.assertEquals(new BigDecimal(250).stripTrailingZeros(), row.getMenDistance().stripTrailingZeros());
		Assert.assertEquals(new BigDecimal(200).stripTrailingZeros(), row.getWomenDistance().stripTrailingZeros());
	}

	@Test
	public void testBuildExerciseTestFailure() {

		try {
			AerobicExercise row = AerobicExercise.buildExercicesWithMenDistance(new BigDecimal(125), null);
			Assert.fail();
		} catch (InvalidParameterException e) {
			Assert.assertTrue(true);
		}

		try {
			AerobicExercise row = AerobicExercise.buildExercicesWithMenDistance(null, AerobicExerciseType.ROW);
			Assert.fail();
		} catch (InvalidParameterException e) {
			Assert.assertTrue(true);
		}

		try {
			AerobicExercise row = AerobicExercise.buildExercicesWithMenDistance(new BigDecimal(-125), AerobicExerciseType.ROW);
			Assert.fail();
		} catch (InvalidParameterException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void AerobicExerciseConversioneTest() {

		AerobicExercise row;
		AerobicExercise bike;

		row = AerobicExercise.buildExercicesWithMenCalories(new BigDecimal(10), AerobicExerciseType.ROW);
		bike = row.convertToExercise(AerobicExerciseType.BIKE_ERG);

		Assert.assertEquals(new BigDecimal(6).stripTrailingZeros(), bike.getMenCalories().stripTrailingZeros());
		Assert.assertEquals(new BigDecimal(4.5).stripTrailingZeros(), bike.getWomenCalories().stripTrailingZeros());
		Assert.assertEquals(new BigDecimal(250).stripTrailingZeros(), bike.getMenDistance().stripTrailingZeros());
		Assert.assertEquals(new BigDecimal(200).stripTrailingZeros(), bike.getWomenDistance().stripTrailingZeros());

	}

}

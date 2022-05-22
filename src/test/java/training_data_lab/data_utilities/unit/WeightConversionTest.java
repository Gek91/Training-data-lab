package training_data_lab.data_utilities.unit;

import org.junit.Assert;
import org.junit.Test;
import training_data_lab.data_utilities.model.Weight;
import training_data_lab.data_utilities.model.WeightUnit;

import java.math.BigDecimal;
import java.security.InvalidParameterException;

public class WeightConversionTest {

	@Test
	public void buildWeightTest() {

		Weight kgWeight = Weight.buildWeight(new BigDecimal(1), WeightUnit.KG);
		Assert.assertEquals(WeightUnit.KG, kgWeight.getUnit());
		Assert.assertEquals(new BigDecimal(1), kgWeight.getValue());

		Weight lbWeight = Weight.buildWeight(new BigDecimal(1), WeightUnit.POUND);
		Assert.assertEquals(WeightUnit.POUND, lbWeight.getUnit());
		Assert.assertEquals(new BigDecimal(1), lbWeight.getValue());
	}

	@Test
	public void buildWeightTestFailure() {

		try {
			Weight.buildWeight(null, WeightUnit.KG);
			Assert.fail();
		} catch (InvalidParameterException e) {
			Assert.assertTrue(true);
		}

		try {
			Weight.buildWeight(new BigDecimal(1), null);
			Assert.fail();
		} catch (InvalidParameterException e) {
			Assert.assertTrue(true);
		}

		try {
			Weight.buildWeight(new BigDecimal(-1), WeightUnit.KG);
			Assert.fail();
		} catch (InvalidParameterException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void weightConversionTest() {

		Weight kgWeight;
		Weight lbWeight;

		kgWeight = Weight.buildWeight(new BigDecimal(1), WeightUnit.KG);
		kgWeight = kgWeight.convertToUnit(WeightUnit.KG);
		Assert.assertEquals(WeightUnit.KG, kgWeight.getUnit());
		Assert.assertEquals(new BigDecimal(1).stripTrailingZeros(), kgWeight.getValue().stripTrailingZeros());

		lbWeight = kgWeight.convertToUnit(WeightUnit.POUND);
		Assert.assertEquals(WeightUnit.POUND, lbWeight.getUnit());
		Assert.assertEquals(new BigDecimal("2.20").stripTrailingZeros(), lbWeight.getValue().stripTrailingZeros());

		lbWeight = Weight.buildWeight(new BigDecimal(1), WeightUnit.POUND);
		lbWeight = lbWeight.convertToUnit(WeightUnit.POUND);
		Assert.assertEquals(WeightUnit.POUND, lbWeight.getUnit());
		Assert.assertEquals(new BigDecimal(1).stripTrailingZeros(), lbWeight.getValue().stripTrailingZeros());

		kgWeight = lbWeight.convertToUnit(WeightUnit.KG);
		Assert.assertEquals(WeightUnit.KG, kgWeight.getUnit());
		Assert.assertEquals(new BigDecimal("0.45").stripTrailingZeros(), kgWeight.getValue().stripTrailingZeros());
	}
}

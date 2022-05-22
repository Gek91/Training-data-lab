package training_data_lab.data_utilities.unit;

import org.junit.Assert;
import org.junit.Test;
import training_data_lab.data_utilities.model.Distance;
import training_data_lab.data_utilities.model.DistanceUnit;
import training_data_lab.data_utilities.model.Weight;
import training_data_lab.data_utilities.model.WeightUnit;

import java.math.BigDecimal;

public class DistanceConversionTest {

	@Test
	public void buildCoverage() {

		Distance kmDistance = Distance.buildDistance(new BigDecimal("1.1"), DistanceUnit.KM);
		Assert.assertEquals(DistanceUnit.KM, kmDistance.getUnit());
		Assert.assertEquals(new BigDecimal("1.1"), kmDistance.getValue());
	}

	@Test
	public void distanceConversionTest() {

		Distance distanceKM;
		Distance distanceM;

		distanceKM = Distance.buildDistance(new BigDecimal(1), DistanceUnit.KM);
		distanceKM = distanceKM.convertToUnit(DistanceUnit.KM);
		Assert.assertEquals(DistanceUnit.KM, distanceKM.getUnit());
		Assert.assertEquals(new BigDecimal(1).stripTrailingZeros(), distanceKM.getValue().stripTrailingZeros());

		distanceM = distanceKM.convertToUnit(DistanceUnit.M);
		Assert.assertEquals(DistanceUnit.M, distanceM.getUnit());
		Assert.assertEquals(new BigDecimal(1000).stripTrailingZeros(), distanceM.getValue().stripTrailingZeros());

	}
}

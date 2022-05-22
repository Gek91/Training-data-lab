package training_data_lab.data_utilities;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import training_data_lab.data_utilities.unit.DistanceConversionTest;
import training_data_lab.data_utilities.unit.WeightConversionTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		WeightConversionTest.class,
		DistanceConversionTest.class
})
public class DataUtilitiesTestSuite {
}

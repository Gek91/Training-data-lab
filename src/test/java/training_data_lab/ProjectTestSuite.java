package training_data_lab;

import training_data_lab.data_utilities.DataUtilitiesTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import training_data_lab.data_utilities.unit.AerobicExerciseConversionTest;
import training_data_lab.data_utilities.unit.DistanceConversionTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		DataUtilitiesTestSuite.class,
		AerobicExerciseConversionTest.class,
		DistanceConversionTest.class
})
public class ProjectTestSuite {
}

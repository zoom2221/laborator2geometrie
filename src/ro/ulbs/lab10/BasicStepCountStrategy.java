package ro.ulbs.lab10;
import dataprocessing.StepCountStrategy;
import storage.SensorData;
import java.util.List;

public class BasicStepCountStrategy implements StepCountStrategy {
    @Override
    public int getTotalSteps(List<SensorData> sensorDataList) {
        return sensorDataList.stream()
                .mapToInt(SensorData::getStepsCount)
                .sum();
    }
}

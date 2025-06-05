package ro.ulbs.lab10;
import java.util.List;
import storage.SensorData;

public interface StepCountStrategy {
    int getTotalSteps(List<SensorData> sensorDataList);
}

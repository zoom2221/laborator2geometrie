package ro.ulbs.lab10;
import dataprocessing.StepCountStrategy;
import storage.SensorData;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class FilteredStepCountStrategy implements StepCountStrategy {
    @Override
    public int getTotalSteps(List<SensorData> sensorDataList) {
        return sensorDataList.stream()
                .filter(data -> data.getStepsCount() > 0) // Pasii trebuie să fie pozitivi
                .filter(data -> {
                    // Verifică dacă în ultimul minut nu sunt mai mult de 1000 de pași
                    LocalDateTime currentTime = data.getTimestamp();
                    long stepsInLastMinute = sensorDataList.stream()
                            .filter(d -> Duration.between(d.getTimestamp(), currentTime).toMinutes() < 1)
                            .mapToInt(SensorData::getStepsCount)
                            .sum();
                    return stepsInLastMinute <= 1000;
                })
                .mapToInt(SensorData::getStepsCount)
                .sum();
    }
}

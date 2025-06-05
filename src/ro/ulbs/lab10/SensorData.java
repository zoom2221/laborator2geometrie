package ro.ulbs.lab10;
import java.time.LocalDateTime;

public class SensorData {
    private final int stepsCount;
    private final LocalDateTime timestamp;

    public SensorData(int stepsCount, LocalDateTime timestamp) {
        this.stepsCount = stepsCount;
        this.timestamp = timestamp;
    }

    public int getStepsCount() {
        return stepsCount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

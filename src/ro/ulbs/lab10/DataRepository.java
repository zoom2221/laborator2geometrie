package ro.ulbs.lab10;
import storage.SensorData;
import java.util.ArrayList;
import java.util.List;

public class DataRepository {
    private static DataRepository instance;
    private final List<SensorData> sensorDataList;

    private DataRepository() {
        sensorDataList = new ArrayList<>();
    }

    public static DataRepository getInstance() {
        if (instance == null) {
            synchronized (DataRepository.class) {
                if (instance == null) {
                    instance = new DataRepository();
                }
            }
        }
        return instance;
    }

    public void addSensorData(SensorData data) {
        sensorDataList.add(data);
    }

    public List<SensorData> getAllSensorData() {
        return new ArrayList<>(sensorDataList); // Return a copy to avoid mutation
    }
}

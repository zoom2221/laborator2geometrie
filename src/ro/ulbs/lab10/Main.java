package ro.ulbs.lab10;
import dataprocessing.StepCountStrategy;
import dataprocessing.impl.BasicStepCountStrategy;
import dataprocessing.impl.FilteredStepCountStrategy;
import storage.DataRepository;
import storage.SensorData;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataRepository dataRepository = DataRepository.getInstance();

        // Adaugăm simulat date de la senzor
        dataRepository.addSensorData(new SensorData(500, LocalDateTime.now().minusSeconds(30)));
        dataRepository.addSensorData(new SensorData(1500, LocalDateTime.now().minusSeconds(20)));
        dataRepository.addSensorData(new SensorData(800, LocalDateTime.now().minusSeconds(10)));

        // Luăm toate datele din DataRepository
        List<SensorData> sensorDataList = dataRepository.getAllSensorData();

        // Utilizăm BasicStepCountStrategy
        StepCountStrategy basicStrategy = new BasicStepCountStrategy();
        System.out.println("Basic Strategy Total Steps: " + basicStrategy.getTotalSteps(sensorDataList));

        // Utilizăm FilteredStepCountStrategy
        StepCountStrategy filteredStrategy = new FilteredStepCountStrategy();
        System.out.println("Filtered Strategy Total Steps: " + filteredStrategy.getTotalSteps(sensorDataList));
    }
}

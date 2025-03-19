package Lab_2_2.lab_5;

public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.start();

        Car car = new Car(trafficLight);
        car.start();

        // Даем поработать некоторое время
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        car.stopCar();
        trafficLight.stopTrafficLight();
    }
}



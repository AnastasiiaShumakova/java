package Lab_2_2.lab_5;

public class Car extends Thread {
    private final TrafficLight trafficLight;
    private volatile boolean running = true; // Флаг для управления циклом

    public Car(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public void run() {
        try {
            while (running) {
                trafficLight.waitOnRed();
                Thread.sleep(1000); // Симулировать движение
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Машина остановлена.");
        }
    }

    public void stopCar() {
        running = false;
        interrupt(); // Прерывание для немедленного выхода из wait()
    }
}



package Lab_2_2.lab_3;


public class Car extends Thread {
    private final Crossing crossing;
    private final String carName;
    private volatile boolean running = true; // Флаг для управления циклом

    public Car(Crossing crossing, String carName) {
        this.crossing = crossing;
        this.carName = carName;
    }

    @Override
    public void run() {
        try {
            while (running) {
                crossing.carWaits(carName);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            running = false; // Установить флаг для выхода из цикла
        }
    }

    public void stopCar() {
        interrupt();
    }
}


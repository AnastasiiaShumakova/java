package Lab_2_2.lab_3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Crossing crossing = new Crossing();

        Train train = new Train(crossing);
        train.start();

        Car[] cars = new Car[5];
        for (int i = 1; i <= 5; i++) {
            cars[i - 1] = new Car(crossing, "Машина " + i);
            cars[i - 1].start();
        }

        Thread.sleep(20000); // Дать потокам поработать некоторое время

        train.stopTrain();
        for (Car car : cars) {
            car.stopCar();
        }
    }
}

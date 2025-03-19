package Lab_2_2.lab_1;

public class Car implements Runnable {
    private final String name;
    private final GasStation gasStation;

    public Car(String name, GasStation gasStation) {
        this.name = name;
        this.gasStation = gasStation;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            gasStation.arriveAtStation(this); // Подъезжаем к станции и ждём своей очереди

            System.out.println(name + " заправляется.");
            Thread.sleep((long) (Math.random() * 3000)); // Имитация времени заправки

            gasStation.leaveStation(this); // Освобождаем колонку после заправки

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(name + " была прервана.");
        }
    }
}




package Lab_2_2.lab_1;

import java.util.concurrent.LinkedBlockingQueue;

public class GasStation {
    private final int totalPumps = 2; // Всего колонок
    private int availablePumps = totalPumps; // Доступные колонки
    private final LinkedBlockingQueue<Car> queue = new LinkedBlockingQueue<>(); // Очередь машин

    public synchronized void arriveAtStation(Car car) throws InterruptedException {
        queue.put(car); // Добавляем машину в очередь
        System.out.println(car.getName() + " подъехала к АЗС и встала в очередь.");
        while (queue.peek() != car || availablePumps == 0) {
            wait(); // Ждём своей очереди или освобождения колонки
        }
        queue.poll(); // Убираем машину из очереди
        availablePumps--; // Занимаем колонку
    }

    public synchronized void leaveStation(Car car) {
        availablePumps++; // Освобождаем колонку
        System.out.println(car.getName() + " освободила колонку.");
        notify(); // Уведомляем другие машины
    }
}



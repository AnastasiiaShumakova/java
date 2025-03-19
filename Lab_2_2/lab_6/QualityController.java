package Lab_2_2.lab_6;

import java.util.concurrent.BlockingQueue;

public class QualityController extends Worker {
    private volatile boolean running = true;

    public QualityController(BlockingQueue<Detail> inputQueue) {
        super("Оператор контроля", inputQueue, null);
    }

    @Override
    public void run() {
        while (running) {
            try {
                Detail detail = inputQueue.take(); // Получить деталь от сборщика
                processDetail(detail); // Проверить деталь
                Thread.sleep((long) (Math.random() * 1000)); // Случайная задержка
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                running = false;
            }
        }
    }

    @Override
    public void processDetail(Detail detail) {
        if (Math.random() < 0.2) { // 20% шанс брака
            System.out.println(getName() + ": Деталь " + detail.getId() + " не соответствует стандарту. Отправлена на доработку.");
        } else {
            System.out.println(getName() + ": Деталь " + detail.getId() + " проверена и отправлена на склад");
        }
    }

    public void stopQualityController() {
        running = false;
        interrupt();
    }
}

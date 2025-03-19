package Lab_2_2.lab_6;

import java.util.concurrent.BlockingQueue;

public class Stamper extends Worker {
    private volatile boolean running = true;

    public Stamper(BlockingQueue<Detail> outputQueue) {
        super("Штамповщик", null, outputQueue);
    }

    @Override
    public void run() {
        int detailId = 1;
        while (running) {
            try {
                Detail detail = new Detail(detailId);
                processDetail(detail); // Создать заготовку
                outputQueue.put(detail); // Передать заготовку сборщику
                detailId++;
                Thread.sleep((long) (Math.random() * 1000)); // Случайная задержка
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                running = false;
            }
        }
    }

    @Override
    public void processDetail(Detail detail) {
        System.out.println(getName() + ": Заготовка " + detail.getId() + " создана");
    }

    public void stopStamper() {
        running = false;
        interrupt();
    }
}





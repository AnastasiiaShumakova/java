package Lab_2_2.lab_6;

import java.util.concurrent.BlockingQueue;

public class Assembler extends Worker {
    private volatile boolean running = true;

    public Assembler(BlockingQueue<Detail> inputQueue, BlockingQueue<Detail> outputQueue) {
        super("Сборщик", inputQueue, outputQueue);
    }

    @Override
    public void run() {
        while (running) {
            try {
                Detail detail = inputQueue.take(); // Получить заготовку от штамповщика
                processDetail(detail); // Обработать заготовку
                outputQueue.put(detail); // Передать деталь оператору контроля
                Thread.sleep((long) (Math.random() * 1000)); // Случайная задержка
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                running = false;
            }
        }
    }

    @Override
    public void processDetail(Detail detail) {
        System.out.println(getName() + ": Заготовка " + detail.getId() + " обработана");
    }

    public void stopAssembler() {
        running = false;
        interrupt();
    }
}




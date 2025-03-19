package Lab_2_2.lab_3;


public class Train extends Thread {
    private final Crossing crossing;
    private volatile boolean running = true; // Флаг для управления циклом

    public Train(Crossing crossing) {
        this.crossing = crossing;
    }

    @Override
    public void run() {
        try {
            while (running) {
                crossing.trainArrives();
                Thread.sleep(3000);
                crossing.trainDeparts();
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            running = false; // Установить флаг для выхода из цикла
            System.out.println("Все уехали!!!");
        }
    }

    public void stopTrain() {
        interrupt();
    }
}


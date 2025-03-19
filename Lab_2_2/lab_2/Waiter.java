package Lab_2_2.lab_2;

public class Waiter implements Runnable {
    private final Tray tray;

    public Waiter(Tray tray) {
        this.tray = tray;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 4; i++) { // Официант обслуживает 4 блюда
                tray.takeDish(); // Официант берет блюдо с подноса и автоматически выводит информацию о состоянии подноса
                Thread.sleep(1500); // Имитация времени подачи блюда
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Официант был прерван.");
        }
    }
}





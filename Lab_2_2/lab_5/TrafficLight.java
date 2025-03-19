package Lab_2_2.lab_5;

public class TrafficLight extends Thread {
    private boolean isRed = true; // Флаг цвета светофора
    private volatile boolean running = true; // Флаг для управления циклом
    private boolean carsWaited = false; // Флаг: машины ждали
    private boolean carPassed = false; // Флаг: машина проехала

    @Override
    public void run() {
        while (running) {
            try {
                if (isRed) { // Исправлено условие для зеленого света
                    System.out.println("Зеленый свет!");
                    carPassed = false; // Сброс флага при зеленом свете
                    notifyAllCars(); // Пробудить машины
                } else {
                    System.out.println("Красный свет!");
                    carsWaited = false; // Сброс флага при красном свете
                }
                isRed = !isRed; // Переключить цвет
                Thread.sleep(5000); // Ждать 5 секунд
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Светофор остановлен.");
                running = false; // Остановить цикл
            }
        }
    }

    public synchronized void notifyAllCars() {
        notifyAll(); // Пробудить машины
    }

    public synchronized void waitOnRed() throws InterruptedException {
        if (!isRed) {
            if (!carPassed) {
                System.out.println("Машины поехали.");
                carPassed = true;
            }
        } else {
            if (!carsWaited) {
                System.out.println("Машины ждут.");
                carsWaited = true;
            }
            wait();
        }
    }

    public void stopTrafficLight() {
        running = false;
        interrupt(); // Прерывание для немедленного выхода из wait()
    }
}








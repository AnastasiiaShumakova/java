package Lab_2_2.lab_2;

public class Main {
    public static void main(String[] args) {
        Tray tray = new Tray(); // Создаем поднос

        Chef chef = new Chef(tray); // Создаем повара
        Waiter waiter = new Waiter(tray); // Создаем официанта

        Thread chefThread = new Thread(chef); // Поток для повара
        Thread waiterThread = new Thread(waiter); // Поток для официанта

        chefThread.start(); // Запускаем поток повара
        waiterThread.start(); // Запускаем поток официанта

        try {
            chefThread.join(); // Ждем завершения потока повара
            waiterThread.join(); // Ждем завершения потока официанта
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Главный поток был прерван.");
        }
    }
}


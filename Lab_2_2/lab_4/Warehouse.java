package Lab_2_2.lab_4;

public class Warehouse {
    private int maxProducts = 5;
    private int currentProducts = 0;

    public synchronized void addProduct() throws InterruptedException {
        while (currentProducts == maxProducts) {
            System.out.println("Склад заполнен. Производитель ждет.");
            wait();
        }
        currentProducts++;
        System.out.println("Добавлен товар. Всего товаров: " + currentProducts);
        notify();
    }

    public synchronized void removeProduct() throws InterruptedException {
        System.out.println("Потребитель хочет забрать товар");

        if (currentProducts == 0) {
            System.out.println("Товаров нет. Потребитель ждет.");
        }

        while (currentProducts == 0) {
            wait();
        }

        currentProducts--;
        System.out.println("Удален товар. Всего товаров: " + currentProducts);
        notify();
    }
}









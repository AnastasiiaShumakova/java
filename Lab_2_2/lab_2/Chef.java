package Lab_2_2.lab_2;

public class Chef implements Runnable {
    private final Tray tray;

    public Chef(Tray tray) {
        this.tray = tray;
    }

    @Override
    public void run() {
        String[] dishes = {"Салат", "Суп", "Основное блюдо", "Десерт"};

        try {
            for (String dish : dishes) {
                tray.addDish(dish); // Повар готовит блюдо и добавляет его на поднос
                Thread.sleep(1000); // Имитация времени приготовления блюда
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Повар был прерван.");
        }
    }
}





package Lab_2_2.lab_4;

class Consumer extends Thread {
    private final Warehouse warehouse;

    public Consumer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                warehouse.removeProduct();
                Thread.sleep(1500); // Потребление
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

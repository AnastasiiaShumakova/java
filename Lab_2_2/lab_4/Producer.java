package Lab_2_2.lab_4;

class Producer extends Thread {
    private final Warehouse warehouse;

    public Producer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                warehouse.addProduct();
                Thread.sleep(500); // Производство
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


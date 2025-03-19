package Lab_2_2.lab_3;


public class Crossing {
    private boolean trainApproaching = false;

    public synchronized void trainArrives() throws InterruptedException {
        trainApproaching = true;
        System.out.println("Поезд приближается.");
        Thread.sleep(2000);
    }

    public synchronized void trainDeparts() {
        trainApproaching = false;
        System.out.println("Поезд проехал.");
        notifyAll();
    }

    public synchronized void carWaits(String carName) throws InterruptedException {
        while (trainApproaching) {
            System.out.println(carName + " останавливается и ждет!");
            wait();
        }
        System.out.println(carName + " продолжает движение.");
    }
}

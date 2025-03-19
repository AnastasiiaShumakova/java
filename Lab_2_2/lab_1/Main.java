package Lab_2_2.lab_1;


public class Main {
    public static void main(String[] args) {
        GasStation station = new GasStation();

        for (int i = 1; i <= 5; i++) {
            new Thread(new Car("Машина-" + i, station)).start();
        }
    }
}




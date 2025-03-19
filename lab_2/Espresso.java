package lab_2;

public class Espresso implements Coffee {
    @Override
    public double getCost() {
        return 2.5; // Базовая цена
    }

    public int getCalories() {
        return 5; // Базовая калорийность
    }

    @Override
    public String getDescription() {
        return "Эспрессо";
    }
}

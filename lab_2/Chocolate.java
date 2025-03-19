package lab_2;

public class Chocolate extends CoffeeDecorator {
    public Chocolate(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.00;
    }

    @Override
    public int getCalories() {
        return super.getCalories() + 80;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", шоколад";
    }
}

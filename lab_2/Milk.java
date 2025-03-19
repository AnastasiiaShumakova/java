package lab_2;

public class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }

    @Override
    public int getCalories() {
        return super.getCalories() + 50;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", молоко";
    }
}

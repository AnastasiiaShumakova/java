package lab_2;

public class SizeDecorator extends CoffeeDecorator {
    public SizeDecorator(Coffee coffee, String size) {
        super(coffee);
        this.size = size;
    }

    @Override
    public double getCost() {
        switch (size) {
            case "small":
                return super.getCost() + 0.3;
            case "medium":
                return super.getCost() + 0.5;
            case "large":
                return super.getCost() + 0.7;
        }
        return super.getCost();
    }

    @Override
    public int getCalories() {
        switch (size) {
            case "small":
                return super.getCalories() + 10;
            case "medium":
                return super.getCalories() + 20;
            case "large":
                return super.getCalories() + 30;
        }
        return super.getCalories();
    }


    @Override
    public String getDescription() {
        switch (size) {
            case "small":
                return "SMALL " + coffee.getDescription();
            case "medium":
                return "MEDIUM " + coffee.getDescription();
            case "large":
                return "LARGE " + coffee.getDescription();
        }
        return coffee.getDescription();
    }
}

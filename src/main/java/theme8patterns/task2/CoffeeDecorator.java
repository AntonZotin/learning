package theme8patterns.task2;

public abstract class CoffeeDecorator implements Coffee {
    protected final Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int getCost() {
        return this.coffee.getCost();
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription();
    }
}

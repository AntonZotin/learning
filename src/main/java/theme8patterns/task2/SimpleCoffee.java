package theme8patterns.task2;

public class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Простой кофе";
    }

    @Override
    public int getCost() {
        return 3;
    }
}

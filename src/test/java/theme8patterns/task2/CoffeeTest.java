package theme8patterns.task2;

import org.junit.jupiter.api.Test;

class CoffeeTest {

    @Test
    void test() {
        Coffee coffee = new SimpleCoffee();
        System.out.println(String.format("%s стоит %d$", coffee.getDescription(), coffee.getCost()));
        coffee = new MilkCoffeeDecorator(coffee);
        System.out.println(String.format("%s стоит %d$", coffee.getDescription(), coffee.getCost()));
        coffee = new SugarCoffeeDecorator(coffee);
        System.out.println(String.format("%s стоит %d$", coffee.getDescription(), coffee.getCost()));
    }
}

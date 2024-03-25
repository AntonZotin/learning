package theme10solid.task2;

import org.junit.jupiter.api.Test;
import theme10solid.task2.bad.BadDiscountCalculator;
import theme10solid.task2.good.DiscountCalculator;
import theme10solid.task2.good.FullDiscountCalculator;
import theme10solid.task2.good.HalfDiscountCalculator;

class DiscountTest {
    @Test
    void test() {
        // bad
        BadDiscountCalculator badCalculator = new BadDiscountCalculator();
        System.out.println(badCalculator.getDiscount("half"));
        System.out.println(badCalculator.getDiscount("full"));

        // good
        DiscountCalculator calculator = new HalfDiscountCalculator();
        System.out.println(calculator.getDiscount());
        calculator = new FullDiscountCalculator();
        System.out.println(calculator.getDiscount());
    }
}

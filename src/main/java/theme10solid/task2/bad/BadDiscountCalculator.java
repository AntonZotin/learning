package theme10solid.task2.bad;

public class BadDiscountCalculator {
    public int getDiscount(String discount) {
        if (discount.equals("half"))
            return 5;
        else if (discount.equals("full"))
            return 10;
        return 0;
    }
}

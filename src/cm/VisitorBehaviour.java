package cm;

import java.math.BigDecimal;

class VisitorBehaviour implements PaymentStrategy{
    @Override
    public BigDecimal paymentBehaviour(BigDecimal amount) {
        if (amount.doubleValue() <= 10) // if the price is 10 or under
            return BigDecimal.valueOf(0);
        else { // subtract 10, then halve the price.
            amount = amount.subtract(BigDecimal.valueOf(10)).multiply(BigDecimal.valueOf(0.5));
            amount = amount.setScale(2, BigDecimal.ROUND_HALF_EVEN); // rounds amount to 2 decimal places
            return amount;
        }
    }
}

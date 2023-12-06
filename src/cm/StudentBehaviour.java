package cm;

import java.math.BigDecimal;

class StudentBehaviour implements PaymentStrategy{
    @Override
    public BigDecimal paymentBehaviour(BigDecimal amount) {
        if (amount.doubleValue() > 5.5) // if the price is above 5.50, take away 33%
            return BigDecimal.valueOf(amount.doubleValue()).subtract(
                    BigDecimal.valueOf(amount.doubleValue()).multiply(BigDecimal.valueOf(0.33)));
        return amount;
    }
}

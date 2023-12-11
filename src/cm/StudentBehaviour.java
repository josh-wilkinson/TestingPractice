package cm;

import java.math.BigDecimal;

class StudentBehaviour implements PaymentStrategy{
    @Override
    public BigDecimal paymentBehaviour(BigDecimal amount) {
        if (amount.doubleValue() > 5.5) { // if the price is above 5.50, take away 33% on any amount about it
            amount = amount.subtract(BigDecimal.valueOf(amount.doubleValue()-5.50).multiply(BigDecimal.valueOf(0.33)));
            amount = amount.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            return amount;
        }
        return amount;
    }
}

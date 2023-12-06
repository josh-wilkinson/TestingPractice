package cm;

import java.math.BigDecimal;

class ManagementBehaviour implements PaymentStrategy{
    @Override
    public BigDecimal paymentBehaviour(BigDecimal amount) {
        if (amount.doubleValue() < 5)
            return BigDecimal.valueOf(5);
        return amount;
    }
}

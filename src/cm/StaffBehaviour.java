package cm;

import java.math.BigDecimal;

class StaffBehaviour implements PaymentStrategy{
    @Override
    public BigDecimal paymentBehaviour(BigDecimal amount) {
        if (amount.doubleValue() > 10.0)
            return BigDecimal.valueOf(10);
        return amount;
    }
}

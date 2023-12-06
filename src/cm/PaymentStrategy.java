package cm;

import java.math.BigDecimal;

// Strategy Interface
public interface PaymentStrategy
{
    public BigDecimal paymentBehaviour(BigDecimal amount);
}
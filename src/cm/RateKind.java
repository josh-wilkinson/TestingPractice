package cm;

import java.math.BigDecimal;

public interface RateKind
{
    public BigDecimal paymentBehaviour(BigDecimal amount);
}
class VisitorRate implements RateKind{
    @Override
    public BigDecimal paymentBehaviour(BigDecimal amount) {
        if (amount.doubleValue() <= 10) // if the price is 10 or under
            return BigDecimal.valueOf(0);
        else // subtract 10, then halve the price.
            return amount.subtract(BigDecimal.valueOf(10)).multiply(BigDecimal.valueOf(0.5));
    }
}
class ManagementRate implements RateKind{
    @Override
    public BigDecimal paymentBehaviour(BigDecimal amount) {
        if (amount.doubleValue() < 5)
            return BigDecimal.valueOf(5);
        return amount;
    }
}
class StudentRate implements RateKind{
    @Override
    public BigDecimal paymentBehaviour(BigDecimal amount) {
        if (amount.doubleValue() > 5.5) // if the price is above 5.50, take away 33%
            return BigDecimal.valueOf(amount.doubleValue()).subtract(
                    BigDecimal.valueOf(amount.doubleValue()).multiply(BigDecimal.valueOf(0.33)));
        return amount;
    }
}
class StaffRate implements RateKind{
    @Override
    public BigDecimal paymentBehaviour(BigDecimal amount) {
        if (amount.doubleValue() > 10.0)
            return BigDecimal.valueOf(10);
        return amount;
    }
}


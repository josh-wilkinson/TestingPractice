package cm;

import java.math.BigDecimal;

public class Rate
{
    enum CarParkKind
    {
        STAFF,
        STUDENT,
        MANAGEMENT,
        VISITOR
    }
    CarParkKind kind;
    BigDecimal hourlyNormalRate;
    BigDecimal hourlyReducedRate;
    public Rate()
    {

    }
}

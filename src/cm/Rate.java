package cm;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Rate
{
    public enum CarParkKind
    {
        STAFF,
        STUDENT,
        MANAGEMENT,
        VISITOR
    }
    CarParkKind kind;
    BigDecimal hourlyNormalRate;
    BigDecimal hourlyReducedRate;
    public Rate(CarParkKind kind, BigDecimal normalRate, BigDecimal reducedRate, ArrayList<Period> normalPeriods, ArrayList<Period> reducedPeriods)
    {

    }
    public BigDecimal calculate(Period periodStay)
    {
        return BigDecimal.valueOf(0);
    }
}

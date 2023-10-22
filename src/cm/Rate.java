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
        /*
         the calculate method returns the charge that a driver has to pay
         for a stay in a car park of a particular kind. The length of
         stay is defined by a Period (periodStay).
        */
        return BigDecimal.valueOf(0);
    }
}

package cm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/*
    Purpose: TDD tests for Rate class
    Author: Joshua Wilkinson
 */
public class RateTestTDD
{
    // VISITOR
    @DisplayName("Test VISITOR pays, expected 2.50")
    @Test
    void visitorPays(){
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(3);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(7, 10));
        reducedPeriods.add(new Period(15, 17));
        reducedPeriods.add(new Period(13, 15));

        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        Period periodStay = new Period(9, 13);
        assertEquals(2.50, r.calculate(periodStay).doubleValue());
    }
}

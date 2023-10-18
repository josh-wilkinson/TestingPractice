import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    @Test
    void twoPlusTwoEqualsFour(){
        // var infers the type, which should be SimpleCalculator
        var calculator = new SimpleCalculator();
        assertEquals(4, calculator.add(2,2));
    }
}
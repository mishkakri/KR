package pi.KR;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 * Тест формулы расчета с капитализацией 
 *
 */
class Calculation_kapitalON {
    @Test
    void calcWithCap() {
        assertEquals("179585.63", Calculation.kapitalOn(100000, 5, 12));
    }

    @Test
    void calcWithCap1() {
        assertEquals("197544.19", Calculation.kapitalOn(110000, 5, 12));
    }

    @Test
    void calcWithCap2() {
        assertEquals("316227.66", Calculation.kapitalOn(145600, 12, 9));
    }

    @Test
    void calcWithCap3() {
        assertEquals("70010.78", Calculation.kapitalOn(65490, 9, 3));
    }

    @Test
    void calcWithCap4() {
        assertEquals("1.15", Calculation.kapitalOn(9453000, 10, 5));
    }
}
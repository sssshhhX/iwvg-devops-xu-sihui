package es.upm.miw.devops.functionaltests;

import es.upm.miw.devops.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 class FractionTest {

    @Test
     void testConstructorWithParameters() {
        Fraction fraction = new Fraction(3, 4);
        assertEquals(3, fraction.getNumerator());
        assertEquals(4, fraction.getDenominator());
    }

    @Test
     void testDefaultConstructor() {
        Fraction fraction = new Fraction();
        assertEquals(1, fraction.getNumerator());
        assertEquals(1, fraction.getDenominator());
    }

    @Test
     void testSetNumerator() {
        Fraction fraction = new Fraction();
        fraction.setNumerator(5);
        assertEquals(5, fraction.getNumerator());
    }

    @Test
     void testSetDenominator() {
        Fraction fraction = new Fraction();
        fraction.setDenominator(7);
        assertEquals(7, fraction.getDenominator());
    }

    @Test
     void testDecimal() {
        Fraction fraction = new Fraction(1, 4);
        assertEquals(0.25, fraction.decimal(), 0.0001); // delta por precisión de double
    }

    @Test
     void testDecimalWithNegativeValues() {
        Fraction fraction = new Fraction(-1, 2);
        assertEquals(-0.5, fraction.decimal(), 0.0001);
    }

    @Test
     void testDecimalZeroNumerator() {
        Fraction fraction = new Fraction(0, 5);
        assertEquals(0.0, fraction.decimal(), 0.0001);
    }

    @Test
     void testToString() {
        Fraction fraction = new Fraction(2, 3);
        String expected = "Fraction{numerator=2, denominator=3}";
        assertEquals(expected, fraction.toString());
    }
}

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

    @Test
    void testIsProper() {
        assertTrue(new Fraction(1, 2).isProper());
        assertTrue(new Fraction(-3, 5).isProper());
        assertFalse(new Fraction(5, 3).isProper());
        assertFalse(new Fraction(4, 4).isProper());
    }

    @Test
    void testIsImproper() {
        assertTrue(new Fraction(5, 3).isImproper());
        assertTrue(new Fraction(4, 4).isImproper());
        assertFalse(new Fraction(2, 3).isImproper());
        assertFalse(new Fraction(-1, 4).isImproper());
    }

    @Test
    void testIsEquivalent() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 4);
        Fraction f3 = new Fraction(3, 4);

        assertTrue(f1.isEquivalent(f2));
        assertFalse(f1.isEquivalent(f3));
    }

    @Test
    void testAdd() {
        Fraction f1 = new Fraction(1, 4);
        Fraction f2 = new Fraction(1, 2);
        Fraction result = f1.add(f2);  // 1/4 + 1/2 = 3/4

        assertEquals(6, result.getNumerator());
        assertEquals(8, result.getDenominator());
    }

    @Test
    void testMultiply() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(3, 4);
        Fraction result = f1.multiply(f2);  // 2/3 * 3/4 = 6/12

        assertEquals(6, result.getNumerator());
        assertEquals(12, result.getDenominator());
    }

    @Test
    void testDivide() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 4);
        Fraction result = f1.divide(f2);  // (1/2) / (1/4) = 4/2

        assertEquals(4, result.getNumerator());
        assertEquals(2, result.getDenominator());
    }

}

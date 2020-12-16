import static org.junit.jupiter.api.Assertions.*;

public class Tests
{

    void testDecimal()
    {
        assertEquals(Integer.valueOf(44), Integer.decode("44"));
    }

    void testSignedDecimal()
    {
        assertEquals(Integer.valueOf(-44), Integer.decode("-44"));
    }

    void testFormatExceptionOnEmptyString()
    {
        assertThrows(NumberFormatException.class, () -> Integer.decode(""));
    }

    void testFormatExceptionOnWrongSignCharPosition()
    {
        assertThrows(NumberFormatException.class, () -> Integer.decode("1-234"));
    }

    void testOctalNumber()
    {
        assertEquals(Integer.valueOf(64), Integer.decode("0100"));
    }

    void testNegativeOctalNumber()
    {
        assertEquals(Integer.valueOf(-297), Integer.decode("-0451"));
    }

    void testHexadecimalNumber()
    {
        assertEquals(Integer.valueOf(476), Integer.decode("0X1dc"));
    }

    void testNegativeHexadecimalNumber()
    {
        assertEquals(Integer.valueOf(-241), Integer.decode("-#F1"));
    }

    void testHexadecimalNumberDifferentSymbol()
    {
        assertEquals(Integer.valueOf(1024), Integer.decode("#400"));
    }

    void testFormatExceptionOnWrongInput()
    {
        assertThrows(NumberFormatException.class, () -> Integer.decode("ABCD"));
    }

    void testWrongOctalNumber()
    {
        assertThrows(NumberFormatException.class, () -> Integer.decode("09121"));
    }

    void testWrongHexadecimalNumber()
    {
        assertThrows(NumberFormatException.class, () -> Integer.decode("x0114"));
    }

    void testNumbersWithPositiveSign()
    {
        assertAll(
                () -> assertEquals(Integer.valueOf(50), Integer.decode("+50")),
                () -> assertEquals(Integer.valueOf(276), Integer.decode("+0x114")),
                () -> assertEquals(Integer.valueOf(1024), Integer.decode("+#400")),
                () -> assertEquals(Integer.valueOf(81), Integer.decode("+0121"))
        );
    }
    void testIntegerOverflow()
    {
        assertAll(
                () -> assertThrows(NumberFormatException.class, () -> Integer.decode("21474836478")),
                () -> assertThrows(NumberFormatException.class, () -> Integer.decode("-21474836478"))
        );
    }
}
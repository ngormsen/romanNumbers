import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RomanNumbersTest {

    private RomanNumbers romanNumbers;

    @BeforeAll
    void setUp(){
        romanNumbers = new RomanNumbers();
    }

    @ParameterizedTest
    @CsvSource({
            "MMXXI, 2021",
            "XXXIX, 39",
            "CCXLVI, 246",
            "DCCLXXXIX, 789",
            "MMCDXXI, 2421",
            "D, 500",
            "I, 1",
            "X1, Wrong input!"
    })
    void should_return_correct_arabic_number_when_receiving_roman_number(String input, String expected ){
        String output = romanNumbers.parseRomanNumbersToArabicNumbersOrArabicNumbersToRomanNumbers(input);
        assertEquals(expected, output);
    }

    @ParameterizedTest
    @CsvSource({
            "2021, MMXXI",
            "39, XXXIX",
            "246, CCXLVI",
            "789, DCCLXXXIX",
            "2421, MMCDXXI",
            "500, D",
            "1, I",
            "1X, Wrong input!"
    })
    void should_return_correct_roman_number_when_receiving_arabic_number(String input, String expected ){
        String output = romanNumbers.parseRomanNumbersToArabicNumbersOrArabicNumbersToRomanNumbers(input);
        assertEquals(expected, output);
    }




}
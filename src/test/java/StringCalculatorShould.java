import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculatorShould {
    private StringCalculator stringCalculator;

    @BeforeEach
    void init() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource({
            "'',0"
    })
    void return_zero_if_given_empty_string(String input, int output) {
        stringCalculator = new StringCalculator();

        int result = stringCalculator.add(input);

        assertThat(result).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource({
            "'1,a',1"
    })
    void ignore_all_not_integer_numbers(String input, int output) {
        stringCalculator = new StringCalculator();

        int result = stringCalculator.add(input);

        assertThat(result).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource({
            "'1,2',3",
            "'1,2,1',4"
    })
    void sum_the_numbers_separated_by_commas(String input, int output) {
        stringCalculator = new StringCalculator();

        int result = stringCalculator.add(input);

        assertThat(result).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource({
            "'1\n2',3",
            "'1,2\n1',4"
    })
    void sum_the_numbers_separated_by_commas_and_new_lines(String input, int output) {
        stringCalculator = new StringCalculator();

        int result = stringCalculator.add(input);

        assertThat(result).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource({
            "'//;\n1;2;3', 6"
    })
    void sum_the_numbers_separated_by_custom_delimiters(String input, int output) {
        stringCalculator = new StringCalculator();

        int result = stringCalculator.add(input);

        assertThat(result).isEqualTo(output);
    }

    @Test
    void throw_exception_if_given_negative_number() {
        stringCalculator = new StringCalculator();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("-1,2,-3"));
        String expectedMessage = "Negatives not allowed: -1, -3";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}

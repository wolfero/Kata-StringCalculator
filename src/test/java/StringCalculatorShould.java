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
        assertThat(stringCalculator.add(input)).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource({
            "'1,a',1"
    })
    void ignore_all_not_integer_numbers(String input, int output) {
        assertThat(stringCalculator.add(input)).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource({
            "'1,2',3",
            "'1,2,1',4"
    })
    void sum_the_numbers_separated_by_commas(String input, int output) {
        assertThat(stringCalculator.add(input)).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource({
            "'1\n2',3",
            "'1,2\n1',4"
    })
    void sum_the_numbers_separated_by_commas_and_new_lines(String input, int output) {
        assertThat(stringCalculator.add(input)).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource({
            "'//;\n1;2;3', 6"
    })
    void sum_the_numbers_separated_by_custom_delimiters(String input, int output) {
        assertThat(stringCalculator.add(input)).isEqualTo(output);
    }

    @Test
    void negative_number_not_allowed() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("-1,2,-3"));
        String expectedMessage = "Negatives not allowed: -1,-3";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @ParameterizedTest
    @CsvSource({
            "'100,1002,1', 101"
    })
    void ignore_sum_if_given_number_is_greater_than_thousand(String input, int output) {
        assertThat(stringCalculator.add(input)).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource({
            "'//[;;;]\n1;;;2;;;3', 6"
    })
    void sum_the_numbers_separated_by_custom_delimiters_with_any_length(String input, int output) {
        assertThat(stringCalculator.add(input)).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource({
            "'//[;][,]\n1;2,3', 6",
            "'//[-][%%]\n1-2%%3', 6"
    })
    void sum_the_numbers_separated_by_multiple_custom_delimiters_with_any_length(String input, int output) {
        assertThat(stringCalculator.add(input)).isEqualTo(output);
    }
}

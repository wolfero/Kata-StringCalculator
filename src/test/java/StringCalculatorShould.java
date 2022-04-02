import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void given_empty_return_not_sum(String input, int output) {
        int result = stringCalculator.add(input);

        assertThat(result).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'1'_ 1"
    }, delimiter = '_')
    void given_string_number_with_not_separator_return_same_element(String input, int output) {
        int result = stringCalculator.add(input);

        assertThat(result).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'1,2'_ 3"
    }, delimiter = '_')
    void given_elements_with_separator_return_sum_of_elements(String input, int output) {
        int result = stringCalculator.add(input);

        assertThat(result).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'1,a,2'_ 3"
    }, delimiter = '_')
    void given_numeric_and_not_numeric_elements_with_separator_return_sum_of_numeric_elements(String input, int output) {
        int result = stringCalculator.add(input);

        assertThat(result).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'1\n2,3'_ 6"
    }, delimiter = '_')
    void given_elements_with_separator_and_new_lines_return_sum_of_elements(String input, int output) {
        int result = stringCalculator.add(input);

        assertThat(result).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'//;\n1;2'_ 3"
    }, delimiter = '_')
    void given_elements_with_different_separator_and_new_lines_return_sum_of_elements(String input, int output) {
        int result = stringCalculator.add(input);

        assertThat(result).isEqualTo(output);
    }

    @Test
    void given_negative_elements_throw_exception() {
        assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("-1,2,3"));
    }
}
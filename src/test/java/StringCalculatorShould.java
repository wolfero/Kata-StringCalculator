import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorShould {
    private StringCalculator stringCalculator;
    /*TODO
     *   given "" return 0
     *   given "abc" return 0
     *   given "1" return 1
     *   given "1,2" return 3
     */

    @BeforeEach
    void init() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void given_empty_element_return_not_sum() {
        int result = stringCalculator.add("");

        assertThat(result).isEqualTo(0);
    }

    @Test
    void given_element_with_not_separator_return_same_element() {
        int result = stringCalculator.add("1");

        assertThat(result).isEqualTo(1);
    }

    @Test
    void given_elements_with_separator_return_sum_of_elements() {
        int result = stringCalculator.add("1,2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void given_numeric_and_not_numeric_elements_with_separator_return_sum_of_numeric_elements() {
        int result = stringCalculator.add("1,a,2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void given_elements_with_separator_and_new_lines_return_sum_of_elements() {
        int result = stringCalculator.add("1\n2,3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    void given_elements_with_different_separator_and_new_lines_return_sum_of_elements() {
        int result = stringCalculator.add("//;\n1;2");

        assertThat(result).isEqualTo(3);
    }
}
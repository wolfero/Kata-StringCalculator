import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorShould {
    @ParameterizedTest
    @CsvSource({
            "'',0"
    })
    void return_zero_if_given_empty_string(String input,int output){
        StringCalculator stringCalculator = new StringCalculator();

        int result=stringCalculator.add(input);

        assertThat(result).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource({
            "'a',0",
            "'1,a',1"
    })
    void ignore_all_not_integer_numbers(String input,int output){
        StringCalculator stringCalculator = new StringCalculator();

        int result=stringCalculator.add(input);

        assertThat(result).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource({
            "'1,2',3",
            "'1,2,1',3"
    })
    void sum_the_numbers_separated_by_commas(String input,int output){
        StringCalculator stringCalculator = new StringCalculator();

        int result=stringCalculator.add(input);

        assertThat(result).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource({
            "'1\n2',3",
            "'1,2\n1',3"
    })
    void sum_the_numbers_separated_by_commas_and_new_lines(String input,int output){
        StringCalculator stringCalculator = new StringCalculator();

        int result=stringCalculator.add(input);

        assertThat(result).isEqualTo(output);
    }
}

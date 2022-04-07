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
}

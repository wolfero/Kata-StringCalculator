import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorShould{
    /*TODO
     *   given "" return 0
     *   given "abc" return 0
     *   given "1" return 1
     *   given "1,2" return 3
     */

    @Test
    void given_empty_element_return_not_sum(){
        StringCalculator stringCalculator = new StringCalculator();

        int result=stringCalculator.sumElements("");

        assertThat(result).isEqualTo(0);
    }

}

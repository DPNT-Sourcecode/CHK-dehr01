package io.accelerate.solutions.CHK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSolutionTest_R5 {
    private CheckoutSolution checkout;

    @BeforeEach
    public void setUp() {
        checkout = new CheckoutSolution();
    }

    @ParameterizedTest
    @CsvSource({
            "'AAAB', 160",
            "'BBCCC', 105",
            "'BDBCCCD', 135",
            "'STX', 45",
            "'STXX', 62",
            "'XXXXXXT', 107",
            "'KK', 120",
            "'KKK', 190",
            "'KKKK', 240"
    })
    public void tests(String input, int expectedPrice) {
        assertThat(checkout.checkout(input), equalTo(expectedPrice));
    }

}


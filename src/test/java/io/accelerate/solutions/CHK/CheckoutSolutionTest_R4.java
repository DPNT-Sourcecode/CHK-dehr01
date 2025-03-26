package io.accelerate.solutions.CHK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSolutionTest_R4 {
    private CheckoutSolution checkout;

    @BeforeEach
    public void setUp() {
        checkout = new CheckoutSolution();
    }

    @ParameterizedTest
    @CsvSource({
            "'EEB', 80",
            "'EEEB', 120",
            "'EEEEBB', 160",
    })
    public void Btests(String input, int expectedPrice) {
        assertThat(checkout.checkout(input), equalTo(expectedPrice));
    }

}

package io.accelerate.solutions.CHK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSolutionTest {
    private CheckoutSolution checkout;

    @BeforeEach
    public void setUp() {
        checkout = new CheckoutSolution();
    }

    @ParameterizedTest
    @CsvSource({
        "'A', 50",
        "'a', -1",
        "'B', 30",
        "'AA', 100",
        "'AAA', 130",
        "'AAAB', 160",
        "'BBCCC', 105",
        "'BDBCCCD', 135",
        "'BBBB', 90"
    })
    public void checkoutTest(String input, int expectedPrice) {
        assertThat(checkout.checkout(input), equalTo(expectedPrice));
    }
}





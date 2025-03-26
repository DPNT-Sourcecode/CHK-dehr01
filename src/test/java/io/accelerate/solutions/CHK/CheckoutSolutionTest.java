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
            "'AA', 100",
            "'AAA', 130",
            "'AAAA', 180",
            "'AAAAA', 200",
            "'AAAAAA', 250",
            "'AAAAAAA', 300",
            "'AAAAAAAA', 330",
            "'AAAAAAAAA', 380",
            "'a', -1",
    })
    public void Atests(String input, int expectedPrice) {
        assertThat(checkout.checkout(input), equalTo(expectedPrice));
    }

    @ParameterizedTest
    @CsvSource({
            "'B', 30",
            "'BB', 45",
            "'BBBB', 90",
    })
    public void Btests(String input, int expectedPrice) {
        assertThat(checkout.checkout(input), equalTo(expectedPrice));
    }

    @ParameterizedTest
    @CsvSource({
            "'AAAB', 160",
            "'BBCCC', 105",
            "'BDBCCCD', 135",
    })
    public void combinedTests(String input, int expectedPrice) {
        assertThat(checkout.checkout(input), equalTo(expectedPrice));
    }

    @ParameterizedTest
    @CsvSource({
            "'F', 10",
            "'FF', 20", // offer requires 3 Fs in basket
            "'FFF', 20",
            "'FFFF', 30",
            "'FFFFF', 30",
            "'FFFFFF', 40",
    })
    public void Ftests(String input, int expectedPrice) {
        assertThat(checkout.checkout(input), equalTo(expectedPrice));
    }

    @ParameterizedTest
    @CsvSource({
            "'E', 40",
            "'EE', 80",
            "'EEE', 120",
            "'EB', 70",
            "'EEB', 80",
            "'EEBB', 110",
            "'EEBBB', 125",
            "'EEBBBB', 155",
    })
    public void Etests(String input, int expectedPrice) {
        assertThat(checkout.checkout(input), equalTo(expectedPrice));
    }
}






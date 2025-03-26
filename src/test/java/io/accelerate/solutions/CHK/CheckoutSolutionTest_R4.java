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
            "'EEB', 80", // 3Es so apply discount
            "'EEEB', 120",
            "'EEEEBB', 160",
            "'UUU', 120",
            "'FF', 20",
            "'FFFF', 30",
            "'UUUU', 120",
            "'UUUUU', 160",
            "'UUUUUUUU', 240",
            "'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 965",
            "'ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ', 1880",
            "'LGCKAQXFOSKZGIWHNRNDITVBUUEOZXPYAVFDEPTBMQLYJRSMJCWH', 1880"
    })
    public void tests(String input, int expectedPrice) {
        assertThat(checkout.checkout(input), equalTo(expectedPrice));
    }

}

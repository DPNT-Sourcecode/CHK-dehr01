package io.accelerate.solutions.CHK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSolutionTest {
    private CheckoutSolution checkout;

    @BeforeEach
    public void setUp() {
        checkout = new CheckoutSolution();
    }

    @Test
    public void checkoutTest() {
        assertThat(checkout.checkout("A"), equalTo(50));
        assertThat(checkout.checkout("AA"), equalTo(100));
        assertThat(checkout.checkout("AAA"), equalTo(130));
        assertThat(checkout.checkout("AAAB"), equalTo(160));
        assertThat(checkout.checkout("BBCCC"), equalTo(105));
    }
}


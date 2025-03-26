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
        assertThat(checkout.checkout("a"), equalTo(-1));
        assertThat(checkout.checkout("-"), equalTo(-1));
        assertThat(checkout.checkout("B"), equalTo(50));
        assertThat(checkout.checkout("AA"), equalTo(100));
        assertThat(checkout.checkout("AAA"), equalTo(130));
        assertThat(checkout.checkout("AAAB"), equalTo(160));
        assertThat(checkout.checkout("BBCCC"), equalTo(105));
        assertThat(checkout.checkout("BDBCCCD"), equalTo(135));
        assertThat(checkout.checkout("BBBB"), equalTo(90));
    }
}




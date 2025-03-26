package io.accelerate.solutions.HLO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HelloSolutionTest {
    private CheckoutSolution hello;

    @BeforeEach
    public void setUp() {
        hello = new CheckoutSolution();
    }

    @Test
    public void helloTest() {
        assertThat(hello.hello("kishan"), equalTo("Hello, kishan!"));
    }
}

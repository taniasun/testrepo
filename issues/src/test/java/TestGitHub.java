package test.java;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TestGitHub {

    @Test
    public void test() {
        assertThat(true).as("True is equal to false").isEqualTo(false);
    }
}

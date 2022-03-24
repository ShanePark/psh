package com.tistory.shanepark;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SToolTest {

    @Test
    void convertToStringArray() {
        Assertions.assertThat(STool.convertToStringArray("[[1,2],[3],[3],[]])")).isDeepEqualTo(new String[][]{{"1", "2"}, {"3"}, {"3"}, {}});
    }

    @Test
    void convertToIntArray() {
        Assertions.assertThat(STool.convertToIntArray("[[1,2],[3],[3],[]])")).isDeepEqualTo(new int[][]{{1, 2}, {3}, {3}, {}});
    }
}

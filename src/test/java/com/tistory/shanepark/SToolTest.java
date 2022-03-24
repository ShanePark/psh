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
        Assertions.assertThat(STool.convertToIntArray("[[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]")).isDeepEqualTo(new int[][]{{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}});
    }
}

package com.tistory.shanepark;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SToolTest {

    @Test
    void convertToIntArray() {
        int[][] arr = STool.convertToIntArray("[[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]");
        Assertions.assertThat(arr).isDeepEqualTo(new int[][]{{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}});
    }
}

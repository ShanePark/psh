package com.tistory.shanepark;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class SToolTest {

    @Test
    void convertToStringArray() {
        assertThat(STool.convertToStringArray("[[1,2],[3],[3],[]])")).isDeepEqualTo(new String[][]{{"1", "2"}, {"3"}, {"3"}, {}});
        String[][] arr = STool.convertToStringArray("[[\"London\",\"New York\"],[\"New York\",\"Lima\"],[\"Lima\",\"Sao Paulo\"]]");
        assertThat(arr).isDeepEqualTo(new String[][]{{"London", "New York"}, {"New York", "Lima"}, {"Lima", "Sao Paulo"}});
    }

    @Test
    void convertToIntArray() {
        assertThat(STool.convertToIntArray("[[1,2],[3],[3],[]])")).isDeepEqualTo(new int[][]{{1, 2}, {3}, {3}, {}});
        assertThat(STool.convertToIntArray("[[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]")).isDeepEqualTo(new int[][]{{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}});
        assertThat(STool.convertToIntArray("[[1,2],[3],[3],[]])")).isDeepEqualTo(new int[][]{{1, 2}, {3}, {3}, {}});
        assertThat(STool.convertToIntArray("[[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]")).isDeepEqualTo(new int[][]{{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}});
        assertThat(STool.convertToIntArray("[[1,1,0,0,0],\n" +
                " [1,1,1,1,0],\n" +
                " [1,0,0,0,0],\n" +
                " [1,1,0,0,0],\n" +
                " [1,1,1,1,1]]")).isDeepEqualTo(new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}});
    }

    @Test
    void convertToIntList() {
        assertThat(STool.convertToIntList("[[0,1],[0,2],[2,5],[3,4],[4,2]]"))
                .containsExactly(Arrays.asList(0, 1), Arrays.asList(0, 2), Arrays.asList(2, 5), Arrays.asList(3, 4), Arrays.asList(4, 2));
        assertThat(STool.convertToIntList("[[]]")).containsExactly(Collections.EMPTY_LIST);
    }

    @Test
    void convertToStringList() {
        assertThat(STool.convertToStringList("[[\"London\",\"New York\"],[\"New York\",\"Lima\"],[\"Lima\",\"Sao Paulo\"]]"))
                .containsExactly(Arrays.asList("London", "New York"), Arrays.asList("New York", "Lima"), Arrays.asList("Lima", "Sao Paulo"));
        assertThat(STool.convertToStringList("[[]]")).containsExactly(Collections.EMPTY_LIST);
    }

    @Test
    void stringToCharArr() {
        String str = "[\"X\",\".\",\".\",\"X\"]";
        char[] result = ReflectionTestUtils.invokeMethod(new STool(), "StringToCharArr", str);
        assertThat(result).containsExactly('X', '.', '.', 'X');

        char[] arr = ReflectionTestUtils.invokeMethod(new STool(), "StringToCharArr", "[]");
        assertThat(arr).containsExactly();
    }

    @Test
    public void convertToCharArray() {
        assertThat(STool.convertToCharArray("[[\"X\",\".\",\".\",\"X\"],[\".\",\".\",\".\",\"X\"],[\".\",\".\",\".\",\"X\"]]"))
                .isDeepEqualTo(new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}});
    }

}

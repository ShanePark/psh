package com.github.shanepark;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class PsTest {

    @Test
    void strArrayTest() {
        assertThat(Ps.strArray("[[\"rardss\", \"123\"], [\"yyoom\", \"1234\"], [\"meosseugi\", \"1234\"]]"))
                .isDeepEqualTo(new String[][]{{"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}});
        assertThat(Ps.strArray("[[1,2],[3],[3],[]])"))
                .isDeepEqualTo(new String[][]{{"1", "2"}, {"3"}, {"3"}, {}});
        assertThat(Ps.strArray("[[\"London\",\"New York\"],[\"New York\",\"Lima\"],[\"Lima\",\"Sao Paulo\"]]"))
                .isDeepEqualTo(new String[][]{{"London", "New York"}, {"New York", "Lima"}, {"Lima", "Sao Paulo"}});
    }

    @Test
    void intArrayTest() {
        assertThat(Ps.intArray("[[1,2],[3],[3],[]])")).isDeepEqualTo(new int[][]{{1, 2}, {3}, {3}, {}});
        assertThat(Ps.intArray("[[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]")).isDeepEqualTo(new int[][]{{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}});
        assertThat(Ps.intArray("[[1,2],[3],[3],[]])")).isDeepEqualTo(new int[][]{{1, 2}, {3}, {3}, {}});
        assertThat(Ps.intArray("[[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]")).isDeepEqualTo(new int[][]{{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}});
        assertThat(Ps.intArray("[[1,1,0,0,0],\n" +
                " [1,1,1,1,0],\n" +
                " [1,0,0,0,0],\n" +
                " [1,1,0,0,0],\n" +
                " [1,1,1,1,1]]")).isDeepEqualTo(new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}});
    }

    @Test
    public void charArrayTest() {
        assertThat(Ps.charArray("[\n" +
                "  [\"1\",\"1\",\"1\",\"1\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"1\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"0\",\"0\",\"0\"]\n" +
                "]")).isEqualTo(new char[][]{{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}});
        assertThat(Ps.charArray("[[\"X\",\".\",\".\",\"X\"],[\".\",\".\",\".\",\"X\"],[\".\",\".\",\".\",\"X\"]]"))
                .isDeepEqualTo(new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}});
    }

    @Test
    void intListTest() {
        assertThat(Ps.intList("[[0,1],[0,2],[2,5],[3,4],[4,2]]"))
                .containsExactly(Arrays.asList(0, 1), Arrays.asList(0, 2), Arrays.asList(2, 5), Arrays.asList(3, 4), Arrays.asList(4, 2));
        assertThat(Ps.intList("[[]]")).containsExactly(Collections.EMPTY_LIST);
    }

    @Test
    void strListTest() {
        assertThat(Ps.strList("[[\"London\",\"New York\"],[\"New York\",\"Lima\"],[\"Lima\",\"Sao Paulo\"]]"))
                .containsExactly(Arrays.asList("London", "New York"), Arrays.asList("New York", "Lima"), Arrays.asList("Lima", "Sao Paulo"));
        assertThat(Ps.strList("[[]]")).containsExactly(Collections.EMPTY_LIST);
    }

}

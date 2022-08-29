package com.tistory.shanepark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class STool {

    /**
     * convert [[1,2],[3,4]] style array into {{1,2},{3,4}}
     *
     * @param str
     * @return
     */
    public static String arrayConverter(String str) {
        return str.replaceAll("\\[", "{").replaceAll("\\]", "}");
    }

    public static String[][] convertToStringArray(String str) {
        List<String> list = deepStringToList(str);
        String[][] result = new String[list.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = StringToStringArr(list.get(i));
        }

        return result;
    }

    /**
     * @param str ex) [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
     * @return array of char
     */
    public static char[][] convertToCharArray(String str) {
        List<String> list = deepStringToList(str);
        char[][] result = new char[list.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = StringToCharArr(list.get(i));
        }

        return result;
    }

    public static int[][] convertToIntArray(String str) {
        List<String> list = deepStringToList(str);
        int[][] result = new int[list.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = StringToIntArr(list.get(i));
        }

        return result;
    }

    public static List<List<Integer>> convertToIntList(String str) {
        List<List<Integer>> list = new ArrayList<>();
        for (int[] ints : convertToIntArray(str)) {
            List<Integer> l = new ArrayList<>();
            for (int n : ints) {
                l.add(n);
            }
            list.add(l);
        }
        return list;
    }

    public static List<List<String>> convertToStringList(String str) {
        List<List<String>> list = new ArrayList<>();
        for (String[] strings : convertToStringArray(str)) {
            List<String> l = new ArrayList<>();
            for (String string : strings) {
                l.add(string);
            }
            list.add(l);
        }
        return list;
    }

    public static String[] StringToStringArr(String str) {
        if (str.length() == 2)
            return new String[]{};
        String[] arr = str.substring(1, str.length() - 1).split(",");
        if (str.contains("\"")) {
            for (int i = 0; i < arr.length; i++) {
                String e = arr[i];
                if (e.charAt(0) == '"' && e.charAt(e.length() - 1) == '"') {
                    arr[i] = e.substring(1, e.length() - 1);
                }
            }
        }
        return arr;
    }

    private static char[] StringToCharArr(String str) {
        String[] stringArr = StringToStringArr(str.trim());
        char[] answer = new char[stringArr.length];
        for (int i = 0; i < stringArr.length; i++) {
            answer[i] = stringArr[i].charAt(0);
        }
        return answer;
    }

    public static int[] StringToIntArr(String str) {
        str = str.replaceAll(" ", "");
        if (str.length() == 2)
            return new int[]{};

        String[] arr = str.substring(1, str.length() - 1).split(",");
        int[] intArr = new int[arr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }
        return intArr;
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void printArray(long[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void printArray(String[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void printArray(char[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void printArray(double[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void printArray(boolean[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void printArray(float[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void printDeepArray(Object[] o) {
        System.out.println(Arrays.deepToString(o));
    }

    /****************************************************************
     * private Methods
     */

    private static List<String> deepStringToList(String str) {
        String data = str.trim()
                .replaceAll("\\[", "{")
                .replaceAll("\\]", "}")
                .replaceAll("\n", "");
        data = data.substring(1, data.length() - 1);
        List<String> list = new ArrayList<>();
        int left = 0;
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (c == '}') {
                String arrStr = data.substring(left, i + 1);
                list.add(arrStr);
                left = (++i) + 1;
            }
        }
        return list;
    }

}

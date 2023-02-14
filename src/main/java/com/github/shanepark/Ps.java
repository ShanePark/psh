package com.github.shanepark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ps {

    public static String[][] strArray(String str) {
        List<String> list = deepStringToList(str);
        String[][] result = new String[list.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = StringToStringArr(list.get(i));
        }
        return result;
    }

    public static char[][] charArray(String str) {
        List<String> list = deepStringToList(str);
        char[][] result = new char[list.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = StringToCharArray(list.get(i));
        }
        return result;
    }

    public static int[][] intArray(String str) {
        List<String> list = deepStringToList(str);
        int[][] result = new int[list.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = StringToIntArray(list.get(i));
        }
        return result;
    }

    public static List<List<Integer>> intList(String str) {
        List<List<Integer>> list = new ArrayList<>();
        for (int[] ints : intArray(str)) {
            List<Integer> l = new ArrayList<>();
            for (int n : ints) {
                l.add(n);
            }
            list.add(l);
        }
        return list;
    }

    public static List<List<String>> strList(String str) {
        List<List<String>> list = new ArrayList<>();
        for (String[] strings : strArray(str)) {
            list.add(Arrays.asList(strings));
        }
        return list;
    }

    /****************************************************************
     * private Methods
     */

    private static String[] StringToStringArr(String str) {
        str = str.trim();
        if (str.length() == 2)
            return new String[]{};
        String[] arr = str.substring(1, str.length() - 1).split(",");
        if (str.contains("\"")) {
            for (int i = 0; i < arr.length; i++) {
                String e = arr[i].trim();
                if (e.charAt(0) == '"' && e.charAt(e.length() - 1) == '"') {
                    arr[i] = e.substring(1, e.length() - 1);
                }
            }
        }
        return arr;
    }

    private static char[] StringToCharArray(String str) {
        String[] stringArr = StringToStringArr(str.trim());
        char[] answer = new char[stringArr.length];
        for (int i = 0; i < stringArr.length; i++) {
            answer[i] = stringArr[i].charAt(0);
        }
        return answer;
    }

    private static int[] StringToIntArray(String str) {
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

    private static List<String> deepStringToList(String str) {
        String data = str.trim()
                .replaceAll("\\[", "{")
                .replaceAll("]", "}")
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

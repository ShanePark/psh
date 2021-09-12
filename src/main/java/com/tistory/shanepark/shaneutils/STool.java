package com.tistory.shanepark.shaneutils;

public class STool {

    /**
     * convert [[1,2],[3,4]] style array into {{1,2},{3,4}}
     *
     * @param str
     * @return
     */
    private static String arrayConverter(String str) {
        return str.replaceAll("\\[", "{").replaceAll("\\]", "}");
    }

}

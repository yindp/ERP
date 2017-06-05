package com.yinom.pdd.erp.util;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

/**
 * Created by yindp on 5/31/17.
 */
public class DistinguishContent {

    public static String distinguish(String args) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        boolean isNumeric = pattern.matcher(args).matches();
        if (isNumeric == true) {
            return "numeric";
        }
        for (int i = 0; i < args.length(); i++) {
            char c = args.charAt(i);
            if (c >= 19968 && c <= 171941) {
                return "chinese";
            }
        }
        if (args.matches("^[a-zA-Z]*")) {
            return "english";
        }
        return "other";
    }

    @Test
    public void tet() {
        String test = "asdasd12312f";
        String result = distinguish(test);
        System.out.println(result);
    }
}

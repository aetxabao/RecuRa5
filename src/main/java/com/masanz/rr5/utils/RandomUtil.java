package com.masanz.rr5.utils;

public class RandomUtil {

    public static String texto(int longitud) {
        String base = "1234567890QWERTYUIOPASDFGHJKLZXCVBNM";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            int x = (int)(Math.random() * base.length());
            sb.append(base.charAt(x));
        }
        return sb.toString();
    }

}

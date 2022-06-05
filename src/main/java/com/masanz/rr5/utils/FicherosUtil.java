package com.masanz.rr5.utils;

import java.io.File;

public class FicherosUtil {

    public static boolean existe(String path) {
        File fichero = new File(path);
        if (fichero.exists()) {
            return true;
        }
        return false;
    }

}

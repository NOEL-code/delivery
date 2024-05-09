package org.example.store.utils;

import java.util.regex.Pattern;

public class Utils {

     public boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    public boolean isString(String str) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        return pattern.matcher(str).matches();
    }

}

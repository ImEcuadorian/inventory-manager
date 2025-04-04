package io.github.imecuadorian.manager.util;

public class Validate {


    public static boolean isValidateInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

package com.FieldValidator;

public class FieldValidator {

    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean isNullOrEmptyString(String... strArr) {
        for (String st : strArr) {
            if (st == null || st.equals(""))
                return true;
        }
        return false;
    }

    public static boolean isPositiveInteger(int number) {
        return number > 0;
    }

}

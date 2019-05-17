package com.FieldValidator;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    public static boolean StringIsInteger(String s) {
        return s.matches("[-+]?[0-9]+");
    }

    public static boolean StringIsDouble(String s) {
        return s.matches("[-+]?([0-9]+\\.([0-9]+)?|\\.[0-9]+)");
    }

    public static boolean isThisDateValid(String StringDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(StringDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
}

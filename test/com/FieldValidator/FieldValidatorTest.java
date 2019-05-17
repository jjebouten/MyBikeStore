package com.FieldValidator;

import org.junit.jupiter.api.Test;

import static com.FieldValidator.FieldValidator.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FieldValidatorTest {

    @Test
    void testIsValidEmailAddress() {
        String correctEmail = "correct@email.nl";
        assertTrue(isValidEmailAddress(correctEmail));
    }

    @Test
    void testIsInvalidEmailAddress() {
        String falseEmail = "IAmNoEmailAddress";
        assertFalse(isValidEmailAddress(falseEmail));
    }

    @Test
    void testIsNullOrEmptyStringWithEmptyString() {
        String emptyStringField = "";
        assertTrue(isNullOrEmptyString(emptyStringField));
    }

    @Test
    void testiIsNullOrEmptyStringWithNonEmptyString() {
        String filledStringField = "I contain text";
        assertFalse(isNullOrEmptyString(filledStringField));
    }

    @Test
    void testPositiveInteger() {
        int positiveInteger = 1;
        assertTrue(isPositiveInteger(positiveInteger));
    }

    @Test
    void testFalseInteger() {
        int negativeInteger = -1;
        assertFalse(isPositiveInteger(negativeInteger));
    }
}
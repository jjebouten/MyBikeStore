package com.BikeStore.Data.Modal;


import org.junit.jupiter.api.Test;

import static com.FieldValidator.FieldValidator.isPositiveInteger;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerTest {
    private Customer customer;

    @Test
    public void customerSpongebobHasPositiveCustomerId() {
        customer = new Customer(-1, "Sponge", "Bob", "Pineapple street 1", "BikiniBottom", "Spongebob@nickelodeon.nl");
        assertFalse(isPositiveInteger(customer.getCustomerId()));
    }

    @Test
    public void customerSpongebobIsIValid() {
        customer = new Customer(1, "Sponge", "Bob", "", "BikiniBottom", "Spongebobnickelodeon.nl");
        assertTrue(isPositiveInteger(customer.getCustomerId()));
    }
}
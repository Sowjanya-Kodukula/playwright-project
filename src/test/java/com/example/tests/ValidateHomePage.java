package com.example.tests;

import com.example.utils.actions.ValidateHomePageAction;

import org.junit.jupiter.api.Test;

public class ValidateHomePage {
    @Test
    public void validateHomePage() {
            try(ValidateHomePageAction a = new ValidateHomePageAction()){
                a.validateHomePageAction();
            }
    }
}

package com.auto.steps;

import cucumber.api.java8.En;

public class MyStepdefs implements En {

    public MyStepdefs() {
        Given("^I print something \"([^\"]*)\"$", (String arg0) -> {
            System.out.println(arg0);
        });
    }
}

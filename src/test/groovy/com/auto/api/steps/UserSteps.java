package com.auto.api.steps;

import com.auto.api.entities.UserAPI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class UserSteps implements En {
    private final static Logger logger = LogManager.getLogger(UserSteps.class);

    public UserSteps() {
        When("^I create a new user$", (DataTable table) -> {
            List<UserAPI> userAPIList = table.asList(UserAPI.class);
            userAPIList.forEach(System.out::println);
        });
    }
}

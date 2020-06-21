package com.auto.hooks;

import static java.util.Locale.ENGLISH;


import com.auto.api.entities.projects.AllProjectResponse;
import com.auto.api.entities.projects.ProjectRequest;
import com.auto.api.entities.projects.ProjectResponse;
import com.auto.api.entities.user.UserRequest;
import com.auto.api.entities.user.UserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import java.util.Locale;


/**
 * To configure all the class for which Cucumber can convert DataTable to Java objects.
 */
public class TypeRegistryConfig implements TypeRegistryConfigurer {

    private static ObjectMapper mapper;

    static {
        TypeRegistryConfig.mapper = new ObjectMapper();
    }

    @Override
    public Locale locale() {
        return ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(DataTableType.entry(UserRequest.class));
        typeRegistry.defineDataTableType(DataTableType.entry(UserResponse.class));
        typeRegistry.defineDataTableType(DataTableType.entry(ProjectResponse.class));
        typeRegistry.defineDataTableType(DataTableType.entry(ProjectRequest.class));
        typeRegistry.defineDataTableType(DataTableType.entry(AllProjectResponse.class));
        // add another ...
    }
}

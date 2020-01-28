package com.auto.utils.files

import com.auto.entities.EnvInfo
import com.auto.utils.Constants

class YamlFileTest extends GroovyTestCase {


    void testLoadYamlFileAsObject() {
        // Given
        final String path = Constants.ENV_INFO_PATH
        final Class<?> aClass = EnvInfo.class

        // When
        YamlFile reader = new YamlFile()
        Object envInfo =  reader.loadYamlFileAsObject(aClass, path)

        // Then
        assertEquals("The output is not the same class", aClass, envInfo.getClass())

    }
}

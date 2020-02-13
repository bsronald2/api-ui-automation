package com.auto.utils.files

import com.auto.entities.EnvInfo
import com.auto.utils.Constants
import org.junit.Before

class YamlFileTest extends GroovyTestCase {

    private String path
    private Class<?> aClass
    private YamlFile reader


    @Before
    void setUp() {
        // Given
        path = Constants.ENV_INFO_PATH
        aClass = EnvInfo.class

        // When
        reader = new YamlFile()
    }

    void testLoadYamlFileAsObject() {

        // When
        Object envInfo =  reader.loadYamlFileAsObject(aClass, path)

        // Then
        assertEquals("The output is not the same class", aClass, envInfo.getClass())
    }
}

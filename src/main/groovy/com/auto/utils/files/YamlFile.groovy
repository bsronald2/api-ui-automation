package com.auto.utils.files


import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor

class YamlFile {

    private final static Logger LOGGER = LogManager.getLogger(YamlFile.class);

    /**
     * This method load an YAML file as Java Object.
     *
     * @param aClass type of Class
     * @param path of the YAML file
     * @return an Object
     * @throw IllegalArgumentException if the path String is NULL or Empty
     */
    public Object loadYamlFileAsObject(Class<?> aClass, String path) {

        if (!path) {
            throw IllegalArgumentException("File path must not be NULL or empty: {}", path)
        }
        // Map Yaml file to Java Object
        Yaml yaml = new Yaml(new Constructor(aClass))
        InputStream inputStream = new FileInputStream(new File(path))
        Object object =  yaml.loadAs(inputStream, aClass)
        LOGGER.info("Class Loaded: {}", aClass as String)

        return object
    }
}

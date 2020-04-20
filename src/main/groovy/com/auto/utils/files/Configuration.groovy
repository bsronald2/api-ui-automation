package com.auto.utils.files

import com.auto.utils.Constants

/**
 * Read Environment Configuration.
 */
class Configuration {


    private static final Properties properties;

    // use static initializer to read the configuration file when the class is loaded
    static {
        properties = new Properties()
        println "I am here..."
        try {
            FileInputStream inputStream = new FileInputStream(Constants.CONFIG_PROP_PATH)
            properties.load(inputStream)
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file " + Constants.CONFIG_PROP_PATH, e);
        }
    }

    /**
     * Retrieve environment configuration properties.
     *
     * @return file as unmodifiable Map
     */
    public static Map<String, String> getConfiguration() {
        // ugly workaround to get String as generics
        Map temp = properties;
        Map<String, String> map = new HashMap<String, String>(temp);
        // prevent the returned configuration from being modified
        return Collections.unmodifiableMap(map);
    }

    /**
     * Get property value.
     *
     * @param key
     * @return
     */
    public static String getConfigurationValue(String key) {
        return properties.getProperty(key);
    }

    // private constructor to prevent initialization
    private Configuration() {
    }
}

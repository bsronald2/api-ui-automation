package com.auto.utils.files

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class PropertyFileReader {
    private final static Logger logger = LogManager.getLogger(PropertyFileReader.class);

    private Properties prop
    private InputStream input
    private OutputStream output
    private String propPath

    public PropertyReader(String propPath) {
        this.propPath = propPath
        this.prop = new Properties()
        this.input = null
        this.output = null

        logger.debug("Initialize the PropertyReader instance.")
    }

    /**
     * This method read the parameter value from a config file and return it.
     * @param parameter value
     * @return a string with the value
     */
    public String getPropertyValue(String parameter) {
        String returnValue = ""
        try {
            this.input = new FileInputStream(this.propPath)
            this.prop.load(input)

            // Read "parameter" property value
            returnValue = this.prop.getProperty(parameter)

        } catch (IOException exception) {
            logger.error("Error to open file " + exception)
        } catch (MissingPropertyException propertyException){
            logger.error("Error to get the property '${parameter}' ${propertyException}")
        }
        finally {
            if (this.input != null) {
                try {
                    this.input.close()
                } catch (IOException exception) {
                    logger.error("Not able to close property file " + exception)
                }
            }
        }
        return returnValue
    }

    /**
     * This method Write on property file
     * @param parameter the name of the parameter
     * @param value the value of the parameter
     */
    public void setPropertyValue(String parameter, String value) {

        try {
            // save the currently properties values
            this.input = new FileInputStream(this.propPath)
            this.prop.load(input)
            this.input.close()

            this.output = new FileOutputStream(this.propPath)

            // set the property value
            prop.setProperty(parameter, value)

            // save properties to project root folder
            prop.store(output, null)

            logger.debug("The property ${parameter} = ${value} has been saved.")

        } catch (IOException io) {
            LOG.error("Error to open file" + io)
            io.printStackTrace()
        } finally {
            if (output != null) {
                try {
                    output.close()
                } catch (IOException exception) {
                    logger.error("Not able to close property file " + exception)
                }
            }
        }
    }
}

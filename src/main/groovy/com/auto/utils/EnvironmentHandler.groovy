package com.auto.utils
import com.auto.utils.files.YamlFile

public class EnvironmentHandler {

    private EnvInfo envInfo

    public EnvironmentHandler(String filePath) {
        loadFile(filePath)
    }

    public void loadFile(String filePath) {
        YamlFile reader = new YamlFile()

        try {
            envInfo = (EnvInfo) reader.loadYamlFileAsObject(EnvInfo.class, filePath)
            envInfo.loadInitParams()
        } catch (ignored) {
            throw new Exception("It was not able to load environment information")
        }
    }

    public EnvInfo getEnvInfo() {
        return envInfo
    }
}

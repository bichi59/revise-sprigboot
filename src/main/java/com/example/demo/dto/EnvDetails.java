package com.example.demo.dto;

public class EnvDetails {

    String envName;
    String version;

    public EnvDetails(String envName, String version) {
        this.envName = envName;
        this.version = version;
    }

    public String getEnvName() {
        return envName;
    }

    public String getVersion() {
        return version;
    }

    public void setEnvName(String envName) {
        this.envName = envName;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

package com.wimix.test.commons.config;

import org.apache.commons.configuration2.Configuration;

public class ZegoalConfig {

    private static ZegoalConfig instance;
    private final Configuration configuration;

    public ZegoalConfig() {
        String env = System.getProperty("zegoal.env");
        if (env == null) {
            env = "dev";
        }
        configuration = new ConfigurationBuilder()
                .withEnvironmentProperties()
                .withSystemProperties()
                .withClassPathProperties("/" + env + "-config.properties")
                .build();
    }

    private static ZegoalConfig getInstance() {
        if (instance == null) {
            instance = new ZegoalConfig();
        }
        return instance;
    }

    public static String getString(String key) {
        return getInstance().configuration.getString(key);
    }

    public static String getBaseUrl() {
        return getInstance().configuration.getString("zegoal.url");
    }

    public static String getClientIdAndroid() {
        return getInstance().configuration.getString("zegoal.clientIdAndroid");
    }

    public static String getClientIdWeb() {
        return getInstance().configuration.getString("zegoal.clientIdWeb");
    }

    public static String getClientSecretAndroid() {
        return getInstance().configuration.getString("zegoal.clientSecretAndroid");
    }

    public static String getClientSecretWeb() {
        return getInstance().configuration.getString("zegoal.clientSecretWeb");
    }

    public static String getUser() {
        return getInstance().configuration.getString("zegoal.user");
    }

    public static String getPassword() {
        return getInstance().configuration.getString("zegoal.password");
    }

    public static String getEmail() {
        return getInstance().configuration.getString("zegoal.testEmail");
    }

    public static String getAppPassword() {
        return getInstance().configuration.getString("zegoal.appEmailPassword");
    }

    public static String getOrganizationName() {
        return getInstance().configuration.getString("zegoal.organizationName");
    }
}
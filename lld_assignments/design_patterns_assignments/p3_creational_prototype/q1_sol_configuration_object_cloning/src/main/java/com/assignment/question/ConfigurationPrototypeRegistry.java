package com.assignment.question;

public interface ConfigurationPrototypeRegistry {

    void addPrototype(Configuration configuration);

    Configuration getPrototype(ConfigurationType type);

    Configuration clone(ConfigurationType type);
}
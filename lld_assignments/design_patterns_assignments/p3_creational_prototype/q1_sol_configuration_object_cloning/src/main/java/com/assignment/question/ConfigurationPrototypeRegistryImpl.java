package com.assignment.question;

import java.util.*;

// The ConfigurationPrototypeRegistryImpl class implements the ConfigurationPrototypeRegistry interface
public class ConfigurationPrototypeRegistryImpl implements ConfigurationPrototypeRegistry {

    private Map<ConfigurationType, Configuration> configurationTypeToConfigurationMap = new HashMap<>();

    public void addPrototype(Configuration configuration) {
        configurationTypeToConfigurationMap.put(configuration.getType(), configuration);
    }

    public Configuration getPrototype(ConfigurationType type) {
        return configurationTypeToConfigurationMap.get(type);
    }

    public Configuration clone(ConfigurationType type) {
        return configurationTypeToConfigurationMap.get(type).cloneObject();
    }
}

/*

    In this code, the Configuration class implements the ClonableObject interface,
    which has a cloneObject method. This method is used to create a copy of the Configuration object.

    The ConfigurationPrototypeRegistryImpl class implements the ConfigurationPrototypeRegistry interface,
    which has methods to add a prototype, get a prototype, and clone a prototype.
    The ConfigurationPrototypeRegistryImpl class maintains a registry of configuration prototypes,
    and clones are created from these prototypes as needed.

    This is a classic implementation of the Prototype Pattern.
    The Prototype Pattern can be very useful when object creation is costly,
    and you want to avoid the cost of initializing an object,
    especially when the client system needs to be unaware of this initialization.

    It also provides a mechanism to keep track of objects that have already been created.
    In this case, the Configuration objects are being tracked.
    This pattern is particularly useful when you want to maintain a state in your application.
    It allows you to avoid using the new keyword. Instead, you can clone a pre-initialized object.
    This can be a significant performance boost in some scenarios.
 */
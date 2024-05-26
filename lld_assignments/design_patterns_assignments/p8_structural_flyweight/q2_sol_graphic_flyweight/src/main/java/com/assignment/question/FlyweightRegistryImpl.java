package com.assignment.question;

import java.util.HashMap;
import java.util.Map;

// The FlyweightRegistryImpl class is the flyweight factory that creates and manages flyweight objects.
public class FlyweightRegistryImpl implements FlyweightRegistry {
    private Map<GraphicType, GraphicIntrinsicState> registry = new HashMap<>(); // The registry for storing flyweight objects

    // The addFlyweight method adds a flyweight object to the registry.
    @Override
    public void addFlyweight(GraphicIntrinsicState flyweight) {
        registry.put(flyweight.getType(), flyweight);
    }

    // The getFlyweight method retrieves a flyweight object from the registry.
    @Override
    public GraphicIntrinsicState getFlyweight(GraphicType graphicType) {
        return registry.get(graphicType);
    }
}

/*
    In this code, the GraphicIntrinsicState class represents the intrinsic state of a graphic.
    These are states that can be shared among different contexts.
    The GraphicExtrinsicState class represents the extrinsic state of a graphic.
    These are states that vary and cannot be shared.
    The FlyweightRegistryImpl class is the flyweight factory that creates and manages flyweight objects.
    It maintains a registry of flyweight objects and provides methods for adding and retrieving flyweight objects.
    The FlyweightRegistry interface defines the operations for managing flyweight objects.

    This is a classic implementation of the Flyweight Pattern.
    It is a structural design pattern that provides a way to use objects in large numbers when a simple
    repeated representation would use an unacceptable amount of memory.
 */
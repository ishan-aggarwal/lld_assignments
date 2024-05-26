package com.assignment.question;

// The FlyweightRegistry interface defines operations that all concrete flyweight registries must implement.
public interface FlyweightRegistry {

    void addFlyweight(GraphicIntrinsicState flyweight); // Adds a flyweight object

    GraphicIntrinsicState getFlyweight(GraphicType graphicType); // Retrieves a flyweight object
}

package com.assignment.question;

// The FlyweightRegistry interface defines the operations for managing flyweight objects.
public interface FlyweightRegistry {

    void addFlyweight(UserIntrinsicState flyweight); // Adds a flyweight object

    UserIntrinsicState getFlyweight(String email); // Retrieves a flyweight object
}

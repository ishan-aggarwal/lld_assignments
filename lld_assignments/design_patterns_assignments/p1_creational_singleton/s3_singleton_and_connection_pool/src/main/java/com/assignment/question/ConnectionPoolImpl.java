package com.assignment.question;

import java.util.*;

public class ConnectionPoolImpl implements ConnectionPool {

    // Singleton instance
    private static volatile ConnectionPoolImpl connectionPool = null;
    private final int maxConnections; // Maximum number of connections allowed in the pool
    private final Queue<DatabaseConnection> dbQueue; // Queue to hold available connections

    // Private constructor to prevent instantiation from outside
    private ConnectionPoolImpl(int maxConnections) {
        this.maxConnections = maxConnections;
        this.dbQueue = new LinkedList<>();
        initializePool(); // Initialize the pool when an instance is created
    }

    // Method to get the singleton instance of ConnectionPoolImpl
    public static ConnectionPoolImpl getInstance(int maxConnections) {
        if (connectionPool == null) {
            synchronized (ConnectionPoolImpl.class) {
                if (connectionPool == null) {
                    connectionPool = new ConnectionPoolImpl(maxConnections);
                }
            }
        }
        return connectionPool;
    }

    // Method to reset the singleton instance (for testing purposes)
    public static void resetInstance() {
        connectionPool = null;
    }

    // Method to initialize the connection pool
    @Override
    public void initializePool() {
        for (int i = 0; i < maxConnections; i++) {
            dbQueue.add(new DatabaseConnection()); // Add new DatabaseConnection objects to the pool
        }
    }

    // Method to get a connection from the pool
    @Override
    public DatabaseConnection getConnection() {
        return dbQueue.poll(); // Retrieve and remove the head of the queue (first-in-first-out)
    }

    // Method to release a connection back to the pool
    @Override
    public void releaseConnection(DatabaseConnection connection) {
        dbQueue.add(connection); // Add the connection back to the end of the queue
    }

    // Method to get the count of available connections in the pool
    @Override
    public int getAvailableConnectionsCount() {
        return dbQueue.size(); // Get the size of the queue
    }

    // Method to get the total number of connections allowed in the pool
    @Override
    public int getTotalConnectionsCount() {
        return this.maxConnections; // Return the maximum number of connections
    }
}
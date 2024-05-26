package com.assignment.question;

import java.util.*;

public class ConnectionPoolImpl implements ConnectionPool {

    private static volatile ConnectionPool instance;
    private final Map<DatabaseConnection, Boolean> databaseConnectionInUseStatusMap;
    private final int maxConnections;
    private int availableConnections;

    private ConnectionPoolImpl(int maxConnections) {
        this.availableConnections = maxConnections;
        this.maxConnections = maxConnections;
        databaseConnectionInUseStatusMap = new HashMap<>();
        initializePool();
    }

    public static ConnectionPool getInstance(int maxCon) {
        if (instance == null) {
            synchronized (ConnectionPoolImpl.class) {
                if (instance == null) {
                    instance = new ConnectionPoolImpl(maxCon);
                }
            }
        }
        return instance;
    }

    public static void resetInstance() {
        instance = null;
    }

    @Override
    public void initializePool() {
        for (int i = 0; i < maxConnections; i++) {
            databaseConnectionInUseStatusMap.put(new DatabaseConnection(), false);
        }
    }

    @Override
    public DatabaseConnection getConnection() {
        for (DatabaseConnection e : databaseConnectionInUseStatusMap.keySet()) {
            if (!databaseConnectionInUseStatusMap.get(e)) {
                databaseConnectionInUseStatusMap.put(e, true);
                availableConnections -= 1;
                return e;
            }
        }
        return null;
    }

    @Override
    public void releaseConnection(DatabaseConnection connection) {
        this.availableConnections += 1;
        databaseConnectionInUseStatusMap.put(connection, false);
        // T -> connection in use || F -> connection is not in use
    }

    @Override
    public int getAvailableConnectionsCount() {
        return this.availableConnections;
    }

    @Override
    public int getTotalConnectionsCount() {
        return this.maxConnections;
    }
}
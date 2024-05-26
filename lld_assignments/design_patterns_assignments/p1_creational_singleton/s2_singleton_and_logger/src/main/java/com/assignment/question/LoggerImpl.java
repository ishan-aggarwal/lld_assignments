package com.assignment.question;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class LoggerImpl implements Logger {
    private static LoggerImpl instance;
    private PrintWriter printWriter;
    private String filePath;

    private LoggerImpl() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (LoggerImpl.class) {
                if (instance == null) {
                    instance = new LoggerImpl();
                }
            }
        }
        return instance;
    }

    public static void resetInstance() {
        instance = null;
    }

    @Override
    public void log(int level, String message) {
        if (printWriter == null) {
            throw new IllegalStateException("printWriter is not initialized yet");
        }
        String logMessage = "DateTime: " + LocalDateTime.now() + ", Level: " + level + ", Message: " + message;
        printWriter.println(logMessage);

    }

    @Override
    public void setLogFile(String filePath) {
        this.filePath = filePath;
        try {
            printWriter = new PrintWriter(new FileWriter(filePath));
        } catch (IOException ex) {
            System.out.println("Exception while setting up printWriter");
        }
    }

    @Override
    public String getLogFile() {
        return filePath;
    }

    @Override
    public void flush() {
        if (printWriter == null) {
            return;
        }
        printWriter.flush();
    }

    @Override
    public void close() {
        if (printWriter == null) {
            return;
        }
        printWriter.close();
        printWriter = null;
    }

}


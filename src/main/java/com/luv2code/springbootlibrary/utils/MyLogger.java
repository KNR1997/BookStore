package com.luv2code.springbootlibrary.utils;

import java.util.logging.Level;

public class MyLogger {
    private static MyLogger instance;
    private java.util.logging.Logger logger;

    private MyLogger() {
        logger = java.util.logging.Logger.getLogger(MyLogger.class.getName());
    }

    public static synchronized MyLogger getInstance() {
        if (instance == null) {
            instance = new MyLogger();
        }
        return instance;
    }

    public void log(String message) {
        logger.info(message);
    }

    public void log(String message, Exception e) {
        logger.log(Level.SEVERE, message, e);
    }
}

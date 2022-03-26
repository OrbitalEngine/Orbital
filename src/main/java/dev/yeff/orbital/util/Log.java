package dev.yeff.orbital.util;

import org.slf4j.LoggerFactory;


/**
 * Utility class to create logging messages, meant to be used by both game and engine.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class Log {
    // Disable constructor
    private Log() { }

    /**
     * Logs a message with the info level.
     *
     *
     * @param klass The class the log is coming from.
     * @param message The message to log.
     */
    public static <T> void info(Class<T> klass, Object message) {
        LoggerFactory.getLogger(klass).info(message.toString());
    }

    /**
     * Logs a message with the debug level.
     *
     * @param klass The class the log is coming from.
     * @param message The message to log.
     */
    public static <T> void debug(Class<T> klass, Object message) {
        LoggerFactory.getLogger(klass).debug(message.toString());
    }

    /**
     * Logs a warning message.
     *
     * @param klass The class the warning is coming from.
     * @param message The warning message.
     */
    public static <T> void warn(Class<T> klass, Object message) {
        LoggerFactory.getLogger(klass).debug(message.toString());
    }

    /**
     * Logs an error, with an exception.
     *
     * @param klass The class the error is coming from
     * @param message The error message.
     * @param exception The exception that occured.
     */
    public static <T> void error(Class<T> klass, Object message, Exception exception) {
        LoggerFactory.getLogger(klass).error(message.toString(), exception);
    }
}
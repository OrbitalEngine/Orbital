package dev.yeff.orbital.util;

import org.slf4j.LoggerFactory;

public class Log {
    public static <T> void info(Class<T> klass, Object message) {
        LoggerFactory.getLogger(klass).info(message.toString());
    }

    public static <T> void debug(Class<T> klass, Object message) {
        LoggerFactory.getLogger(klass).debug(message.toString());
    }

    public static <T> void warn(Class<T> klass, Object message) {
        LoggerFactory.getLogger(klass).debug(message.toString());
    }

    public static <T> void error(Class<T> klass, Object message, Exception exception) {
        LoggerFactory.getLogger(klass).error(message.toString(), exception);
    }
}
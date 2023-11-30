package org.slf4j.helpers;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.event.Level;

public class NOPLogger extends LegacyAbstractLogger implements Logger {

    private static final long serialVersionUID = -517220405410904473L;

    /**
     * The unique instance of NOPLogger.
     */
    public static final NOPLogger NOP_LOGGER = new NOPLogger();

    /**
     * There is no point in creating multiple instances of NOPLogger.
     * <p>
     * The present constructor should be "private" but we are leaving it as "protected" for compatibility.
     */
    protected NOPLogger() {
    }

    private static final String LEVEL_KEY = "slf4j.internal.verbosity";

    private static final boolean _TRACE;
    private static final boolean _DEBUG;
    private static final boolean _INFO;
    private static final boolean _WARN;
    private static final boolean _ERROR;

    static {
        var level = System.getProperty(LEVEL_KEY);

        var TRACE = false;
        var DEBUG = false;
        var INFO = true;
        var WARN = true;
        var ERROR = true;

        if (level != null) {
            INFO = false;
            WARN = false;
            ERROR = false;

            switch (level.toUpperCase()) {
                case "TRACE":
                    TRACE = true;
                case "DEBUG":
                    DEBUG = true;
                case "INFO":
                    INFO = true;
                case "WARN":
                    WARN = true;
                case "ERROR":
                    ERROR = true;
            }
        }

        _TRACE = TRACE;
        _DEBUG = DEBUG;
        _INFO = INFO;
        _WARN = WARN;
        _ERROR = ERROR;
    }

    @Override
    public boolean isTraceEnabled() {
        return _TRACE;
    }

    @Override
    public boolean isDebugEnabled() {
        return _DEBUG;
    }

    @Override
    public boolean isInfoEnabled() {
        return _INFO;
    }

    @Override
    public boolean isWarnEnabled() {
        return _WARN;
    }

    @Override
    public boolean isErrorEnabled() {
        return _ERROR;
    }

    @Override
    protected String getFullyQualifiedCallerName() {
        return null;
    }

    @Override
    protected void handleNormalizedLoggingCall(Level level, Marker marker, String messagePattern, Object[] arguments, Throwable throwable) {
        var formattedMessage = MessageFormatter.basicArrayFormat(messagePattern, arguments);
        System.out.println(formattedMessage);
    }
}

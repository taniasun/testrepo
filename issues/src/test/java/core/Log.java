package test.java.core;

import java.util.logging.Logger;

public class Log {

    public static void info(String info) {
        final Logger log = Logger.getLogger(Log.class.getName());
        log.info(info);
    }
}

package logger;

import java.util.logging.Logger;
import theme2jvm.task3.Main;

public abstract class AbstractLogger {
    protected static Logger LOGGER;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-4s] %5$s %n");
        LOGGER = Logger.getLogger(Main.class.getName());
    }
}

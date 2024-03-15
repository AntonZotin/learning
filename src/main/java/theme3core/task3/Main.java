package theme3core.task3;

import logger.AbstractLogger;

public class Main extends AbstractLogger {
    public static void main(String[] args) {
        String literal1 = "Test text";
        String literal2 = "Test text";
        boolean literEq1 = literal1 == literal2;
        boolean literEq2 = literal1.equals(literal2);
        LOGGER.info("Literals with == " + literEq1);
        LOGGER.info("Literals with equals " + literEq2);
        String string1 = new String("Test text");
        String string2 = new String("Test text");
        boolean strEq1 = string1 == string2;
        boolean strEq2 = string1.equals(string2);
        LOGGER.info("Strings with == " + strEq1);
        LOGGER.info("Strings with equals " + strEq2);
    }
}

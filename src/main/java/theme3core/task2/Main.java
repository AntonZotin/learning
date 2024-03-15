package theme3core.task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import logger.AbstractLogger;

public class Main extends AbstractLogger {
    public static String getFile() throws IOException {
        File file = new File("unknown.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        return br.readLine();
    }

    public static int division(int first, int second) {
        return first / second;
    }

    public static void main(String[] args) {
        try {
            String text = getFile();
            LOGGER.info(text);
        } catch (IOException e) {
            LOGGER.warning(e.getMessage());
        }
        try {
            int result = division(1, 0);
            LOGGER.info(String.valueOf(result));
        } catch (ArithmeticException e) {
            LOGGER.warning(e.getMessage());
        }
    }
}

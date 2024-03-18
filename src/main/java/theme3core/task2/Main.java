package theme3core.task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
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
            System.out.println(text);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            int result = division(1, 0);
            System.out.println(String.valueOf(result));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}

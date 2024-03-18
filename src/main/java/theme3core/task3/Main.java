package theme3core.task3;

public class Main {
    public static void main(String[] args) {
        String literal1 = "Test text";
        String literal2 = "Test text";
        boolean literEq1 = literal1 == literal2;
        boolean literEq2 = literal1.equals(literal2);
        System.out.println("Literals with == " + literEq1);
        System.out.println("Literals with equals " + literEq2);
        String string1 = new String("Test text");
        String string2 = new String("Test text");
        boolean strEq1 = string1 == string2;
        boolean strEq2 = string1.equals(string2);
        System.out.println("Strings with == " + strEq1);
        System.out.println("Strings with equals " + strEq2);
    }
}

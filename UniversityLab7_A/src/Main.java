import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringHandler stringHandler = new StringHandler();
        String whereToSearch = "Text messaging, or texting, is the act of composing and " +
                "sending electronic messages, typically consisting of alphabetic and numeric characters," +
                " between two or more users of mobile devices, desktops/laptops, or other type of " +
                "compatible computer.";
        System.out.println("String:");
        System.out.println(whereToSearch);
        System.out.println("Enter a pattern to search: ");
        String pattern = scanner.nextLine();
        System.out.println("Enter a word to insert after words matching the pattern: ");
        String toInsert = scanner.nextLine();
        String result = stringHandler.insertAfter(whereToSearch, pattern, toInsert);
        System.out.println("Final string: ");
        System.out.println(result);
    }
}

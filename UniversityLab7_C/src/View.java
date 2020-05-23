import java.util.Scanner;

public class View {
    public void showInterface() {
        boolean menuFlag = true;
        Scanner scanner = new Scanner(System.in);
        StringWrapper stringWrapper = new StringWrapper();
        String temp = "";

        while (menuFlag) {
            System.out.println("1. Enter a string.");
            System.out.println("2. Wrap a string.");
            System.out.println("3. Unwrap a string.");
            System.out.println("4. Exit.");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Enter a string:");
                    temp = scanner.nextLine();
                    break;
                case "2":
                    temp = stringWrapper.stringWrap(temp);
                    System.out.println(temp);
                    break;
                case "3":
                    temp = stringWrapper.stringUnwrap(temp);
                    System.out.println(temp);
                    break;
                default:
                    menuFlag = false;
                    break;
            }
        }
    }
}

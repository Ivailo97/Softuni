import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        PrintMessage(password);
    }

    private static void PrintMessage(String password) {
        boolean isValidLen = CheckForLength(password);
        boolean areValidSymbols = CheckForSymbols(password);
        boolean haveTwoDigits = CheckForDigits(password);

        if (isValidLen && areValidSymbols && haveTwoDigits) {
            System.out.println(("Password is valid"));
        } else {
            if (!isValidLen) {
                System.out.println(("Password must be between 6 and 10 characters"));
            }

            if (!areValidSymbols) {
                System.out.println(("Password must consist only of letters and digits"));
            }

            if (!haveTwoDigits) {
                System.out.println(("Password must have at least 2 digits"));
            }
        }
    }

    private static boolean CheckForDigits(String password) {
        boolean result = false;
        int count = 0;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                count++;

                if (count == 2) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }

    private static boolean CheckForSymbols(String password) {
        boolean result = false;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i)) || Character.isLetter(password.charAt(i))) {
                result = true;

            } else {
                result = false;
                break;
            }
        }

        return result;
    }

    private static boolean CheckForLength(String password) {
        boolean result = true;

        if (password.length() > 10 || password.length() < 6) {
            result = false;
        }

        return result;
    }
}


import java.util.Scanner;

public class DigitsLetterAndOthers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text  = scanner.nextLine();
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder special = new StringBuilder();

        for (int i = 0; i < text.length() ; i++) {

            if (Character.isDigit(text.charAt(i))){

                digits.append(text.charAt(i));
            }else if(Character.isLetter(text.charAt(i))){

                letters.append(text.charAt(i));
            }else {
                special.append(text.charAt(i));
            }
        }

        System.out.println(digits);
        System.out.println(letters);
        System.out.println(special);
    }
}

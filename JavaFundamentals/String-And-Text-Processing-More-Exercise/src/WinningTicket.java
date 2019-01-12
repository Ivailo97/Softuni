import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tickets = scanner.nextLine().split("[, ]+");
        Pattern pattern = Pattern.compile("([\\^]{6,10}|[\\$]{6,10}|[\\@]{6,10}|[#]{6,10})");

        for (int i = 0; i < tickets.length; i++) {
            tickets[i] = tickets[i].trim();
        }

        for (var ticket : tickets) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                String firstHalf = ticket.substring(0, 10);
                String secondHalf = ticket.substring(10);

                Matcher matcher1 = pattern.matcher(firstHalf);
                int len1 = 0;
                if (matcher1.find()){

                    len1 = matcher1.group(0).length();
                }
                int len2 = 0;
                Matcher matcher2 = pattern.matcher(secondHalf);

                if (matcher2.find()){

                    len2 = matcher2.group(0).length();
                }

                int minLen = Math.min(len1, len2);

                if (minLen >= 6 && matcher1.toString().charAt(0) == matcher2.toString().charAt(0)) {
                    if (minLen <= 9) {
                        System.out.printf("ticket \"%s\" - %d%s%n", ticket, minLen, matcher1.group(0).charAt(0));
                    } else if (minLen == 10) {
                        System.out.printf("ticket \"%s\" - %d%s Jackpot!%n", ticket, minLen, matcher1.group(0).charAt(0));
                    }
                } else {

                    System.out.printf("ticket \"%s\" - no match%n",ticket);
                }
            }
        }
    }
}

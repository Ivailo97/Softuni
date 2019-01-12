import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> contests = new LinkedHashMap<>();
        List<User> users = new ArrayList<>();

        while (true) {

            String line = scanner.nextLine();
            if (line.equals("end of contests")) {

                break;
            }

            String[] tokens = line.split(":");
            String contestName = tokens[0];
            String contestPassword = tokens[1];
            contests.put(contestName, contestPassword);
        }

        while (true) {

            String line = scanner.nextLine();
            if (line.equals("end of submissions")) {

                break;
            }

            String[] tokens = line.split("=>");
            String contest = tokens[0];
            String password = tokens[1];
            String username = tokens[2];
            int points = Integer.parseInt(tokens[3]);

            if (contests.containsKey(contest) && contests.get(contest).equals(password)) {

                User user = new User(username);
                user.ContestsAndPoints.put(contest, points);

                boolean contains = false;

                for (User member : users) {

                    if (member.Name.equals(username) && member.ContestsAndPoints.containsKey(contest)) {

                        if (member.ContestsAndPoints.get(contest) < points) {

                            member.ContestsAndPoints.put(contest, points);
                        }

                        contains = true;
                    } else if (member.Name.equals(username)) {

                        member.ContestsAndPoints.put(contest, points);
                        contains = true;
                    }
                }

                if (!contains) {

                    users.add(user);
                }
            }
        }

        for (User user : users) {

            user.TotalPoints = user.ContestsAndPoints.entrySet().stream().mapToInt(e -> e.getValue()).sum();
        }

        User bestUser = users.stream().max(Comparator.comparing(e -> e.TotalPoints)).get();

        System.out.printf("Best candidate is %s with total %d points.%n", bestUser.Name, bestUser.TotalPoints);
        System.out.println("Ranking: ");

        users.stream().sorted(Comparator.comparing(User::getName)).forEach(e -> {
            System.out.println(e.Name);
            e.ContestsAndPoints.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                    .forEach(x -> System.out.printf("#  %s -> %d%n", x.getKey(), x.getValue()));
        });
    }
}

class User {

    public String Name;
    public LinkedHashMap<String, Integer> ContestsAndPoints;
    public int TotalPoints;

    public User(String name) {

        Name = name;
        ContestsAndPoints = new LinkedHashMap<>();
    }

    public String getName() {

        return Name;
    }
}



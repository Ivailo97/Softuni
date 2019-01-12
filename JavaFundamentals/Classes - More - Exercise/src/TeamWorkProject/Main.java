package TeamWorkProject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Team> teams = new ArrayList<>();

        List<String> disbanded = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] creatorAndTeam = scanner.nextLine().split("-");
            String creator = creatorAndTeam[0];
            String teamName = creatorAndTeam[1];

            Team currentTeam = new Team(teamName, new ArrayList<>(), creator);
            Team test = teams.stream().filter(x -> x.getName().equals(teamName)).findFirst().orElse(null);

            if (test != null) {
                System.out.printf("Team %s was already created!\n", teamName);
            }

            Team test1 = teams.stream().filter(x -> x.getCreatorName().equals(creator)).findFirst().orElse(null);

            if (test1 != null) {

                System.out.printf("%s cannot create another team!\n", creator);
            }

            boolean condition = test == null && test1 == null;

            if (condition) {
                System.out.printf("Team %s has been created by %s!\n", teamName, creator);
                teams.add(currentTeam);
            }
        }

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("end of assignment")) {
                break;
            }

            String[] tokens = line.split("->");

            String nameToJoin = tokens[0];
            String teamToJoin = tokens[1];


            if (teams.stream().filter(x -> x.getName().equals(teamToJoin)).findFirst().orElse(null) == null) {

                System.out.printf("Team %s does not exist!\n", teamToJoin);


            } else if (teams.stream().filter(x -> x.getMembers().contains(nameToJoin)).findFirst().orElse(null) != null
                    || teams.stream().filter(x -> x.getCreatorName().equals(nameToJoin)).findFirst().orElse(null) != null) {

                System.out.printf("Member %s cannot join team %s!\n", nameToJoin, teamToJoin);

            } else {

                Team current = teams.stream().filter(x -> x.getName().equals(teamToJoin)).findFirst().orElse(null);

                if ( current != null && !current.getMembers().contains(nameToJoin))
                {
                    current.getMembers().add(nameToJoin);
                }
            }
        }

        for (var team : teams) {
            if (team.getMembers().size() == 0) {
                disbanded.add(team.getName());
            }
        }

        teams.stream().filter(x -> x.getMembers().size() != 0).sorted((e1, e2) -> {

            int result = Integer.compare(e2.getMembers().size(), e1.getMembers().size());

            if (result == 0) {

                result = e1.getName().compareTo(e2.getName());
            }

            return result;
        }).forEach(x -> {
            System.out.println(x.getName());
            System.out.println("- " + x.getCreatorName());
            x.getMembers().stream().sorted(Comparator.naturalOrder()).forEach(y -> System.out.println("-- " + y));
        });

        System.out.println("Teams to disband:");

        disbanded.stream().sorted(Comparator.naturalOrder()).forEach(x -> System.out.println(x));
    }
}


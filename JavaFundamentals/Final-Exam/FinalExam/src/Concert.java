import java.util.*;

public class Concert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> bands = new LinkedHashMap<>();
        Map<String, Integer> bandsAndTime = new LinkedHashMap<>();
        long totalTime = 0;

        String line = scanner.nextLine();
        while (!line.equals("start of concert")) {

            String[] tokens = line.split("; ");

            switch (tokens[0]) {

                case "Add":
                    String bandName = tokens[1];
                    if (!bands.containsKey(bandName)) {

                        bands.put(bandName, new ArrayList<>());

                        if (!bandsAndTime.containsKey(bandName)){

                            bandsAndTime.put(bandName, 0);
                        }

                    }

                    String[] members = tokens[2].split(", ");
                    for (String member : members) {
                        if (!bands.get(bandName).contains(member)) {
                            bands.get(bandName).add(member);
                        }
                    }
                    break;
                case "Play":

                    String band = tokens[1];
                    int time = Integer.parseInt(tokens[2]);
                    totalTime += time;
                    if (!bandsAndTime.containsKey(band)) {

                        bandsAndTime.put(band, time);

                    } else {
                        bandsAndTime.put(band, bandsAndTime.get(band) + time);
                    }
                    break;
            }



            line = scanner.nextLine();
        }

        System.out.printf("Total time: %d%n",totalTime);

        bandsAndTime.entrySet().stream().sorted((x1,x2)-> {

            int result = Integer.compare(x2.getValue(),x1.getValue());

            if (result == 0){

                result =  x1.getKey().compareTo(x2.getKey());
            }

            return  result;
        }).forEach(x-> System.out.printf("%s -> %d%n",x.getKey(),x.getValue()));

        String bandToPrint = scanner.nextLine();

        if (bands.containsKey(bandToPrint)){

            System.out.println(bandToPrint);
            bands.get(bandToPrint).stream().forEach(x-> System.out.printf("=> %s%n",x));
        }

    }
}

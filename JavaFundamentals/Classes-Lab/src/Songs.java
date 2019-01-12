import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Song> songs = new ArrayList<Song>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("_");
            String type = tokens[0];
            String name = tokens[1];
            String duration = tokens[2];
            Song song = new Song(type, name, duration);
            songs.add(song);
        }

        String line = scanner.nextLine();

        if (line.equals("all")) {
            for (Song song : songs) {
                System.out.println(song.Name);
            }
        } else {
            for (Song song : songs) {
                if (song.TypeList.equals(line)) {
                    System.out.println(song.Name);
                }
            }
        }
    }
}

class Song {
    public String TypeList;
    public String Name;
    public String Time;

    public Song(String type, String name, String time) {
        this.Name = name;
        this.TypeList = type;
        this.Time = time;
    }
}

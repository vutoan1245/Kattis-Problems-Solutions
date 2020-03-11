import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class whatdoesthefoxsay {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int numCase = Integer.parseInt(in.nextLine());

        while (numCase-- > 0) {
            String[] soundList = in.nextLine().split(" ");

            HashSet<String> noneFoxSound = new HashSet<String>();
            String line;
            while (!(line = in.nextLine()).equals("what does the fox say?")) {
                String sound = line.split(" ")[2];

                noneFoxSound.add(sound);
            }

            for (int i = 0; i < soundList.length; i++) {
                String sound = soundList[i];
                if (!noneFoxSound.contains(sound)) {
                    System.out.print(sound + " ");
                }
            }
            System.out.println();
        }

    }
}

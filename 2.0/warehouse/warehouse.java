import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class warehouse {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int numCase = in.nextInt();

        for (int i = 0; i < numCase; i++) {
            int numToy = in.nextInt();

            HashMap<String, Integer> toyMap = new HashMap<String, Integer>();
            for (int j = 0; j < numToy; j++) {
                String name = in.next();
                int count = in.nextInt();

                toyMap.put(name, toyMap.getOrDefault(name, 0) + count);
            }

            int size = toyMap.size();

            Toy toyList[] = new Toy[size];
            int index = 0;
            for (String name : toyMap.keySet()) {
                toyList[index++] = new Toy(name, toyMap.get(name));
            }
            Arrays.sort(toyList);

            System.out.println(size);
            for (int j = 0; j < size; j++) {
                System.out.println(toyList[j].name + " " + toyList[j].count);
            }
        }
    }
}

class Toy implements Comparable<Toy> {
    String name;
    int count;

    Toy(String n, int c) {
        name = n;
        count = c;
    }

    public int compareTo(Toy o) {
        if (count == o.count) {
            return name.compareTo(o.name);
        }

        return o.count - count;
    }
}

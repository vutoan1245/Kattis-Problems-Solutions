import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// https://open.kattis.com/problems/savinguniverse
class savingtheuniverse {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(in.readLine());

        for (int i = 1; i <= numCases; i++) {
            int result = 0;
            int engines = Integer.parseInt(in.readLine());
            for (int e = 0; e < engines; e++) {
                in.readLine();
            }

            int numQueries = Integer.parseInt(in.readLine());
            Set<String> set = new HashSet<String>();
            for (int j = 0; j < numQueries; j++) {
                String query = in.readLine();
                set.add(query);

                if (engines == set.size()) {
                    set.clear();
                    set.add(query);
                    result++;
                }

            }

            System.out.printf("case #%d: %d\n", i, result);
        }
        in.close();
    }
}

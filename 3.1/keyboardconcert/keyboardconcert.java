import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class keyboardconcert {
    static final int INF = 100000000;
    static int numInstrument, numTune;
    static int[] target;
    static boolean[][] hasTune;
    static int[][] dp;
    static ArrayList<ArrayList<Integer>> tuneToInstrument;

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        numInstrument = Integer.parseInt(st.nextToken());
        numTune = Integer.parseInt(st.nextToken());
        hasTune = new boolean[numInstrument][1001];
        tuneToInstrument = new ArrayList<>(1000);

        for (int i = 0; i <= 1000; i++) {
            tuneToInstrument.add(new ArrayList<>());
        }

        for (int i = 0; i < numInstrument; i++) {
            st = new StringTokenizer(in.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int tune = Integer.parseInt(st.nextToken());
                hasTune[i][tune] = true;
                tuneToInstrument.get(tune).add(i);
            }
        }

        st = new StringTokenizer(in.readLine());
        target = new int[numTune];
        for (int i = 0; i < numTune; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[numTune][numInstrument];
        for (int i = 0; i < numTune; i++) {
            for (int j = 0; j < numInstrument; j++) {
                dp[i][j] = -1;
            }
        }

        int result = INF;
        int nextTune = target[0];
        for (int i = 0; i < numInstrument; i++) {
            int size = tuneToInstrument.get(nextTune).size();
            for (int j = 0; j < size; j++) {
                int nextInstrument = tuneToInstrument.get(nextTune).get(j);
                result = Math.min(result, find(1, nextInstrument));
            }
        }

        System.out.println(result);
    }

    static int find(int tuneIndex, int instrument) {
        if (tuneIndex == numTune)
            return 0;
        if (dp[tuneIndex][instrument] != -1)
            return dp[tuneIndex][instrument];

        int result = INF;
        int nextTune = target[tuneIndex];

        if (hasTune[instrument][nextTune]) {
            result = find(tuneIndex + 1, instrument);
        } else {
            int size = tuneToInstrument.get(nextTune).size();
            for (int i = 0; i < size; i++) {
                int nextInstrument = tuneToInstrument.get(nextTune).get(i);
                result = Math.min(result, (nextInstrument == instrument ? 0 : 1) + find(tuneIndex + 1, nextInstrument));
            }
        }

        return dp[tuneIndex][instrument] = result;
    }
}

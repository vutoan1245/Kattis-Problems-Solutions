import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class builddeps {
    static final int MAX = 500000;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        HashMap<String, Integer> mapNameToId = new HashMap<String, Integer>();
        HashMap<Integer, String> mapIdToName = new HashMap<Integer, String>();

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        int idCount = 0;
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            int pos = line.indexOf(":");

            String fileName = line.substring(0, pos);

            if (!mapNameToId.containsKey(fileName)) {
                mapNameToId.put(fileName, idCount);
                mapIdToName.put(idCount, fileName);
                idCount++;
            }
            int id = mapNameToId.get(fileName);

            String[] dependencies = line.substring(pos + 1).split(" ");
            for (String d : dependencies) {
                if (d.length() == 0)
                    continue;
                if (!mapNameToId.containsKey(d)) {
                    mapNameToId.put(d, idCount);
                    mapIdToName.put(idCount, d);
                    idCount++;
                }
                int dId = mapNameToId.get(d);

                adjList.get(dId).add(id);
            }
        }

        String first = in.nextLine();
        int[] dCount = new int[n];
        boolean[] visited = new boolean[n];
        int firstId = mapNameToId.get(first);

        dfs(firstId, dCount, adjList, new boolean[n]);

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(firstId);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (visited[cur])
                continue;
            visited[cur] = true;
            System.out.println(mapIdToName.get(cur));

            for (int next : adjList.get(cur)) {
                dCount[next]--;
                if (dCount[next] == 0) {
                    queue.add(next);
                }

            }
        }
    }

    static void dfs(int id, int[] dCount, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        if (visited[id])
            return;
        visited[id] = true;
        for (int parent : adjList.get(id)) {
            dCount[parent]++;
            dfs(parent, dCount, adjList, visited);
        }
    }

}

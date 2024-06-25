import java.util.*;

public class Huawei3 {
    // 一个局域网内有很多台电脑，分别标注为0 - N-1的数字。相连接的电脑距离不一样，所以感染的时间不一样，感染时间用t表示。
    // 其中网络内一个电脑被病毒感染，其感染网络内所有电脑最少需要多长时间。如果最后有电脑不会感染，则返回-1。
    // 给定一个数组times表示一个电脑把相邻电脑感染所用的时间。path[i] = {i,j,t}表示电脑i感染电脑j所需时间为t。
    // 输入：4
    //      3
    //      2 1 1
    //      2 3 1
    //      3 4 1
    //      2
    // 输出：2
    // 输入第一行为局域网内电脑总数M，第二行为总共的网络连接数N，后N行为数组times，最后一行为病毒一开始所在的电脑号
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[][] times = new int[N][3];
        for (int i = 0; i < N; i++) {
            times[i][0] = sc.nextInt();
            times[i][1] = sc.nextInt();
            times[i][2] = sc.nextInt();
        }

        int initial = sc.nextInt();

        // 构建邻接表
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int t = time[2];
            if (!graph.containsKey(from)) {
                graph.put(from, new ArrayList<>());
            }
            graph.get(from).add(new int[]{to, t});
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{initial, 0});
        int[] distance = new int[M + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[initial] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int computer = cur[0];
            int curTime = cur[1];

            if (graph.containsKey(computer)) {
                for (int[] neighbor : graph.get(computer)) {
                    int nextComputer = neighbor[0];
                    int nextTime = neighbor[1];
                    int newTime = curTime + nextTime;

                    if (newTime < distance[nextComputer]) {
                        distance[nextComputer] = newTime;
                        queue.offer(new int[]{nextComputer, newTime});
                    }
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= M; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                maxTime = -1;
                break;
            }
            maxTime = Math.max(maxTime, distance[i]);
        }

        System.out.println(maxTime);
    }
}

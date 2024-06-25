import java.util.*;

public class LC347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums) {
            Integer cnt = freqMap.getOrDefault(num, 0);
            freqMap.put(num, cnt + 1);
        }

        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            int[] array = new int[]{entry.getKey(), entry.getValue()};
            queue.offer(array);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }

        return result;
    }
}

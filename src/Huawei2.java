import java.util.*;

public class Huawei2 {
    // 给定一个乱序的数组，删除所有的重复元素，使得每个元素只出现一次，并且按照出现的次数从高到低进行排序，相同出现次数按照第一次出现顺序进行先后排序
    // 输入：1,3,3,3,2,4,4,4,5
    // 输出：3,4,1,2,5
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) { // 注意 while 处理多个 case
            // 处理以上格式的输入
            String next = in.next();
            int[] nums = Arrays.stream(next.split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            HashSet<Integer> set = new HashSet<>();
            HashMap<Integer, Integer> cntMap = new HashMap<>();
            HashMap<Integer, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
                cntMap.put(nums[i], cntMap.getOrDefault(nums[i], 0) + 1);
                if (!indexMap.containsKey(nums[i])) {
                    indexMap.put(nums[i], i);
                }
            }

            List<Integer> result = new ArrayList<>(set);
            result.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    int compareCnt = cntMap.get(o2).compareTo(cntMap.get(o1));
                    if (compareCnt == 0) {
                        // 需要比较元素首次出现顺序
                        return indexMap.get(o1).compareTo(cntMap.get(o2));
                    }
                    return compareCnt;
                }
            });

            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i != result.size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }
}

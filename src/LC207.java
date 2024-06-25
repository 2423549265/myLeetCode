import java.util.*;

public class LC207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] preDegree = new int[numCourses];
        HashMap<Integer, List<Integer>> relationMap = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            // 记录每个课程的入度
            preDegree[prerequisites[i][0]] ++;
            // 记录每个课程的依赖关系
            List<Integer> relationList = relationMap.getOrDefault(prerequisites[i][1], new ArrayList<>());
            relationList.add(prerequisites[i][0]);
            relationMap.put(prerequisites[i][1], relationList);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (preDegree[i] == 0) {
                // 入度为0的课程入队
                deque.add(i);
            }
        }

        int studiedCourse = 0;
        while (!deque.isEmpty()) {
            // 选课并根据依赖关系更新入度数组
            Integer course = deque.poll();
            List<Integer> relationList = relationMap.getOrDefault(course, new ArrayList<>());
            for (Integer i : relationList) {
                preDegree[i] --;
                if (preDegree[i] == 0) {
                    // 先导课程都已经选完，则可以入队
                    deque.add(i);
                }
            }
            studiedCourse ++;
        }

        return studiedCourse == numCourses;
    }
}

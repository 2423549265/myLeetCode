import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> stringList = map.getOrDefault(key, new ArrayList<>());
            stringList.add(strs[i]);
            map.put(key, stringList);
        }

        return new ArrayList<>(map.values());
    }
}

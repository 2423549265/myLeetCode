import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingerSongs {
    //    题目：找出用户最爱歌手
//    假设有个用户唱歌的集合: Map<String, List<String>> userSongs。  key是用户名，list是用户唱的歌曲列表。
//    有个歌手的歌曲的集合:  Map<String, List<String>> singerSongs。 key是歌手名，list是歌曲列表。
//    任务是返回用户最喜欢的歌手map: Map<String, List<String>>。 key是用户名，list是歌手名，list中的value是用户听的最多个歌曲对应的歌手。
//    例子1：
//    Input:
//    userSongs = {
//        "张三": ["song1", "song2", "song3", "song4", "song8"],
//        "李四":  ["song5", "song6", "song7"]
//    },
//    singerSongs = {
//        "周杰伦":    ["song1", "song3"],
//        "王力宏": ["song7"],
//        "孙燕姿":  ["song2", "song4"],
//        "崔健":     ["song5", "song6"],
//        "许巍":    ["song8", "song9"]
//    }
//    Output: {
//        "张三": ["周杰伦", "孙燕姿"],
//        "李四":  ["崔健"]
//    }
//    例子2:
//    Input:
//    userSongs = {
//        "张三": ["song1", "song2"],
//        "李四":  ["song3", "song4"]
//    },
//    singerSongs = {}
//    Output: {
//        "张三": [],
//        "李四":  []
//    }
    public Map<String, List<String>> findFavourate(Map<String, List<String>> userSongs, Map<String, List<String>> singerSongs) {
        Map<String, List<String>> result = new HashMap<>();

        // 遍历用户统计听歌的次数
        for (Map.Entry<String, List<String>> entry : userSongs.entrySet()) {
            String user = entry.getKey();
            List<String> songs = entry.getValue();

            // 记录该用户所听歌手及其次数
            Map<String, Integer> cntMap = new HashMap<>();
            // maxCnt为听的最多的歌手次数
            int maxCnt = 0;
            for (String song : songs) {
                // 遍历歌手歌曲集合统计次数
                for (Map.Entry<String, List<String>> singerEntry : singerSongs.entrySet()) {
                    String singer = singerEntry.getKey();
                    List<String> singerSongsList = singerEntry.getValue();
                    if (singerSongsList.contains(song)) {
                        int cnt = cntMap.getOrDefault(singer, 0);
                        cnt++;
                        maxCnt = Math.max(maxCnt, cnt);
                        cntMap.put(singer, cnt);
                    }
                }
            }

            // 记录听歌次数为maxCnt的歌手列表
            List<String> favourateSingers = new ArrayList<>();
            for (Map.Entry<String, Integer> cntEntry : cntMap.entrySet()) {
                if (maxCnt == cntEntry.getValue()) {
                    favourateSingers.add(cntEntry.getKey());
                }
            }

            result.put(user, favourateSingers);
        }

        return result;
    }
}

public class LC76 {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";
        int[] sFre = new int[128];
        int[] tFre = new int[128];
        for(int i = 0; i < t.length(); i++){
            tFre[t.charAt(i)]++;
        }
        int left = 0, right = 0, len = s.length();
        int start = -1, minLen = s.length() + 1;
        int distance = 0; //记录s的子串与t有多少个字母相同
        while (right < len){
            if(tFre[s.charAt(right)] == 0){ //不在t中
                right++;
                continue;
            }
            sFre[s.charAt(right)]++;
            if(sFre[s.charAt(right)] <= tFre[s.charAt(right)]){
                distance++;
            }
            right++;
            while (distance == t.length()){
                if(tFre[s.charAt(left)] == 0){ //不在t中
                    left++;
                    continue;
                }
                if(right - left < minLen){
                    minLen = right - left;
                    start = left;
                }
                sFre[s.charAt(left)]--;
                if(sFre[s.charAt(left)] < tFre[s.charAt(left)])
                    distance--;
                left++;
            }
        }
        if(minLen == s.length() + 1)
            return "";
        return s.substring(start, start + minLen);
    }
}

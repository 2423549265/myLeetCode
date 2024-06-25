public class LC28 {
    public int strStr(String haystack, String needle) {
        char startChar = needle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            if (startChar == haystack.charAt(i)) {
                if (i + needle.length() <= haystack.length()) {
                    String substring = haystack.substring(i, i + needle.length());
                    if (substring.equals(needle)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}

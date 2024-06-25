public class LC58 {
    public int lengthOfLastWord(String s) {
        String trim = s.trim();
        return trim.length() - trim.lastIndexOf(" ") - 1;
    }
}

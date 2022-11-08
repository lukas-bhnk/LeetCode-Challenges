class Solution {
    public String makeGood(String s) {
        if (s.length() == 0) return "";
        if (s.length()== 1) return s;
        if (s.length() == 2 && Character.toUpperCase(s.charAt(0)) == Character.toUpperCase(s.charAt(1)) && s.charAt(0) != s.charAt(1)) return "";
        for (int i = 0; i < s.length()-1; i++) {
            if(Character.toUpperCase(s.charAt(i)) == Character.toUpperCase(s.charAt(i+1)) && s.charAt(i) != s.charAt(i+1)) return makeGood(s.substring(0,i) + s.substring(i+2, s.length()));
        }
        return s;
    }
}
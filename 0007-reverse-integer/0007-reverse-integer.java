class Solution {
    public int reverse(int x) {
        if ( x > 1000000000 && x % 1000 >= 512) return 0;
        if ( x < -1000000000 && x % 1000 <= -512) return 0;
        if (x < 0) {
            String s = reverse(-x, "");
            try {
            return Integer.valueOf("-" + s);
            }
            catch (NumberFormatException e) {
                return 0;
            }   
       }
        String s = reverse(x, "");
        try {
        return Integer.valueOf(s);}
        catch (NumberFormatException e) {
            return 0;
        }
    }
    
    public String reverse(int x, String s) {
        s += String.valueOf( x % 10);
        if(s.length() > 2 && s.charAt(0) == '0') s = s.substring(1, s.length());
        x = x / 10;
        if(x != 0) s = reverse(x, s);
        return s;
        
        
    }
}
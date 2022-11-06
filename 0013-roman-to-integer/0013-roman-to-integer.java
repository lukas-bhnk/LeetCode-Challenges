class Solution {
    public int getNumber(String s) {
        if(s.equals("I")) return 1;
        if(s.equals("V")) return 5;
        if(s.equals("X")) return 10;
        if(s.equals("L")) return 50;
        if(s.equals("C")) return 100;
        if(s.equals("D")) return 500;
        if(s.equals("M")) return 1000;   
        return 0;
    }
    
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != s.length()-1) { 
                int curNumber = getNumber(s.substring(s.length() - i -1, s.length()-i));
                int beforeNumber = getNumber(s.substring(s.length() - i -2, s.length()-i -1));
                if(curNumber > beforeNumber) {
                    sum += (curNumber - beforeNumber);
                    i++;
                }
                else sum += curNumber;
            }
            else sum += getNumber(s.substring(s.length() - i -1, s.length()-i));
        }
        return sum;
    }
}
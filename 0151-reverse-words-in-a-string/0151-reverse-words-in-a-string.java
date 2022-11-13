class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        int i = arr.length -1;
        s = "";
        while (i > 0) {
            if (arr[i].length() == 0) {
                i--;
                continue;
            }
            s += arr[i].trim() + " ";
            i--;
        }
        if(arr[0].length() == 0) return s.substring(0, s.length()-1);
        s += arr[0];
        return s;
    }
}
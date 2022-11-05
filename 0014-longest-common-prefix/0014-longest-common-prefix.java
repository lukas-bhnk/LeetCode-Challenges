class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        String output = "";
        int indexShortestWord = 0;
        for(int i = 0; i < strs[0].length(); i++) {
            for(int j = 1; j < strs.length; j++) {
                if (strs[indexShortestWord].length() <= i) return output;
                if (i == 0 && strs[indexShortestWord].length() > strs[j].length()) indexShortestWord = j;
                if (strs[j].length() == 0 || strs[j-1].length() == 0) return output;
                if (!(strs[j].substring(i, i+1).equals(strs[j-1].substring(i, i+1)))) return output;
                if ((strs[j].substring(i, i+1).equals(strs[j-1].substring(i, i+1))) && (j == strs.length-1)) output += strs[j].substring(i, i+1);
            }
        }
        return output;
    }
}
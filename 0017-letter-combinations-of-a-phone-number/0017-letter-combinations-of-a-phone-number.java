class Solution {


    String[] phone = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
            List<String> list = new ArrayList<String>();
            if (digits == null || digits.length() == 0) {
                return list;
            }
            else if (digits.length() == 1) {
                List<String> temp = new ArrayList<String>();
                String val = phone[Integer.parseInt(digits)];
                for (int i = 0; i < val.length(); i++) {
                    temp.add(val.charAt(i) + "");
                }
                return temp;
            }
            else {
                List<String> temp = letterCombinations(digits.substring(1));
                String val = phone[Integer.parseInt(digits.substring(0, 1))];
                List<String> result = new ArrayList<String>();
                for (int i = 0; i < val.length(); i++) {
                    for (int j = 0; j < temp.size(); j++) {
                        result.add(val.charAt(i) + temp.get(j));
                    }
                }
                return result;
            }
        }
    
}
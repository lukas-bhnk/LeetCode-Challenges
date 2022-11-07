class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> curCandidates = new ArrayList<>();
        int sum = 0;
        List<List<Integer>> output = new ArrayList<>();
        helper(0, candidates, curCandidates, sum, target, output);
        return output;
    }
    
    public void helper(int index, int[] candidates, List<Integer> curCandidates, int sum, int target, List<List<Integer>> output) {
        if (sum == target) {
            if(!(output.contains(curCandidates))) output.add(new ArrayList<>(curCandidates));
            return;
            }
        if (index >= candidates.length) return;
        if (sum > target) return;
        
        int number = candidates[index];
        sum += number;
        curCandidates.add(number);
        helper(index + 1, candidates, curCandidates, sum, target, output);
        
        sum -= number;
        curCandidates.remove(curCandidates.size()-1);
        while(index+1<candidates.length && candidates[index]==candidates[index+1])
            index++;
        helper(index +1, candidates, curCandidates, sum, target, output);
    }
}
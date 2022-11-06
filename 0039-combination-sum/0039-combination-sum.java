class Solution {
    
        public void getAllCombinations(int index, ArrayList<Integer> curCandidates, int[] candidates, int sum, int target, ArrayList<List<Integer>> output) {
        if (sum > target) return;
        if (index >= candidates.length) return;
        if (sum == target) {
            output.add(new ArrayList<>(curCandidates));
            return;
        }
        
        curCandidates.add(candidates[index]);
        sum += candidates[index];
        getAllCombinations(index, curCandidates, candidates, sum, target, output);
        
        curCandidates.remove(curCandidates.size()-1);
        sum -= candidates[index];
        index++;
        getAllCombinations(index, curCandidates, candidates, sum, target, output);
        
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> curCandidates = new ArrayList<>();
        ArrayList<List<Integer>> output = new ArrayList<>();
        int sum = 0;
        getAllCombinations(0, curCandidates, candidates, sum, target, output);
        return output;
    }
    
}
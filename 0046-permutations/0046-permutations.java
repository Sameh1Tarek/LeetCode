
class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        permutations(ans, nums, 0);
        return ans;
    }

    private void permutations(List<List<Integer>> ans, int[] nums, int index) {

        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int x : nums) {
                temp.add(x);
            }
            ans.add(temp);
            return;
        }

        for (int i = index; i < nums.length; i++) {
                swap(nums, i, index);
                permutations(ans, nums, index + 1);
                swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
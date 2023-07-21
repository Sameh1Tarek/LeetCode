class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] res = new int[n]; // store length
        Arrays.fill(res,1);

        int[] count = new int[n]; // store count
        Arrays.fill(count,1);

        int mxlen = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] < nums[j]) continue;
                if (nums[i] > nums[j]) {
                    if (res[j] + 1 > res[i]) {
                        res[i] = res[j] + 1;
                        count[i] = count[j];
                    } else if (res[j] + 1 == res[i]) {
                        count[i] += count[j];
                    }
                }
            }
            mxlen = Math.max(mxlen, res[i]);
        }
        
        int numOfLists = 0;
        for (int i = 0; i < n; i++) {
            if (res[i] == mxlen) {
                numOfLists += count[i];
            }
        }
        return numOfLists;
    }
}
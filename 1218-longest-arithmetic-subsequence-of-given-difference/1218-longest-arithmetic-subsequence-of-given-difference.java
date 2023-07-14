class Solution {
    public int longestSubsequence(int[] arr, int d) {
        
        Map<Integer,Integer>mp =new HashMap<>();
        int ans=Integer.MIN_VALUE;
        
        for(int x : arr){
            mp.put(x,mp.getOrDefault(x-d,0)+1);
            ans=Math.max(ans,mp.get(x));
        }
        
        return ans;
    }
}
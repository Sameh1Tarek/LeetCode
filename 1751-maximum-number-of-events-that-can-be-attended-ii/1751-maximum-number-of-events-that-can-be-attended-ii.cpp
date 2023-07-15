class Solution {
public:

    int solve(vector<vector<int>>& e, int k,int i,vector<vector<int>>&dp){
        if(i>=e.size() || !k){
            return 0;
        }
        if(dp[i][k]!=-1){
            return dp[i][k];
        }
        
        int ans= solve(e,k,i+1,dp);

        vector<int>temp={e[i][1],INT_MAX,INT_MAX};
        int in = upper_bound(e.begin(),e.end(),temp)-e.begin();
        ans=max(ans, e[i][2] + solve(e,k-1,in,dp));

        return dp[i][k] = ans;
    }

    int maxValue(vector<vector<int>>& e, int k) {
        sort(e.begin(),e.end());
        vector<vector<int>>dp(e.size(),vector<int>(k+1,-1));
        return solve(e,k,0,dp);
    }
};
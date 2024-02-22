class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
         vector<int> incoming(n + 1);
         vector<int> outcoming(n + 1);
         for(auto edge : trust){
             incoming[edge[1]]++;
             outcoming[edge[0]]++;
         }
         for(int i =1; i <= n; i++){
             if(incoming[i] == n-1 && !outcoming[i]){
                 return i;
             }
         }
         return -1;
    }
};
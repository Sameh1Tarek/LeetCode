class Solution {
public:
    int largestVariance(string s) {
        vector<int>freq(26);
    
        for(auto x : s){
            freq[x-'a']++;
        }

        int ans=0;
        for(char i='a' ;i<='z' ;i++){
            for(char j='a' ;j<='z' ;j++ ){
// Skip if j is the same as i or either i or j has a frequency of 0
                if(j==i || !freq[i-'a'] || !freq[j-'a'])
                    continue;
// Perform the calculation twice (forward and backward)
                for(int k=0 ; k<2 ;k++){
                    int ch1=0;// Counter for letter i
                    int ch2=0;// Counter for letter j
                    for(auto x : s){
                        if(x==i)
                            ch1++; // Increment ch1 if the current letter is i
                        if(x==j)
                            ch2++;// Increment ch2 if the current letter is j
                        if(ch2>ch1){
                            ch1=0;
                            ch2=0;// Reset ch1 and ch2 if ch2 becomes greater than ch1
                        }
                        if(ch1>ch2 && ch2>0)
                            ans=max(ans,ch1-ch2);
                    }
                    reverse(s.begin(), s.end()); // Reverse the string for the next iteration
                }
            }
        }
        return ans;
    }
};
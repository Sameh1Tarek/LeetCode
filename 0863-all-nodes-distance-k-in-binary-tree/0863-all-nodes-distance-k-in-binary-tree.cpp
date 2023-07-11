/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    
    void build(TreeNode* root,unordered_map<int,vector<int>>&g){
        if(root->left){
            g[root->val].push_back(root->left->val);
            g[root->left->val].push_back(root->val);
            build(root->left,g);
        }
        if(root->right){
            g[root->val].push_back(root->right->val);
            g[root->right->val].push_back(root->val);
            build(root->right,g);
        }
    }

    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        if(k==0){
            return {target->val};
        }

        unordered_map<int,vector<int>>graph;
        unordered_map<int,bool>vis;
        build(root,graph);

        vector<int>ans;
        queue<int>q;
        int dis=0;
        q.push(target->val);

        while(!q.empty()){
            int n=q.size();
            while(n--){
            int node=q.front();
            vis[node]=1;
            q.pop();
            for(auto it: graph[node]){
                if(!vis[it]){
                    q.push(it);
                }
            }
            }
            dis++;
            if(dis==k){
                while(!q.empty()){
                    ans.push_back(q.front());
                    q.pop();
                }
                break;
            }
        }
        return ans;
    }
};
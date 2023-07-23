/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> list = new ArrayList<>();
        if (n % 2 == 0) {
            return list;
        }
        if (n == 1) {
            list.add(new TreeNode(0));
        }

        for (int i = 1; i < n; i += 2) {
            int j = n - i - 1;
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(j);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    list.add(new TreeNode(0, l, r));
                }
            }
        }
        return list;
    }

}
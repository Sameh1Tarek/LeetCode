/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        stack<int>st1,st2,ans;

        while(l1 || l2){
            if(l1){
                st1.push(l1->val);
                l1 = l1->next;
            }
             if(l2){
                st2.push(l2->val);
                l2 = l2->next;
            }
        }
        int carry=0;
        while(st1.size() || st2.size()){
            int temp=0;
            if(st1.size()){
                temp+=st1.top();
                st1.pop();
            }
            if(st2.size()){
                temp+=st2.top();
                st2.pop();
            }
            temp+=carry;
            carry=temp/10;
            temp%=10;
            
            ans.push(temp);
        }
        if(carry){
            ans.push(carry);
        }

        ListNode* head = new ListNode();
        ListNode* prev = head;
        while(ans.size()){
            ListNode* cur = new ListNode(ans.top());
            prev->next = cur;
            prev=prev->next;
            ans.pop();
        }

        return head->next;
    }
};
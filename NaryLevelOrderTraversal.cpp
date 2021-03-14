/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
//https://leetcode.com/problems/n-ary-tree-level-order-traversal/
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        if(!root){
            return {};
        }
        vector<vector<int>>res;
        queue<Node* > q;
        q.push(root);
        while(!q.empty()){
            int len = q.size();
            vector<int> level;
            for(int i =0; i<len; i++){
                Node* temp = q.front();
                q.pop();
                level.push_back(temp->val);
                for(int j=0; j<temp->children.size(); j++){
                    q.push(temp->children[j]);
                }
            }
            res.push_back(level);
        }
        return res;
    }
};
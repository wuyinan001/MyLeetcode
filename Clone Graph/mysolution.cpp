/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    Node* cloneGraph(Node* node) {
        if(node==NULL)
            return NULL;
        
        map<Node*,Node*> map;
        
        map[node]=new Node(node->val);
        
        vector<Node*> queue{node};
        
        while(!queue.empty())
        {
            Node* curr=queue.back();
            queue.pop_back();
            
            for(Node* u:curr->neighbors)
            {
                if(map.find(u)==map.end())
                {
                    map[u]=new Node(u->val);
                    queue.push_back(u);
                }
                
                map[curr]->neighbors.push_back(map[u]);
            }
        }
        
        return map[node];
    }
};
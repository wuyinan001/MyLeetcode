class Solution:
    def decodeString(self, s: str) -> str:
        stack=[]
        
        for c in s:
            if c==']':
                curr=""
                while stack[-1]!='[':
                    curr=stack.pop()+curr
                    
                # pop "["    
                stack.pop()
                
                num=""
                while stack and ord(stack[-1])>=ord('0') and ord(stack[-1])<=ord('9'):
                    num=stack.pop()+num
                    
                for i in range(int(num)):
                    for c2 in curr:
                        stack.append(c2)
            else:
                stack.append(c)
        
        return ''.join(stack)
class Solution():
   def isMatch(self, s, p):
        
        # matched[i][j] is True if the first one is opened
        matched = [[False for _ in range(len(p)+1] for _ in range(len(s)+1)]
        matched[0][0] = True
        
        for i in range(len(s)+1):
            for j in range(1, len(p)+1):
                pattern = p[j-1]
                
                if pattern == '.':
                  matched[i][j] = (i != 0 and matched[i-1][j-1])
                  
                elif pattern == '*':
 return result

class Solution:
    def longestPalindrome(self, s: str) -> str:

        n = len(s)
        dp = [ [False]*n for i in range(n)]
        mx = 0
        start = 0
        end = 0

        for i in range(0,n):
            for j in range(0,i+1):
                if s[j] == s[i] and ((i - j - 1) <= 1 or dp[i-1][j+1]== True):
                    dp[i][j] = True
                    if mx < (i - j + 1):
                        mx = i - j + 1
                        start = j
                        end = i
        return s[start: end + 1]

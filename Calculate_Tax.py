# Time Complexity : O(N), where N is the number of tax brackets or levels. 
# Space Complexity : O(1) 
from typing import List

class Solution:
    def calculateTax(self, levels: List[List[float]], salary: float) -> float:
        tax = 0
        prev_limit = 0
        
        for limit, rate in levels:
            if limit is None or salary <= limit:
                tax += (salary - prev_limit) * rate
                break
            else:
                tax += (limit - prev_limit) * rate
                prev_limit = limit
        
        return tax

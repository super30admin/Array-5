"""
Loop through tax brackets in order
For each bracket:
If it has a cap (e.g., 10,000), tax only the portion within that bracket
If None, tax everything remaining
Subtract taxed portion from salary until salary becomes zero
"""
"""
Time Complexity: O(n) — Loop through all tax brackets once
Space Complexity: O(1) — Constant extra variables
"""


from typing import List, Optional

def calculate_tax(levels: List[List[Optional[float]]], salary: float) -> float:
    tax = 0.0
    prev_cap = 0.0

    for cap, rate in levels:
        if cap is None:
            # Tax remaining salary at this rate
            tax += (salary - prev_cap) * rate
            break
        elif salary > cap:
            # Tax only the difference between this cap and previous cap
            tax += (cap - prev_cap) * rate
            prev_cap = cap
        else:
            # Salary is within this bracket
            tax += (salary - prev_cap) * rate
            break

    return tax

if __name__ == "__main__":
    levels = [
        [10000, 0.3],
        [20000, 0.2],
        [30000, 0.1],
        [None,   0.1]
    ]
    print(calculate_tax(levels, 45000)) 

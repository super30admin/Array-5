# // Time Complexity :O(1) always constant, only run 4 times whatever the ip is
# // Space Complexity :O(1) 
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


def calc(level,salary):
    left=salary
    
    taxable=0
    tax=0
    limit=0
    index=0
    prevlimit=0
    
    while left>0:
        l=level[index]
        currthresh=l[0]
        taxrate=l[1]
        if currthresh==None:
            tax+=taxrate*left
            return tax
        taxable=currthresh-prevlimit
        prevlimit=l[0]
        tax+=taxable*taxrate
        left=left-taxable
        limit=currthresh
        index+=1
        print(tax)
    return tax
        
        






levels=[[10000,.1],[20000,.2],[30000,.3],[None,.4]]
print(calc(levels,45000))
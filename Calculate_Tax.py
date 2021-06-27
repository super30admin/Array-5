def calculate_tax(levels,salary):    
    
    tax = 0
    if salary < levels[0][0]:
        return tax
    prev, salaryleft = 0,salary
    i = 0
    while salaryleft > 0:
        #print(tax,salaryleft)
        if not levels[i][0] :
            tax += salaryleft * 0.4
            break
        tax += levels[i][1]  * min( (levels[i][0]- prev) , salaryleft)
        salaryleft -= levels[i][0] - prev
        prev = levels[i][0]
        i+=1  
    return tax

def main():
    levels = [(10000,0.1), (20000,0.2), (30000,0.3), (None,0.4)]
    salary = 5000
    print(calculate_tax(levels,salary))



if __name__ == "__main__":
    main()

class tax(object):
    def __init__(self, income):
        self.level= int(income/10000)+1
        self.income= income 
        print('the taxer level is: ', self.level)


    def end_level_tax(self):
        #fine the money that have to pay in the last level 
        if self.level ==1:
            end_tax=self.income*0.3
        elif  self.level ==2:
            end_tax= (self.income-10000)*0.2
        else:
            end_tax=(self.income-(self.level-1)*10000)*0.1

        return end_tax

    def inter_level_tax(self):
        #find the money that has to pay before the last level

        #if level is 1 then there is no inter level. 
        if self.level ==1:
            inter_tax =0 

        elif self.level ==2:
            inter_tax = 10000*0.3

        else: 
            inter_tax = 10000*0.3 + 10000*0.2 + (10000*0.1)* (self.level-3) # subtrct the first, second and end of level
        print('inter_tax',inter_tax)

        return inter_tax


    def total_tax(self):
        return self.inter_level_tax()+self.end_level_tax()

payer=tax(3000)
print(payer.total_tax())

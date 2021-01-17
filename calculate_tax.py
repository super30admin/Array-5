levels=[[10000,0.1],[20000,0.2],[30000,0.3],[None,0.4]]
## time -O(1)
def pay(levels):
  tax=15000
  summ=0
  left=tax
  for i in levels:
    if i[0]!=None and tax>i[0]:
      summ+=10000*i[1]
      left-=10000
    else:
      summ+=left*i[1]
      return summ
print(pay(levels))
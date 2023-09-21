# Fibonacci Numbers
def fibonacii(num):
    if num<=1:
        return 1
    else:
        return fibonacii(num-1) +  fibonacii(num-2)

nterms = int(input("Enter a number: "))
list=[]
for i in range(nterms):
    list.append(fibonacii(i))
print(list)
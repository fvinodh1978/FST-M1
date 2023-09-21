# Recursive Adder

def recur_sum(num):
    if num <=1:
        return 1
    return num+recur_sum(num-1)

num=int(input("Enter the Number : "))
sum=recur_sum(num)
print(sum)

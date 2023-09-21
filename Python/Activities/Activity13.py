# Adding List Numbers
def sum(nums):
    sum=0
    for num in nums:
        sum=sum+num
    return sum

my_nums=[1, 2, 3, 4, 5, 6]
sum=sum(my_nums)
print("Sum of the Numbers in the List : ", sum)

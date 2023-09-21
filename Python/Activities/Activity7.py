numbers=input("Enter the List of numbers (use , as field Separators) : ").split(",")
sum=0
for i in numbers:
    sum=sum+int(i)
print(sum)

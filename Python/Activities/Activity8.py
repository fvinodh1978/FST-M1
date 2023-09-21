numbers=input("Enter the List of numbers (use , as field Separators) : ").split(",")
sum=0
if numbers[0].strip()==numbers[len(numbers)-1].strip():
    print("Numbers are same")
else:
    print("Numbers are not same")
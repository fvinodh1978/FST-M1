my_tuple=tuple((input("Enter the List of numbers (use , as field Separators) : ").split(",")))

print("List1 : ", my_tuple)
for ele in my_tuple:
    if int(ele)%5==0:
        print(ele)

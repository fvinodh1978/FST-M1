example_dict =	dict(apple="12",mango= "10",banana= 100)
print(example_dict)
myfruit=input("Enter the fruit ")
if myfruit in example_dict.keys():
    print(myfruit + " is Available!!!")
else:
    print(myfruit + " is Not Available!!!")
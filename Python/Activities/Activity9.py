list1=list((1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
list2=[11, 12, 13, 14, 15, 16, 17, 18, 19]
list3=[]

print("List1 : ", list1)
for ele in list1:
    if not ele%2==0:
        list3.append(ele)

print("List2 : ", list2)
for ele in list2:
    if ele%2==0:
        list3.append(ele)
print(list3)
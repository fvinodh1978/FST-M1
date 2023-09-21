player1= input("Enter Player1 Name : ")
player2=input("Enter Player2 Name : ")

p1 = input(player1 + " is Playing : ")
p2 = input(player2 + " is Playing : ")

wins=""
if p1==p2:
    print("Tie")
elif (p1 == "rock"):
      if p2 =="scissors":
        wins=player1
      else:
        wins=player2
elif (p1=="scissors" ):
    if p2 =="paper":
        wins=player1
    else:
        wins=player2
elif (p1=="paper" ):
    if p2 =="rock":
        wins=player1
    else:
        wins=player2
else:
    print("Invalid Input!!!")
print(wins + " wins the Game!!!")


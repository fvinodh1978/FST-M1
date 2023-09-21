# Get the Names of the Players
player1= input("Enter Player1 Name : ")
player2=input("Enter Player2 Name : ")

# Set the list of valid options
options={"rock", "scissors", "paper"}

# Set the Play Again flag to True
play_again=True

# Start the loop, Loop runs till play_Again flag is True
while play_again:
    # Get the Choices from the users
    p1 = input(player1 + " is Playing : ")
    p2 = input(player2 + " is Playing : ")

    # Proceed to Process if users entered valid inputs
    if p1 in options and p2 in options:
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

        # Print the Result
        print(wins + " wins the Game!!!")
    else:
        # If players selects invalid input say Invalid Input
        print("Invalid Input!!!")

    # Check if Players whats to play again
    play_again_flag=input("Play Another Round? Enter Y or N ")
    if not (play_again_flag=="Y" or play_again_flag=='y'):
        play_again=False
else:
    print("Game Over!!!")



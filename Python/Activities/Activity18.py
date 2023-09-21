import pandas as pd
csv_file="C:\\Users\\054544744\\IdeaProjects\\FST Python Project\\resources\\write_to_csv.csv"
data_frame=pd.read_csv(csv_file)

# Print the Name Field
for name in data_frame["Usernames"]:
    print(name)
print("==============================")

# Print the username and password of the second row
print(data_frame["Usernames"][1], data_frame["Passwords"][1])
print("==============================")

# Sort the Usernames column data in ascending order and print data
print(data_frame.sort_values("Usernames", ascending=True))

print("==============================")
# Sort the Passwords column in descending order and print data
print(data_frame.sort_values("Passwords", ascending=False))


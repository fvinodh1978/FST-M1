import pandas as pd

# Read data into a dataframe
xl_file="C:\\Users\\054544744\\IdeaProjects\\FST Python Project\\resources\\profile.xlsx"
excel_data=pd.read_excel(xl_file)
print(excel_data)
print("===========================================")

# Print the number of rows and columns
print("Number of Rows : " , excel_data.shape[0], " Number of Columns : ", excel_data.shape[1])
print("===========================================")

# Print the data in the emails column only
print(excel_data["Email"])
print("===========================================")

# Sort the data based on FirstName in ascending order and print the data
print(excel_data.sort_values("FirstName", ascending=True))
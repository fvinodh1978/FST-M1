import pandas as pd
csv_file="C:\\Users\\054544744\\IdeaProjects\\FST Python Project\\resources\\write_to_csv.csv"
data = {
    "Usernames":["admin","Charles","Deku"],
    "Passwords":["password","Charl13","AllMight"]
}
data_frame=pd.DataFrame(data)
data_frame.to_csv(csv_file, index=False)


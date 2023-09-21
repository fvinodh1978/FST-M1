import pandas as pd

# Initialise the data
excel_data = {
    'FirstName':["Satvik", "Avinash", "Lahri"],
    'LastName':["Shah", "Kati", "Rath"],
    'Email':["satshah@example.com", "avinashK@example.com", "lahri.rath@example.com"],
    'PhoneNumber':["4537829158", "4892184058", "4528727830"]
}

# create a dataframe using the excel data
data_frame=pd.DataFrame(excel_data)

# write to the excel file
xl_file="C:\\Users\\054544744\\IdeaProjects\\FST Python Project\\resources\\profile.xlsx"
writer=pd.ExcelWriter(xl_file)
data_frame.to_excel(writer,  "profile", index=False)

# CLose the writer
writer.close()
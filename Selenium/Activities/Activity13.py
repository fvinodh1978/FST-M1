# Import required packages from selenium
import time

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver using WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Set Explicit wait of 3 Secs
    wait = WebDriverWait(driver, 10)

    # Launch the URL and get the title
    driver.get("https://v1.training-support.net/selenium/tables")
    home_title = driver.title
    print("Title of the Home Page is : {}".format(home_title))

    # Get the number of Rows and Columns in the first table
    table1Rows = driver.find_elements(By.XPATH, "//table[@class='ui celled striped table']/tbody/tr")
    table1Columns = driver.find_elements(By.XPATH, "//table[@class='ui celled striped table']/tbody/tr[1]/td")
    print("First Table : Number of Rows : {}, Number of Columns : {}".format(len(table1Rows), len(table1Columns)))

    # Print the content of 3rd row cell values
    thirdRow = driver.find_elements(By.XPATH, "//table[@class='ui celled striped table']/tbody/tr[3]/td")
    cellCount = 0
    for field in thirdRow:
        print("Value of {} th Cell is : {}".format(cellCount, field.text))
        cellCount = cellCount + 1

    # Get the value of 2nd row 3rd column
    sendRowThirdColumn = driver.find_element(By.XPATH, "//table[@class='ui celled striped table']/tbody/tr[2]/td[3]")
    print("\nValue of 2nd Row 3rd Column is : {}".format(sendRowThirdColumn.text))

    # Wait for 5 Seconds and Close the Browser
    time.sleep(3)
    driver.close()

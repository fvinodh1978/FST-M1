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

    tableRows = driver.find_elements(By.XPATH, "//table[@id='sortableTable']/tbody/tr")
    print("Number of Records of Sortable Table : {}".format(len(tableRows)))

    tableCols = driver.find_elements(By.XPATH, "//table[@id='sortableTable']/tbody/tr[1]/td")
    print("Number of Columns of Sortable Table : {}".format(len(tableCols)))

    cell = driver.find_element(By.XPATH, "//table[@id='sortableTable']/tbody/tr[2]/td[2]")
    print("Text at 2nd row, 2nd column is : {} ".format(cell.text))

    tableheader = driver.find_element(By.XPATH, "//table[@id='sortableTable']/thead/tr/th[1]")
    tableheader.click()

    cell21 = driver.find_element(By.XPATH, "//table[@id='sortableTable']/tbody/tr[2]/td[1]")
    print("Text at 2nd row, 1nd column is : {} ".format(cell21.text))

    tablefotter = driver.find_elements(By.XPATH, "//table[@id='sortableTable']/tfoot/tr/th")
    for footer in tablefotter:
        print(footer.text)

    # Wait for 5 Seconds and Close the Browser
    time.sleep(3)
    driver.close()

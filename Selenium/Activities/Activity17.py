# Import required packages from selenium
import time

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver using WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Set Explicit wait of 3 Secs
    wait = WebDriverWait(driver, 10)

    # Launch the URL and get the title
    driver.get("https://v1.training-support.net/selenium/selects")
    home_title = driver.title
    print("Title of the Home Page is : {}".format(home_title))

    # Get the Handle of Dropdown
    dropDown = driver.find_element(By.XPATH, "//select[@id='single-select']")
    dropDownHandle = Select(dropDown)

    # Select 2nd Option by Visible Text
    time.sleep(3)
    dropDownHandle.select_by_visible_text("Option 2")

    # Select 2nd Option by Value
    time.sleep(3)
    dropDownHandle.select_by_value("4")

    # Get the Options from the Dropdown into a List and Print the items
    items = dropDownHandle.options
    for item in items:
        print(item.text)

    # Wait for 3 Seconds and Close the Browser
    time.sleep(3)
    driver.close()

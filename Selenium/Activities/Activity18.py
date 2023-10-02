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

    # Get the Multi Select Options
    optionSelect = driver.find_element(By.ID, "multi-select")
    multiSelect = Select(optionSelect)

    # Select items
    multiSelect.select_by_visible_text("Javascript")
    multiSelect.select_by_index(4)
    multiSelect.select_by_index(5)
    multiSelect.select_by_index(6)
    multiSelect.select_by_value("node")

    # Deselect item @ 5th index
    multiSelect.deselect_by_index(5)

    # Wait for 3 Seconds and Close the Browser
    time.sleep(3)
    driver.close()

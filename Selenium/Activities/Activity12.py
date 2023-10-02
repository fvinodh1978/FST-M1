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
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    home_title=driver.title
    print ("Title of the Home Page is : {}".format(home_title))

    # Check if checkbox is Selected
    textField = driver.find_element(By.ID, "input-text")
    print("Checkbox is Visible : {}".format(textField.is_enabled()))

    # find and click Enable Input Button
    enableInput = driver.find_element(By.ID, "toggleInput")
    enableInput.click()

    # Check if checkbox is Selected
    print("Checkbox is Visible : {}".format(textField.is_enabled()))

    # Wait for 5 Seconds and Close the Browser
    time.sleep(3)
    driver.close()

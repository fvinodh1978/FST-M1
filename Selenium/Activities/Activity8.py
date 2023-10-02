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

    # Check if the Dynamic Checkbox is displayed
    check_box = driver.find_element(By.ID, "dynamicCheckbox")
    print("Dynamic Checkbox Exists : {}".format(check_box.is_displayed()))

    # Click the toggle Button
    toggle_button = driver.find_element(By.ID, "toggleCheckbox")
    toggle_button.click()

    # Wait till the checkbox disappears
    wait.until(expected_conditions.invisibility_of_element(check_box))

    # Check if the Dynamic Checkbox is disappeared
    print("Dynamic Checkbox Exists : {}".format(check_box.is_displayed()))

    # Click the toggle Button Again
    toggle_button.click()

    # Check if the Dynamic Checkbox is disappeared
    print("Dynamic Checkbox Exists : {}".format(check_box.is_displayed()))

    # Wait for 5 Seconds and Close the Browser
    time.sleep(3)

    # Close the Browser
    driver.close()

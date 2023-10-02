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
    driver.get("https://v1.training-support.net/selenium/javascript-alerts")
    home_title = driver.title
    print("Title of the Home Page is : {}".format(home_title))

    # find and click the confirm button
    confirmButton = driver.find_element(By.ID, "prompt")
    confirmButton.click()

    # Wait till the alert shows up
    wait.until(expected_conditions.alert_is_present())

    # Switch focus to alert and print the alert message
    confirmAlert = driver.switch_to.alert
    print("Confirmation Alert Message : " + confirmAlert.text)

    time.sleep(2)
    confirmAlert.send_keys("Awesome")
    # Wait for 1 Second and click accept
    time.sleep(2)

    # Click Ok and close Alert
    confirmAlert.accept()

    # Wait for 3 Seconds and Close the Browser
    time.sleep(3)
    driver.close()

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
    driver.get("https://v1.training-support.net/selenium/ajax")
    home_title=driver.title
    print ("Title of the Home Page is : {}".format(home_title))

    # Get the change Button and Click on it
    changeButton = driver.find_element(By.CSS_SELECTOR, "button.ui.violet.button")
    changeButton.click()

    dynamic_text = driver.find_element(By.TAG_NAME, "h1")

    # Wait till the Hello! appears and print it
    wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME, "h1"), "HELLO!"))
    print("Dynamic Text : " + dynamic_text.text)

    # Wait till the I'm Late! appears and print it
    wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME, "h3"), "I'm late!"))

    lateText = driver.find_element(By.TAG_NAME, "h3")
    print("Dynamic Text : " + lateText.text)

    # Wait for 5 Seconds and Close the Browser
    time.sleep(3)
    driver.close()

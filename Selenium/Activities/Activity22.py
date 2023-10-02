# Import required packages from selenium
import time

from actions import Actions
from selenium import webdriver
from selenium.webdriver import ActionChains
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
    driver.get("https://v1.training-support.net/selenium/popups")
    home_title = driver.title
    print("Title of the Home Page is : {}".format(home_title))

    # Locate the Sign In Button
    signInButton = driver.find_element(By.CSS_SELECTOR, "button.ui.huge.inverted.orange.button")

    # Build Actions to hover over the sign in button
    builder = ActionChains(driver)
    builder.move_to_element(signInButton).perform()

    # Print the tool tip Message
    print(signInButton.get_attribute("data-tooltip"))

    # CLick the SignIn Button
    signInButton.click()

    # Location the username and password Text Box and click Submit
    userTextBox = driver.find_element(By.ID, "username")
    passTextBox = driver.find_element(By.ID, "password")
    userTextBox.send_keys("admin")
    passTextBox.send_keys("password")

    loginInButton = driver.find_element(By.XPATH, "//button[text()='Log in']")
    loginInButton.click()

    # Locate the Login Confirmation Message
    confirmationMessage = driver.find_element(By.ID, "action-confirmation")
    print("Login Confirmation Message is : "+ confirmationMessage.text)


    # Wait for 3 Seconds and Close the Browser
    time.sleep(3)
    driver.close()

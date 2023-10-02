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
    driver.get("https://v1.training-support.net/selenium/dynamic-attributes")
    home_title = driver.title
    print("Title of the Home Page is : {}".format(home_title))

    # Username/Password Textbox and Enter the username/password
    userTextBox= driver.find_element(By.XPATH, "//input[contains(@class, '-username')]")
    passwordTextBox= driver.find_element(By.XPATH, "//input[contains(@class, '-password')]")
    confirmPasswordTextBox= driver.find_element(By.XPATH, "//label[text()='Confirm Password']/parent::div/input")
    emailTextBox= driver.find_element(By.XPATH, "//input[starts-with(@name, 'email-')]")
    userTextBox.send_keys("admin")
    passwordTextBox.send_keys("password")
    confirmPasswordTextBox.send_keys("password")
    emailTextBox.send_keys("f.vinodhfranklin@gmail.com")

    # Click on Login Button
    signUp = driver.find_element(By.XPATH, "//button[text()='Sign Up']")
    signUp.click()

    # Wait for the Confirmation Message
    confirmationText = driver.find_element(By.XPATH, "//div[@id='action-confirmation']")
    wait.until(expected_conditions.text_to_be_present_in_element((By.XPATH, "//div[@id='action-confirmation']"), "Thank you for registering, admin"))

    # Print the Confirmation Message
    print("Conformation Message : " + confirmationText.text)

    # Wait for 5 Seconds and Close the Browser
    time.sleep(3)
    driver.close()

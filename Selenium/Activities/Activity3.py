# Import required packages from selenium

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver using WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:

    # Launch the URL and get the title
    driver.get("https://v1.training-support.net/selenium/login-form")
    home_title=driver.title
    print ("Title of the Home Page is {}".format(home_title))

    # get the username textbox and type admin
    user_textbox=driver.find_element(By.XPATH, "//input[@id= 'username']")
    user_textbox.send_keys("admin")

    # get the password textbox and type password
    pass_textbox=driver.find_element(By.XPATH, "//input[@name= 'Password']")
    pass_textbox.send_keys("password")

    # get the Submit Button and click on it
    submit_button=driver.find_element(By.XPATH, "//button[text()= 'Log in']")
    submit_button.click()

    # Get the confirmation Text
    confirmation=driver.find_element(By.XPATH, "//div[@id= 'action-confirmation']")
    print("Confirmation Page : " + confirmation.text)

    # CLose the Browser
    driver.close()
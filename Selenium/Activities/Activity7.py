# Import required packages from selenium
import time

from selenium import webdriver
from selenium.webdriver import ActionChains, Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver using WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:


    # Set Implicit wait of 10 Secs
    driver.implicitly_wait(10)

    # Launch the URL and get the title
    driver.get("https://v1.training-support.net/selenium/drag-drop")
    home_title=driver.title
    print ("Title of the Home Page is : {}".format(home_title))

    # Get the Webelement of source and destination
    ball = driver.find_element(By.ID, "draggable")
    zone1 = driver.find_element(By.ID, "droppable")
    zone2 = driver.find_element(By.ID, "dropzone2")

    # Initialise the actions
    builder = ActionChains(driver)

    # Build the action for drag and drop to zone1
    builder.click_and_hold(ball).move_to_element(zone1).release().perform()

    # Verify if the Ball is dropped to Drop Zone1 --Verify if the P tag changes to Dropped
    zone1_status = driver.find_element(By.XPATH, "//div[@id='droppable']/p")
    if "Dropped" in zone1_status.text:
        print("Ball is Dropped to Drop Zone1")
    else:
        print("Ball is Not Dropped!")


    # Build the action for drag and drop to zone1
    builder.click_and_hold(ball).move_to_element(zone2).release().perform()

    # Verify if the Ball is dropped to Drop Zone1 --Verify if the P tag changes to Dropped
    zone2_status = driver.find_element(By.XPATH, "//div[@id='dropzone2']/p")
    if "Dropped" in zone2_status.text:
        print("Ball is Dropped to Drop Zone2")
    else:
        print("Ball is Not Dropped!")

    # Wait for 5 Seconds and Close the Browser
    time.sleep(3)

    # Close the Browser
    driver.close()

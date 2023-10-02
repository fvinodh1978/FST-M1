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
    driver.get("https://v1.training-support.net/selenium/tab-opener")
    home_title = driver.title
    print("Title of the Home Page is : {}".format(home_title))

    # Click on Multitab launcher Button
    tabLauncher = driver.find_element(By.ID, "launcher")
    homeWindow = driver.current_window_handle
    print("Home Window : " + homeWindow)
    tabLauncher.click()
    wait.until(expected_conditions.number_of_windows_to_be(2))

    openWindows = driver.window_handles
    print("Open Windows : " + str(openWindows))
    new_window = ""
    for openWindow in openWindows:
        if not (openWindow == homeWindow):
            driver.switch_to.window(openWindow)
            wait.until(expected_conditions.title_contains("Newtab"))

    # Print the Current Window and the title of the page
    print("Current Window is :" + driver.current_window_handle)
    print("Current Page title : " + driver.title)

    # Wait for 3 Seconds and Close the Browser
    time.sleep(3)
    driver.close()

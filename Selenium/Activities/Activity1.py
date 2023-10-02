# Import required packages from selenium

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver using WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
driver=webdriver.Firefox(service=service)

# Launch the URL and get the title
driver.get("https://v1.training-support.net/")
home_title=driver.title
print ("Title of the Home Page is {}".format(home_title))

# get the aboutus link, click on it and get the aboutus page title
aboutus_link=driver.find_element(By.ID, "about-link")
aboutus_link.click()
aboutus_title=driver.title
print ("Title of the aboutus Page is {}".format(aboutus_title))

# CLose the Browser
driver.close()
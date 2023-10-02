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
    driver.get("https://v1.training-support.net/selenium/target-practice")
    home_title=driver.title
    print ("Title of the Home Page is : {}".format(home_title))

    # Find and get the header3 text
    header3=driver.find_element(By.XPATH, "//h3[@id='third-header']")
    header3_text= header3.text
    print ("Header3 text : " + header3_text)

    # Find and get the header5 color
    header5=driver.find_element(By.XPATH, "//h5[text()='Fifth header']")
    header5Color= header5.value_of_css_property("color")
    print("Header5 Color : {}".format(header5Color))

    # Find and get the Text of Violet Button
    violetButton=driver.find_element(By.XPATH, "//button[text()='Violet']")
    violetButtonClasses= violetButton.get_attribute("class")
    print("Violet Button Class : " + violetButtonClasses)

    # Find and get the Text of Grey Button
    greyButton=driver.find_element(By.XPATH, "//button[text()='Grey']");
    greyButtonColor= greyButton.text
    print("Grey Button Color : " + greyButtonColor)

    # CLose the Browser
    driver.close()
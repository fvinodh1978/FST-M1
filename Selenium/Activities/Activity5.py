# Import required packages from selenium
from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver using WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:

    # Launch the URL and get the title
    driver.get("https://v1.training-support.net/selenium/input-events")
    home_title=driver.title
    print ("Title of the Home Page is : {}".format(home_title))

    # Build Left click action and execute it
    myActions = ActionChains(driver)
    myActions.click().perform()

    # Print the text on active side of dice
    dice = driver.find_element(By.CLASS_NAME, "active")
    diceText = dice.text
    print("Dice text, With left click : {} ".format(diceText))

    # Build double click action and execute it
    myActions.double_click().perform()

    # Print the text on active side of dice
    dice = driver.find_element(By.CLASS_NAME,"active")
    diceText = dice.text
    print("Dice text, With double click : {} ".format(diceText))

    # Build Right click action and execute it
    myActions.context_click().perform()

    # Print the text on active side of dice
    dice = driver.find_element(By.CLASS_NAME,"active")
    diceText = dice.text
    print("Dice text, With right click : {} ".format(diceText))

    # Close the Browser
    driver.close()

# Import required packages from selenium
from selenium import webdriver
from selenium.webdriver import ActionChains, Keys
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

    # Initialize Actions
    myActions = ActionChains(driver)

    # Build and Execute send Capital letter V
    myActions.send_keys("V").perform()

    # Build actions to select and copy(control a + c)
    myActions.key_down(Keys.CONTROL).send_keys("a").send_keys("c").key_up(Keys.CONTROL).perform()

    # Close the Browser
    driver.close()

# Import required packages from selenium
import time

import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait


class TestClass():

    def test_logins(self, my_fixture):
        # Initialise Driver
        driver = my_fixture
        url = 'https://alchemy.hguy.co/jobs/wp-admin'
        driver.get(url)

        # Initialise Wait for 10 secs
        wait = WebDriverWait(driver, 10)

        userTextBox = driver.find_element(By.ID, "user_login")
        userPassBox = driver.find_element(By.ID, "user_pass")
        submitButton = driver.find_element(By.ID, "wp-submit")

        userTextBox.send_keys("root")
        userPassBox.send_keys("pa$$w0rd")
        submitButton.click()

        loginMsg = driver.find_element(By.XPATH, "//li[@id='wp-admin-bar-my-account']/a/span")
        assert "root" == loginMsg.text

        time.sleep(3)

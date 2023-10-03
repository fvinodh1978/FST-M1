# Import required packages from selenium
import time

import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait


class TestClass():

    def test_verify_header_text(self, my_fixture):

        # Initialise Driver
        driver = my_fixture
        url = 'https://alchemy.hguy.co/jobs'
        driver.get(url)

        # Initialise Wait for 10 secs
        wait = WebDriverWait(driver, 10)

        # Find and Click the Jobs Link
        jobs_link = driver.find_element(By.ID, "menu-item-24")
        jobs_link.click()

        # Search for Banking Jobs
        searchJob = driver.find_element(By.XPATH, "//input[@id='search_keywords']")
        searchButton = driver.find_element(By.XPATH, "//input[@type='submit']")
        searchJob.send_keys("Banking")
        searchButton.click()

        # Wait for the Visibility of the Banking Job and click on it
        wait.until(expected_conditions.visibility_of_element_located((By.XPATH, "//div[@class='job_listings']/ul/li[1]/a")))
        jobName = driver.find_element(By.XPATH, "//div[@class='job_listings']/ul/li[1]/a")
        jobName.click()

        # Apply for the Job
        applyButton = driver.find_element(By.XPATH, "//input[@class='application_button button']")
        applyButton.click()

        # Print the Confirmation email and Print it
        confirmMsg = driver.find_element(By.XPATH, "//a[@class='job_application_email']")
        email = confirmMsg.text
        print("Email Id is : " + email)


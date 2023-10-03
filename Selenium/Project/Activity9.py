# Import required packages from selenium
import time

import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait


class TestClass():

    def test_create_job_listings(self, my_fixture):
        # Initialise Driver
        driver = my_fixture
        url = 'https://alchemy.hguy.co/jobs/wp-admin'
        driver.get(url)

        # Initialise Wait for 10 secs
        wait = WebDriverWait(driver, 10)

        # Find user/password textbox and login
        userTextBox = driver.find_element(By.ID, "user_login")
        userPassBox = driver.find_element(By.ID, "user_pass")
        submitButton = driver.find_element(By.ID, "wp-submit")

        userTextBox.send_keys("root")
        userPassBox.send_keys("pa$$w0rd")
        submitButton.click()

        # Get the job listings
        jobListings = driver.find_element(By.XPATH, "//li[@id='menu-posts-job_listing']/a/div[3]")
        jobListings.click()

        # Get the count of job listings and print the count
        jobListings = driver.find_element(By.XPATH, "//a[@class='current']/span")
        jobsCount = ''.join(filter(lambda i: i.isdigit(), jobListings.text))
        print("Number of Jobs before Add : " + jobsCount)

        # Add a new Job to the List
        addNew = driver.find_element(By.XPATH, "//div[@id='wpbody-content']/div[4]/a")
        addNew.click()
        time.sleep(2)

        # Fill up the New Job form
        modal = driver.find_element(By.XPATH, "//button[@aria-label='Close dialog']")
        modal.click()

        jobPosition = driver.find_element(By.XPATH, "//textarea[@id='post-title-0']")
        jobPosition.send_keys("Data Analyst")

        jobLocation = driver.find_element(By.ID, "_job_location")
        jobLocation.send_keys("USA")

        companyName = driver.find_element(By.ID, "_company_name")
        companyName.send_keys("IBM")

        # Publish the new job Posting
        publishButton = driver.find_element(By.XPATH, "//div[@class='edit-post-header__settings']/button[2]")
        publishButton.click()

        publishConfirmButton = driver.find_element(By.XPATH, "//div[@class='editor-post-publish-panel']/div/div/button")
        publishConfirmButton.click()
        time.sleep(2)
        driver.back()

        jobListingsConfirm = driver.find_element(By.XPATH, "//li[@id='menu-posts-job_listing']/a/div[3]")
        jobListingsConfirm.click()

        # Get the count of job listings and print the count
        jobListings = driver.find_element(By.XPATH, "//a[@class='current']/span")
        newJobsCount = ''.join(filter(lambda i: i.isdigit(), jobListings.text))
        print("Number of Jobs before Add : " + newJobsCount)

        assert int(newJobsCount) == int(jobsCount) + 1
        time.sleep(2)

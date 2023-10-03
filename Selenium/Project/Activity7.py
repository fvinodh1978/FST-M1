# Import required packages from selenium
import time

import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait


class TestClass():

    def test_apply_jobs(self, my_fixture):
        # Initialise Driver
        driver = my_fixture
        url = 'https://alchemy.hguy.co/jobs'
        driver.get(url)

        # Initialise Wait for 10 secs
        wait = WebDriverWait(driver, 10)

        # Find and click the post a job Link
        postJobsLink = driver.find_element(By.ID, "menu-item-26")
        postJobsLink.click()

        # Find and enter email
        email = driver.find_element(By.ID, "create_account_email")
        email.send_keys("vfrankli12@in.ibm.com")

        # Find and enter Job Title
        jobTitle = driver.find_element(By.ID, "job_title")
        jobTitle.send_keys("DataAnalyst")

        # Enter Job Location
        location = driver.find_element(By.ID, "job_location")
        location.send_keys("USA")

        # Enter Job TItle
        jobType = driver.find_element(By.XPATH, "//select[@id='job_type']")
        dropDownHandle = Select(jobType)
        dropDownHandle.select_by_visible_text("Part Time")

        # Switch to latest Window
        myHandles = driver.window_handles
        for myHandle in myHandles:
            driver.switch_to.window(myHandle)
            print(myHandle)
            time.sleep(2)

        # Switch to the iframe for entering the Job Description
        myIframe = driver.find_element(By.XPATH, "//iframe[@id='job_description_ifr']")
        driver.switch_to.frame(myIframe)

        # Wait until the Description Element is active
        wait.until(
            expected_conditions.element_to_be_clickable(driver.find_element(By.XPATH, "//body[@id='tinymce']/p")))

        # FInd and Enter Job Description
        description = driver.find_element(By.XPATH, "//body[@id='tinymce']/p")
        driver.execute_script("arguments[0].textContent = arguments[1]", description, "This is a test")
        time.sleep(5)

        # After Entering the Description, switch back to default content
        driver.switch_to.default_content()

        # Enter Application
        application = driver.find_element(By.ID, "application")
        application.send_keys("f.vinodhfranklin@gmail.com")

        # Enter the Company Name
        companyName = driver.find_element(By.XPATH, "//input[@id='company_name']")
        companyName.send_keys("IBM")

        # Enter the Company Website
        companySite = driver.find_element(By.XPATH, "//input[@id='company_website']")
        companySite.send_keys("www.ibm.com")

        # Preview Job Posting
        previewButton = driver.find_element(By.XPATH, "//input[@name='submit_job']")
        previewButton.click()

        # Post the Job
        submitButton = driver.find_element(By.XPATH, "//input[@id='job_preview_submit_button']")
        submitButton.click()

        # Find and click the post a job Link
        jobs = driver.find_element(By.ID, "menu-item-24")
        jobs.click()

        # Click Job Listings
        jobsList = driver.find_element(By.XPATH, "//li[@id='menu-item-24']/a")
        jobsList.click()

        # Check the Posted Job Exists in the list
        searchText = driver.find_element(By.XPATH, "//input[@id='search_keywords']")
        searchText.send_keys("DataAnalyst")

        # Enter the Job Location
        searchLocation = driver.find_element(By.XPATH, "//input[@id='search_location']")
        searchLocation.send_keys("USA")

        # Search the Jobs
        search_jobs_button = driver.find_element(By.XPATH, "//div[@class='search_submit']/input")
        search_jobs_button.click()

        wait.until(expected_conditions.visibility_of_element_located((By.XPATH, "//ul[@class='job_listings']/li")))

        # Get the job Listings and get the count
        jobListings = driver.find_elements(By.XPATH, "//ul[@class='job_listings']/li")
        jobCount = len(jobListings)

        time.sleep(3)
        assert jobCount == 1

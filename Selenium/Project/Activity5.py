# Import required packages from selenium
import time

import pytest
from selenium.webdriver.common.by import By


class TestClass():

    def test_verify_header_text(self, my_fixture):
        driver = my_fixture
        url = 'https://alchemy.hguy.co/jobs'
        driver.get(url)

        # Find and Click the Job Link
        jobs_link = driver.find_element(By.ID, "menu-item-24")
        jobs_link.click()
        time.sleep(3)

        # Get the page title and compare
        expected_title="Jobs – Alchemy Jobs"
        actual_title= driver.title
        assert expected_title == actual_title

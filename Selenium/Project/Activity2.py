# Import required packages from selenium
import pytest
from selenium.webdriver.common.by import By


class TestClass():

    def test_header_text(self, my_fixture):
        driver = my_fixture
        url = 'https://alchemy.hguy.co/jobs'
        driver.get(url)
        expected_header = 'Welcome to Alchemy Jobs'
        actual_header = driver.find_element(By.CLASS_NAME, "entry-title").text
        assert actual_header == expected_header

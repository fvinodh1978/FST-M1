# Import required packages from selenium
import pytest
from selenium.webdriver.common.by import By


class TestClass():

    def test_verify_header_text(self, my_fixture):
        driver = my_fixture
        url = 'https://alchemy.hguy.co/jobs'
        driver.get(url)
        expected_header = 'Quia quis non'
        actual_header = driver.find_element(By.XPATH, "//h2").text
        assert actual_header == expected_header

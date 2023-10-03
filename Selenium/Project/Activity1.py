# Import required packages from selenium
import pytest


class TestClass():

    def test_verify_title(self, my_fixture):
        driver = my_fixture
        url = 'https://alchemy.hguy.co/jobs'
        driver.get(url)
        expected_title = 'Alchemy Jobs – Job Board Application'
        actual_title = driver.title
        assert expected_title == actual_title

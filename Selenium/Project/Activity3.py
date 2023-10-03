# Import required packages from selenium
import pytest
from selenium.webdriver.common.by import By


class TestClass():

    def test_verify_header_image(self, my_fixture):
        driver = my_fixture
        url = 'https://alchemy.hguy.co/jobs'
        driver.get(url)
        expected_image = 'https://alchemy.hguy.co/jobs/wp-content/uploads/2019/09/career-corporate-job-776615-e1569782235456-1024x271.jpg'
        header_image = driver.find_element(By.XPATH, "//img[@class='attachment-large size-large wp-post-image']")
        actual_image = header_image.get_attribute("src")
        print("Image Source is : " + actual_image)
        assert actual_image == expected_image

import time

from selenium import webdriver
from selenium.webdriver.common.by import By
import pytest

driver = webdriver.Chrome()


@pytest.fixture
def var_url():
    url = "https://the-internet.herokuapp.com/"
    return url


def test_launch_app(var_url):
    driver.maximize_window()
    driver.get(var_url)
    driver.implicitly_wait(10)


def test_verify_page_title():
    page_title = driver.title
    assert page_title == "The Internet"
    print("Page Title:", page_title, "verified successfully!")


def test_checkboxes_link():
    checkboxes_link_element = driver.find_element(By.XPATH, "//li//a[contains(text(),'Checkboxes')]")
    checkboxes_link_element.click()
    page_text_element = driver.find_element(By.XPATH, "(//div[@id='content']//h3)[1]")
    get_text_from_page = page_text_element.text
    assert get_text_from_page == "Checkboxes"
    print("Page Text:", get_text_from_page, "verified successfully!")
    table = []
    checkboxes_link_element = driver.find_elements(By.XPATH, "//*[@id='checkboxes']//input")
    checkbox_dictionary = {
        "checkbox 1": "None",
        "checkbox 2": "true"
    }
    i = 1
    for element in checkboxes_link_element:
        table.append(element.get_attribute('checked'))
        table_text = table.pop()
        assert checkbox_dictionary["checkbox " + str(i)] == str(table_text)
        print("checkbox " + str(i) + " status:", checkbox_dictionary["checkbox " + str(i)])
        i = i + 1


def test_file_upload_link():
    time.sleep(3)
    driver.back()
    file_upload_link_element = driver.find_element(By.XPATH, "//li//a[contains(text(),'File Upload')]")
    file_upload_link_element.click()
    time.sleep(3)
    page_text_element = driver.find_element(By.XPATH, "(//div[@id='content']//h3)[1]")
    get_text_from_page = page_text_element.text
    assert get_text_from_page == "File Uploader"
    print("Page Text:", get_text_from_page, "verified successfully!")
    choose_file_element = driver.find_element(By.XPATH, "//input[@id='file-upload']")
    doc_path = "C:/Users/SANGEETHA/pycharm_workspace/InternetHerokuappProject/Attachments/Test_doc.docx"
    choose_file_element.send_keys(doc_path)
    time.sleep(3)
    choose_file_element = driver.find_element(By.XPATH, "//input[@id='file-submit']")
    choose_file_element.click()
    time.sleep(3)
    file_upload_status_element = driver.find_element(By.XPATH, "(//div[@id='content']//h3)[1]")
    get_text_file_upload = file_upload_status_element.text
    assert get_text_file_upload == "File Uploaded!"
    print("File upload status:", get_text_file_upload)


def test_close_browser():
    driver.quit()

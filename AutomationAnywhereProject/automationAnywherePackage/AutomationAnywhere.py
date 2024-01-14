import time

from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By

url = "https://www.automationanywhere.com/"
driver = webdriver.Chrome()


def test_launch_app():
    driver.maximize_window()
    driver.get(url)
    driver.implicitly_wait(10)


def test_accept_cookies():
    # time.sleep(3)
    cookie_element = driver.find_element(By.XPATH, "//button[text()='Accept All Cookies']")
    cookie_element.click()
    time.sleep(3)


def test_select_product_from_menu():
    action = ActionChains(driver)
    menu_element = driver.find_element(By.XPATH, "//a[text()='Products']")
    action.move_to_element(menu_element).perform()
    time.sleep(2)
    child_element = driver.find_element(By.XPATH, "(//a[text()='Process Discovery'])[2]")
    action.click(child_element).perform()
    time.sleep(2)


def test_verify_process_discovery_url():
    url_to_verify = "https://www.automationanywhere.com/products/process-discovery"
    current_url = driver.current_url
    print("Current Url: ", current_url)
    is_equal = (current_url == url_to_verify)
    assert url_to_verify == current_url
    print("Process discovery Url verified successfully!")

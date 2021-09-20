import time
from selenium import webdriver
from selenium.webdriver.chrome.options import Options



options = Options()
options.add_argument('--profile-directory=Profile 1')
options.add_argument("user-data-dir=C:\\Users\\Hana\\AppData\\Local\\Google\\Chrome\\User Data\\") #Path to your chrome profile
driver = webdriver.Chrome(executable_path="C:\\chromedriver.exe", options=options)

driver.get('http://www.google.com/')
time.sleep(2) # Let the user actually see something!
search_box = driver.find_element_by_name('q')
search_box.send_keys('ChromeDriver')
search_box.submit()
time.sleep(30) # Let the user actually see something!
driver.close()
driver.quit()
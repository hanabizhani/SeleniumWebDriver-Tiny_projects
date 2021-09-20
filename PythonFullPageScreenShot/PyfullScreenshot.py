import os
import time
from selenium import webdriver
from Screenshot import Screenshot_Clipping


chromedriver = "c:/chromedriver.exe"
os.environ["webdriver.chrome.driver"] = chromedriver
driver = webdriver.Chrome(chromedriver)
url = 'https://stackoverflow.com'

driver.maximize_window()

driver.get(url)
time.sleep(2)

obj=Screenshot_Clipping.Screenshot()
image=obj.full_Screenshot(driver,save_path=r'd:/',image_name="Screenshot_stack.png")
    
driver.quit()
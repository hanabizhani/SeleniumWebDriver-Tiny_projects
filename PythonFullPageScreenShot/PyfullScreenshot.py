import os
import time
from selenium import webdriver
from Screenshot import Screenshot_Clipping


chromedriver = "c:/chromedriver.exe"
os.environ["webdriver.chrome.driver"] = chromedriver
obj=Screenshot_Clipping.Screenshot()

driver = webdriver.Chrome(chromedriver)
url = 'https://stackoverflow.com'

driver.maximize_window()

driver.get(url)
time.sleep(2)

image=obj.full_Screenshot(driver,save_path=r'.',image_name="MyImg.png")
    
driver.close()
driver.quit()
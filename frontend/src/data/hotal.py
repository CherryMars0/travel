from selenium import webdriver
import time,re
browser=webdriver.Chrome()
url='http://hotel.qunar.com/cn/zhenjiang/?fromDate=2020-05-18&toDate=2020-05-19&cityName=%E9%95%87%E6%B1%9F'
browser.get(url)
time.sleep(5)
p0=r'<p class="price_new"><a href="(.*?)"><span'
r0=re.compile(p0)
html=browser.page_source
hotells=r0.findall(html)

text_url=url+i
dirver.get(text_url)
time.sleep(6)
html2=dirver.page_source
p1=r'</p><div class="name_cont">(.*?)</p></div>'    # 酒店名称和地址
p1name=r'<p class="name">(.*?)<span class="type"'  # 酒店名称
p1add1=r'<p class="addr">(.*?)<span'            # 酒店地址1
p1add2=r']</span>(.*?)<span class="map">'        # 酒店地址2
p2=r'<div class="hotel_desc">(.*?)</div></aside>'       # 酒店详情
p2cont=r'联系方式</dt><dd class="cont">(.*?)</dd>'     # 联系方式
p2item=r'</span><span class="item">(.*?)</span></dd>'      # 基本信息(多少间房)
p2words=r'<div class="words(.*?)</p></div>' # 酒店简介
r1=re.compile(p1)
r1name=re.compile(p1name)
r1add=re.compile(p1add1)
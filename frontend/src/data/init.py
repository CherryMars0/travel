import json

with open("./items_prvce.json",encoding='utf-8') as f:
    data = json.load(f)

import pymysql
conn = pymysql.connect(host='localhost', user='root', password='9091', db='marvelous')
cursor = conn.cursor()
for item in data:
    sql = "INSERT INTO scenics (name, img, \
    area, price, point,id,hot,intro,link,address,level,sold) \
    VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)"
    cursor.execute(sql, 
                   (item['name'], item['img'], item['area'], item['price'], 
                    item['point'], item['id'], item['hot'], 
                    item['intro'], item['link'], item['address'], 
                    item['level'], item['sold']))

conn.commit()
cursor.close()
conn.close()
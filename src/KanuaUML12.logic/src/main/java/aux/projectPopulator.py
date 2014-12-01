# -*- coding: utf-8 -*-
import random

database = []

database.append(
	{
		'image' : 'https://coderdojo.com/wp-content/uploads/2014/11/hacksummit.png',
		'info' : 'Featuring programming language creators, open-source contributors, and thought leaders',
		'link' : 'https://hacksummit.org/',
		'name' : 'HackSummit'
	})

def get_date():

	years = range(2011, 2015)
	months = range(1, 13)
	days = range(1, 28)

	ans = ''

	ans += str(random.choice(years)) + '-' 
	ans += str(random.choice(months)) + '-' 
	ans += str(random.choice(days))

	return ans

def main():

	file_object = open('events.sql', 'w')

	for itm in database:

		itm_id = random.randint(0, 1000)
		itm_dte = get_date()
		itm_img = itm['image']
		itm_ifo = itm['info']
		itm_ifo = (itm_ifo[:250] + '..') if len(itm_ifo) > 250 else itm_ifo
		itm_lnk = imt['link']
		itm_nme = itm['name']
		itm_pub = get_date()
		itm_ttl = itm_nme

		query = ''
		query += 'INSERT INTO APP.CHARLAENTITY VALUES '
		query += '('
		query += str(itm_id) + ', '
		query += '\'' + itm_dte + '\', '
		query += '\'' + itm_img + '\', '
		query += '\'' + itm_ifo + '\', '
		query += '\'' + itm_lnk + '\', '
		query += '\'' + itm_nme + '\', '
		query += '\'' + itm_pub + '\', '
		query += '\'' + str(itm_ttl) + '\''
		query += ');'
		file_object.write(query + '\n')

main()
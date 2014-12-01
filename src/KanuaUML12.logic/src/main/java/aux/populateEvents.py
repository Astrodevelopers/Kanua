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

database.append(
	{
		'image' : 'http://sistemas.uniandes.edu.co/ie/images/articulos/eventos/Tras%20la%20pista%20de%20un%20GIGANTE.png',
		'info' : 'Muchas veces cuando hablamos de nuestros sueños, nuestras metas y nuestras ideas nos dicen locos. Ese es el primer síntoma de que vamos por bueno camino.Como todo, la locura no necesariamente se puede volver algo racional, pero con ganas y esfuerzo definitivamente tener la cabeza en las nubes a veces es una buena manera de empezar. Gracias a la locura de dos brillantes y talentosas personas, Juan Sebastián Henao y Darwin Tusarma, es que hoy podemos decir que vamos por Google.',
		'link' : 'http://sistemas.uniandes.edu.co/ie/index.php/acerca-de/9-eventos/40-gyffu',
		'name' : 'Gyffu'
	})

database.append(
	{
		'image' : 'http://sistemas.uniandes.edu.co/ie/images/articulos/eventos/CASOSDEEMPRENDIMIENTOS.JPG',
		'info' : 'Si está interesado en iniciar un emprendimiento pero tiene dudas si el momento actual es el adecuado lo invitamos a la charla Casos de Emprendimientos Uniandinos.',
		'link' : 'http://sistemas.uniandes.edu.co/ie/index.php/acerca-de/9-eventos/34-casos-uniandinos-de-emprendimiento',
		'name' : 'Casos Uniandinos de Emprendimiento'
	})

database.append(
	{
		'image' : 'https://d29xw0ra2h4o4u.cloudfront.net/assets/logo-no-text-a2a8595cdb277652f9f526f586f29f7f.png',
		'info' : 'Hacker School is a retreat for programmers.',
		'link' : 'https://www.hackerschool.com/',
		'name' : 'Hacker School'
	})

database.append(
	{
		'image' : 'http://tinytorch.com/wp-content/uploads/2014/05/Facebook-F8.jpg',
		'info' : 'Facebook F8 (pronounced "eff eight") is a mostly-annual conference held by Facebook, intended for developers and entrepreneurs who build products and services around the website. It takes place in San Francisco, California.[1] Previous events have started with a keynote speech by Facebook founder Mark Zuckerberg, followed by various breakout sessions concentrating on specific topics. Facebook has often introduced new features, and made new announcements, at the conference. The name "F8" derives from the tradition at Facebook of having a big eight-hour Hackathon just after the event.',
		'link' : 'https://www.facebook.com/f8',
		'name' : 'F8'
	})

database.append(
	{
		'image' : 'https://devimages.apple.com.edgekey.net/wwdc/images/wwdc14-home-branding.png',
		'info' : 'The Apple Worldwide Developers Conference (WWDC), colloquially called "dub-dub", is a conference held annually in California by Apple Inc. The conference is used by Apple to showcase its new software and technologies for software developers. Attendees can participate in hands-on labs with Apple engineers, as well as in-depth sessions that cover a wide variety of topics. Until 2007, the number of attendees varied between 2,000 and 4,200; however, during WWDC 2007, Steve Jobs noted that there were more than 5,000 attendees. The WWDC events held from 2008 to 2014 were capped, and sold out at 5,000 attendees (5,200 including special attendees).',
		'link' : 'https://developer.apple.com/wwdc/',
		'name' : 'WWDC2014'
	})

database.append(
	{
		'image' : 'http://www.iot-devcon.com/images/IoTDevConImages.jpg',
		'info' : 'Machine-to-machine methods, (or M2M), intelligent embedded and/or smart fusion have been around in some form for many years. The Internet of Things (IoT) goes way beyond this capability and interconnects virtually unlimited numbers of smart objects and changes the way we interact with our environment. To help rein in the vast world of IoT, the IoT DevCon will focus on technologies ranging from the ultra-low power microcontrollers to the multicore-enabled aggregation hubs to the software and security infrastructure required for monitoring and management of the enormous bundles of data.',
		'link' : 'http://www.iot-devcon.com/',
		'name' : 'DevCon'
	})

database.append(
	{
		'image' : 'http://samsungdevcon.com/wp-content/uploads/2014/09/logo-gray-letters.png',
		'info' : 'Get ready to listen, discuss, learn and network about everything that enables you to participate in the present and future of Connected Living.',
		'link' : 'http://samsungdevcon.com/',
		'name' : 'samsungdevcon'
	})

database.append(
	{
		'image' : 'https://thestrangeloop.com/images/slider1.png',
		'info' : 'Strange Loop is a multi-disciplinary conference that aims to bring together the developers and thinkers building tomorrow technology in fields such as emerging languages, alternative databases, concurrency, distributed systems, mobile development, and the web. ',
		'link' : 'https://thestrangeloop.com/',
		'name' : 'StarngeLoop2014'
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
		itm_ifo = (itm_ifo[:40] + '..') if len(itm_ifo) > 40 else itm_ifo
		itm_lnk = itm['link']
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
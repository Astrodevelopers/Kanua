# -*- coding: utf-8 -*-
import random

database = []

database.append(
	{
		'description' : ('The JavaScript world seems to be entering a crisis of churn rate. Frameworks and technologies are being pushed out and burned through at an unsustainable speed. I think the community will adapt and adopt new practices in response. '), 
		'image' : 'http://www.w3devcampus.com/wp-content/uploads/logoAndOther/logo_JavaScript.png',
		'topic' : 'JavaScript',
		'name' : 'The JavaScript world seems to be entering a crisis of churn rate'})

database.append(
	{
		'description' : ('What happened to software engineering? What happened to the promise of rigorous, disciplined, professional practices for software development, like those observed in other engineering disciplines?'), 
		'image' : 'http://deliveryimages.acm.org/10.1145/2700000/2693160/jacobson2.png',
		'topic' : 'Software engineering',
		'name' : 'A New Software Engineering by Ivar Jacobson'})

database.append(
	{
		'description' : ('The new Mayor of the city of Rome, Ignazio Marino, just announced his intention to destroy one of the city’s central roads, the Via dei Fori Imperiali, and turn the area around the old Roman Forum into the world’s largest archaeological park.'), 
		'image' : 'http://exurbe.com/wp-content/uploads/2013/08/November2011-652-300x225.jpg',
		'topic' : 'History',
		'name' : 'The Shape of Rome'})

database.append(
	{
		'description' : ('PARIS — On a recent weekday, Ahlem Saifi caught a 5 a.m. Métro to get to her job as a passengers’ assistant at Orly Airport, where she often works 44 hours a week — well over France’s official 35-hour workweek.'),
		'image' : 'http://static01.nyt.com/images/2014/11/27/business/27workweek/27workweek-master675.jpg',
		'topic' : 'In France, New Review of 35-Hour Workweek',
		'name' : 'Culture'})

database.append(
	{
		'description' : ('Google is a great company — from its record $23 billion IPO in 2004 (at a time when Nasdaq was below 2000!) to its dominant mobile OS. My associates and I have such an admiration for Google that we built our latest web conferencing platform with Google’s technologies.'),
		'image' : 'http://1u88jj3r4db2x4txp44yqfj1.wpengine.netdna-cdn.com/wp-content/uploads/2012/04/eric-schmidt-testimony.jpg',
		'topic' : 'Google',
		'name' : 'Why Eric Schmidt doesn’t know how Google works'})

database.append(
	{
		'description' : ('I used to ask interviewees, “What’s your favorite programming language?” The answer was nearly always, “I just choose the right language for the job.” Duh. Does anyone ever deliberately pick the wrong language? This was clearly a way to avoid actually naming a language for fear of picking one I didn’t like.'),
		'image' : 'http://www.teamten.com/lawrence/writings/java-for-everything.jpg',
		'topic' : 'Java',
		'name' : 'Java for everything'})

database.append(
	{
		'description' : ('Para que un emprendimiento sea exito requiere ventas; pero, ¿qué es lo vende, cuál es la necesidad del cliente que compra el producto? En este taller se presentarán técnicas para prototipar la oferta de valor y como venderla.'),
		'image' : 'http://sistemas.uniandes.edu.co/ie/images/articulos/eventos/2014-10PrototiparValidarVender.jpg',
		'topic' : 'Emprendimiento',
		'name' : 'Taller: Prototipar, validar y vender'})

database.append(
	{
		'description' : ('El Centro de Emprendimiento invita a estudiantes y egresados de posgrado a participar en el Global Social Venture Competition (GSVC), la competencia de negocios más importante a nivel global en emprendimientos ambientales y sociales. El certamen da a los participantes asesoría, divulgación, y la oportunidad de ganar USD 50.000 en premios.'),
		'image' : 'http://sistemas.uniandes.edu.co/ie/images/articulos/noticias/GSVC2014.png',
		'topic' : 'Emprendimiento',
		'name' : 'Global Social Venture Competition 2014: Invitación a participar'})

database.append(
	{
		'description' : ('A partir del 6 de Octubre, IBM ha abierto las inscripciones para su concurso anual IBM Master the Mainframe a nivel suramérica. Kanua invita a todos los estudiantes del Departamento de Ingeniería de Sistemas y Computación a participar del consurso. No se requieren conocimientos premios en Mainframe.'),
		'image' : 'http://sistemas.uniandes.edu.co/ie/images/articulos/noticias/IBMMasterTheMainFrame.jpg',
		'topic' : 'IBM',
		'name' : 'Concurso: IBM Master the Mainframe 2014'})

database.append(
	{
		'description' : ('Por iniciativa de Maria Camila Angel y David Mesa, y como parte de las actividades de Kanua, tenemos el placer de invitar a los miembros de la comunidad Uniandina a participar del Uniandes Startup Club.'),
		'image' : 'http://sistemas.uniandes.edu.co/ie/images/articulos/noticias/HowToStartAStartup.png',
		'topic' : 'Emprendimiento',
		'name' : '¿Cómo iniciar tu startup?'})

database.append(
	{
		'description' : ('La competencia, Make it Wearable, cuenta con dos vías de acceso y ésta, llamada Vía de los Desarrolladores, tendrá las inscripciones abiertas hasta el día 24 de junio por medio del sitio https://makeit.intel.com. Para participar, los candidatos deben tener un proyecto tecnológico y de negocios viable, que sea innovador y con potencial de mercado. Para aquellos proyectos que logren avanzar en la competencia, habrá un proceso de asesoría por parte de expertos internacionales en tecnología, emprendimiento y diseño.'),
		'image' : 'http://sistemas.uniandes.edu.co/ie/images/articulos/noticias/MakeItWareAbleDesa.jpg',
		'topic' : 'Intel',
		'name' : 'Make it Wearable - Via Desarrolladores'})

database.append(
	{
		'description' : ('Imagine Cup es la competencia mundial más importante del mundo que invita a los estudiantes de tecnología, a los jóvenes desarrolladores y a los aspirantes a empresarios a crear proyectos innovadores y, posteriormente, comercializar esas ideas: “Durante los últimos 11 años, Imagine Cup ha sido un espacio de inspiración e innovación para los estudiantes de todas partes del mundo”Steve Guggenheimer, Vicepresidente Corporativo y Jefe de Evangelización de Microsoft.'),
		'image' : 'http://sistemas.uniandes.edu.co/ie/images/articulos/noticias/imaginecup.png',
		'topic' : 'Microsoft',
		'name' : 'Participa en Imagine Cup 2014'})

database.append(
	{
		'description' : ('La Fase de Acompañamiento del Programa Emprendedores busca darle a un selecto grupo de equipos de emprendimiento la oportunidad de recibir un mayor apoyo por parte de la Universidad.'),
		'image' : 'http://sistemas.uniandes.edu.co/ie/images/articulos/noticias/convocatoria.jpg',
		'topic' : 'Emprendedores',
		'name' : 'Programa emprendedores — Fase de acompañamiento'})

database.append(
	{
		'description' : ('A startup has created a water-repellent coating that could significantly increase power plants’ efficiency. Applying a novel coating to part of the machinery in power plants could significantly reduce carbon dioxide emissions. Applying it at just one coal plant would reduce yearly emissions as much as taking 4,000 cars off the road, says Kripa Varanasi, a professor of mechanical engineering at MIT who helped develop the new coating, which is being commercialized by a startup called DropWise.'),
		'image' : 'http://www.technologyreview.com/sites/default/files/images/mit.coatingx299.jpg',
		'topic' : 'Startup',
		'name' : 'Water-Repellent Coating Could Make Power Plants Greener'})

database.append(
	{
		'description' : ('While apps for work don’t usually inspire much excitement, there’s something almost palpable about the buzz surrounding Slack, a fast-growing communication app for the office. Slack corrals all kinds of work-related messages, files, and alerts—things that often hog space in e-mail inboxes, instant-message windows, and elsewhere—in searchable, archived chat rooms that can connect to outside services like Dropbox and Google Drive, and are accessible on mobile devices as well as desktop computers.'),
		'image' : 'http://www.technologyreview.com/sites/default/files/images/butterfieldx299.jpg',
		'topic' : 'Slack',
		'name' : 'Three Questions with Slack’s CEO'})

database.append(
	{
		'description' : ('This Tuesday Apple released WatchKit, a set of software tools, rules, and recommendations for developing apps for its forthcoming Apple Watch. The release sheds more light on the company’s vision for the device and its plans to work out some common challenges related to issues like power consumption, device navigation, and very small screen size. As with the iPhone before it, the popularity of the new device could depend, in large part, on the apps made for it.'),
		'image' : 'http://www.technologyreview.com/sites/default/files/images/apple.watchx299_1.jpg',
		'topic' : 'Apple',
		'name' : 'Apple Issues Strict Rules for the First Watch Apps'})

database.append(
	{
		'description' : ('In the year leading up to the release of the iPhone 6, Apple invested more than $1 billion in an effort to make sapphire one of the device’s big selling points. Making screens out of the nearly unscratchable material would have helped set the new phone apart from its competitors.'),
		'image' : 'http://www.technologyreview.com/sites/default/files/images/forrow_sapphirex299.jpg',
		'topic' : 'Apple',
		'name' : 'Why Apple Failed to Make Sapphire iPhones'})

database.append(
	{
		'description' : ('Two and a half years after Google cofounder Sergey Brin unveiled Google Glass with a group of skydivers jumping from a zeppelin above San Francisco, the computer you wear on your face is falling to its death. It’s still not a finished consumer product. It’s not even close to being something people yearn for, at least not beyond the Glass Explorers who each paid $1,500 for early access.'),
		'image' : 'http://www.technologyreview.com/sites/default/files/images/googleglassx392.jpg',
		'topic' : 'Google',
		'name' : 'Google Glass Is Dead; Long Live Smart Glasses'})

database.append(
	{
		'description' : ('Holidays are a time for families to come together, catch up over great food and drinks, and determine all the technical problems that need solving throughout the house. Indeed, for children growing up in the digital age, the holidays ultimately boil down to free (or more accurately, meal-subsidized) technical support for our most cherished loved ones.'),
		'image' : 'http://tctechcrunch2011.files.wordpress.com/2014/11/7940763908_99f145473d_o.jpg?w=738',
		'topic' : 'Amazon',
		'name' : 'The Algorithm Economy Heads To Amazon'})

database.append(
	{
		'description' : ('If you’re building a tech product that has anything to do with photos then you’re probably feeling an uncomfortable sense of déjà vu lately, and it has to do with data security. It had become so routine that throughout the fall it was hard to imagine a Monday without hearing about another set of iCloud photos that been hacked during the weekend.'),
		'image' : 'http://tctechcrunch2011.files.wordpress.com/2014/11/shutterstock_153022253-e1417214922137.jpg?w=738',
		'topic' : 'Selfie',
		'name' : 'The Social Psychology Of The Naked Selfie'})

database.append(
	{
		'description' : ('An unexpected consequence of our love apps is that now there’s just too damn many of them. The app stores are overcrowded, leaving developers desperate for a way to get their games and utilities discovered. That is why the app install ad has become the lifeblood of the mobile platform business.'),
		'image' : 'http://tctechcrunch2011.files.wordpress.com/2014/11/app-install-ads.jpg?w=1279&h=727&crop=1',
		'topic' : 'App',
		'name' : 'Facebook, Google, And Twitter’s War For App Install Ads'})

database.append(
	{
		'description' : ('With the recent launch of Apple Pay and leaked screenshots of Facebook integrating payments with Facebook Messenger fintech companies, there is a lot of speculation regarding the future of banking. Backed up by the way-too-often quoted Millennial Disruption Index, Accenture’s Banking 2020 and a range of similar reports tech evangelists predict that Apple, Facebook and Google will become the banks of the future.'),
		'image' : 'http://tctechcrunch2011.files.wordpress.com/2014/11/piggy.jpg?w=738',
		'topic' : 'Google',
		'name' : 'Banks As Commodity Utilities In A New Payment World'})

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

	file_object = open('news.sql', 'w')

	for itm in database:
		itm_id = random.randint(0, 1000)
		itm_desc = itm['description']
		itm_desc = (itm_desc[:40] + '..') if len(itm_desc) > 40 else itm_desc
		itm_dte = get_date()
		itm_img = itm['image']
		itm_nme = itm['name']
		itm_tpc = itm['topic']
		itm_ttl = itm_nme

		query = ''
		query += 'INSERT INTO APP.NOTICIAENTITY VALUES '
		query += '('
		query += str(itm_id) + ', '
		query += '\'' + itm_desc.strip() + '\', '
		query += '\'' + itm_dte + '\', '
		query += '\'' + itm_img + '\', '
		query += '\'' + itm_nme + '\', '
		query += '\'' + itm_tpc + '\', '
		query += '\'' + str(itm_ttl) + '\''
		query += ');'
		file_object.write(query + '\n')

main()

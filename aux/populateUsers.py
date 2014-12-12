import random
import string

tipos = [1,2,3,4]
names = []

def get_names():
	file_object = open('first.txt', 'r')
	sample = random.sample(file_object.readlines(), 40)

	for item in sample:
		names.append(item.strip().capitalize())


def get_last_names():
	file_object = open('lasts.txt', 'r')
	n = file_object.readlines()
	sample = random.sample(n, 40)

	i = 0
	for item in sample:
		last_name = item.strip().capitalize()
		names[i] += ' ' + last_name
		i += 1

def get_email(name):
	seed = ''.join(name.lower().split())
	return ''.join(random.choice(seed) for _ in range(5)) + '@gmail.com'

def get_password():
	return ''.join(random.choice(string.ascii_uppercase + string.digits) for _ in range(7))

def main():
	get_names()
	get_last_names()

	file_object = open('users.sql', 'w')

	for name in names:

		item_id = random.randint(0, 1000)
		item_email = get_email(name)
		item_name = name
		item_password = get_password()
		item_type = random.choice(tipos)

		query = ''
		query += 'INSERT INTO APP.USUARIOENTITY VALUES '
		query += '('
		query += str(item_id) + ', '
		query += '\'' + item_email + '\', '
		query += '\'' + item_name + '\', '
		query += '\'' + item_password + '\', '
		query += str(item_type)
		query += ');'
		file_object.write(query + '\n')

main()

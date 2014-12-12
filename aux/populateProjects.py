# -*- coding: utf-8 -*-
import random

states = [0, 1, 2, 3]

database = []

database.append(
	{
		'demo' : 'https://www.youtube.com/watch?v=iSmkqocn0oQ', 
		'desc' : 'Haskell is an advanced purely-functional programming language. An open-source product of more than twenty years of cutting-edge research, it allows rapid development of robust, concise, correct software. With strong support for integration with other languages, built-in concurrency and parallelism, debuggers, profilers, rich libraries and an active community, Haskell makes it easier to produce flexible, maintainable, high-quality software.',
		'img' : 'http://3.bp.blogspot.com/-sSNYosPbk3o/UtM3TBCX4lI/AAAAAAAAAHs/T1Z3qd4vft0/s1600/Haskell-Variation+(logo+only)-medium.png',
		'name' : 'Haskell'
	})

database.append(
	{
		'demo' : 'https://www.youtube.com/watch?v=uKfKtXYLG78', 
		'desc' : 'Erlang is a general-purpose concurrent, garbage-collected programming language and runtime system. The sequential subset of Erlang is a functional language, with eager evaluation, single assignment, and dynamic typing. It was designed by Ericsson to support distributed, fault-tolerant, soft-real-time, non-stop applications. It supports hot swapping, so that code can be changed without stopping a system.',
		'img' : 'http://c179631.r31.cf0.rackcdn.com/Erlang_logo.png',
		'name' : 'Erlang',
	})

database.append(
	{
		'demo' : 'https://www.youtube.com/watch?v=ALr212cTpf4', 
		'desc' : 'F# is a strongly typed, multi-paradigm programming language that encompasses functional, imperative, and object-oriented programming techniques. F# is most often used as a cross-platform CLI language, but can also be used to generate JavaScript[4] and GPU[5] code.',
		'img' : 'http://upload.wikimedia.org/wikipedia/en/thumb/d/d5/Fsharp%2C_Logomark%2C_October_2014.svg/120px-Fsharp%2C_Logomark%2C_October_2014.svg.png',
		'name' : 'F#',
	})

database.append(
	{
		'demo' : 'https://www.youtube.com/watch?v=9wOzjbgRoNU', 
		'desc' : 'Rust is a general purpose, multi-paradigm, compiled programming language developed by Mozilla Research.[6] It is designed to be a "safe, concurrent, practical language",[7][8] supporting pure-functional, concurrent-actor, imperative-procedural, and object-oriented styles.',
		'img' : 'http://upload.wikimedia.org/wikipedia/en/thumb/d/d5/Rust_programming_language_black_logo.svg/144px-Rust_programming_language_black_logo.svg.png',
		'name' : 'Rust',
	})

database.append(
	{
		'demo' : 'https://www.youtube.com/watch?v=NFTcB5w1KGg', 
		'desc' : 'Go, also commonly referred to as golang, is a programming language initially developed at Google[6] in 2007 by Robert Griesemer, Rob Pike, and Ken Thompson.[2] It is a statically-typed language with syntax loosely derived from that of C, adding garbage collection, type safety, some dynamic-typing capabilities, additional built-in types such as variable-length arrays and key-value maps, and a large standard library.',
		'img' : 'http://www.unixstickers.com/image/cache/data/stickers/golang/golang.sh-600x600.png',
		'name' : 'Go',
	})

database.append(
	{
		'demo' : 'https://www.youtube.com/watch?v=wASCH_gPnDw', 
		'desc' : 'Clojure (pronounced like "closure"[3]) is a dialect of the Lisp programming language created by Rich Hickey. Clojure is a general-purpose programming language with an emphasis on functional programming. It runs on the Java Virtual Machine, Common Language Runtime, and JavaScript engines. Like other Lisps, Clojure treats code as data and has a macro system.',
		'img' : 'https://raw.githubusercontent.com/docker-library/docs/master/clojure/logo.png',
		'name' : 'Clojure',
	})

database.append(
	{
		'demo' : 'https://www.youtube.com/watch?v=-KgF-vGfkds', 
		'desc' : 'Common Lisp (CL) is a dialect of the Lisp programming language, published in ANSI standard document ANSI INCITS 226-1994 (R2004) (formerly X3.226-1994 (R1999)).[1] From the ANSI Common Lisp standard the Common Lisp HyperSpec has been derived[2] for use with web browsers. Common Lisp was developed to standardize the divergent variants of Lisp (though mainly the MacLisp variants) which predated it, thus it is not an implementation but rather a language specification.[3] Several implementations of the Common Lisp standard are available, including free and open source software and proprietary products',
		'img' : 'http://fc05.deviantart.net/fs71/i/2010/085/f/6/Common_Lisp_Wallpaper_by_Pocket7878.png',
		'name' : 'Common Lisp',
	})

database.append(
	{
		'demo' : 'https://www.youtube.com/watch?v=2Op3QLzMgSY', 
		'desc' : 'Scheme is a functional programming language and one of the two main dialects of the programming language Lisp. Unlike Common Lisp, the other main dialect, Scheme follows a minimalist design philosophy specifying a small standard core with powerful tools for language extension.',
		'img' : 'https://bentomiso.com/uploads/depot/5248dfcda5a6274da5000000/FEj8jyf2//wizards_of_sicp.jpg',
		'name' : 'Scheme',
	})

database.append(
	{
		'demo' : 'https://www.youtube.com/watch?v=hKcOkWzj0_s', 
		'desc' : 'OCaml, originally known as Objective Caml, is the main implementation of the Caml programming language, created by Xavier Leroy, Jérôme Vouillon, Damien Doligez, Didier Rémy and others in 1996. OCaml extends the core Caml language with object-oriented constructs.',
		'img' : 'https://opam.ocaml.org/ext/img/ocaml.png',
		'name' : 'OCaml',
	})

database.append(
	{
		'demo' : 'https://www.youtube.com/watch?v=XRClA5YLiIc', 
		'desc' : 'Julia is a high-level dynamic programming language designed to address the requirements of high-performance[6] numerical and scientific computing while also being effective for general purpose programming.',
		'img' : 'http://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Julia_prog_language.svg/200px-Julia_prog_language.svg.png',
		'name' : 'Julia',
	})

database.append(
	{
		'demo' : 'https://www.youtube.com/watch?v=Ee5t_EGjv0A', 
		'desc' : 'Java is a general-purpose computer programming language that is concurrent, class-based, object-oriented,[10] and specifically designed to have as few implementation dependencies as possible. It is intended to let application developers "write once, run anywhere" (WORA), meaning that code that runs on one platform does not need to be recompiled to run on another. Java applications are typically compiled to bytecode that can run on any Java virtual machine (JVM) regardless of computer architecture',
		'img' : 'http://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Java_logo_and_wordmark.svg/100px-Java_logo_and_wordmark.svg.png',
		'name' : 'Java',
	})

database.append(
	{
		'demo' : 'https://www.youtube.com/watch?v=pxofwuWTs7c', 
		'desc' : 'Python is a widely used general-purpose, high-level programming language. Its design philosophy emphasizes code readability, and its syntax allows programmers to express concepts in fewer lines of code than would be possible in languages such as C++ or Java.[18][19] The language provides constructs intended to enable clear programs on both a small and large scale',
		'img' : 'http://networkstatic.net/wp-content/uploads/2012/09/python1.png',
		'name' : 'Python',
	})

database.append(
	{
		'demo' : 'https://www.youtube.com/watch?v=ecekSCX3B4Q', 
		'desc' : 'Scala is an object-functional programming language for general software applications. Scala has full support for functional programming and a very strong static type system. This allows programs written in Scala to be very concise and thus smaller in size than other general purpose programming languages. Many of Scala design decisions were inspired by criticism over the shortcomings of Java.',
		'img' : 'https://dnsta5v53r71w.cloudfront.net/images/why-scala/scala-logo.png',
		'name' : 'Scala',
	})

def main():

	file_object = open('projects.sql', 'w')

	for itm in database:
		itm_id = random.randint(0, 1000)
		itm_demo = itm['demo']
		itm_desc = itm['desc'].replace('"', '')
		itm_desc = (itm_desc[:40] + '..') if len(itm_desc) > 40 else itm_desc
		itm_tem = 0
		itm_ste =  random.choice(states)
		itm_img = itm['img']
		itm_lma = 'Functional abstraction'
		itm_nme = itm['name']
		itm_topic = 'Programming'

		query = ''
		query += 'INSERT INTO APP.PROYECTOENTITY VALUES '
		query += '('
		query += str(itm_id) + ', '
		query += '\'' + itm_demo + '\', '
		query += '\'' + itm_desc + '\', '
		query += str(itm_tem) + ', '
		query += str(itm_ste) + ', '
		query += '\'' + itm_img + '\', '
		query += '\'' + itm_lma + '\', '
		query += '\'' + itm_nme + '\', '
		query += '\'' + itm_topic + '\''
		query += ');'
		file_object.write(query + '\n')

main()

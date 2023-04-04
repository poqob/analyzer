package parser.classes;

import models.classes.AClass;

public abstract class AClassParser {
	public abstract AClass parse();
}

/*
 * sahte kod
 * 
 * findClass() alt metotlar sonucunda olu�an AClass nesnesini d�nd�r�r.
 * 
 * find() regex ile bulunan sat�rdaki '{' ile ba�layarak karakter karakter '{'
 * ve '}' arans�n.
 * 
 * 
 * k��eli parantez algoritmas�na g�re s�n�f sonu tespit edilsin.
 * 
 * S�n�f ba�� ve sonu sat�r numaralar� baz al�narak JavaClass nesnesi yarat�ls�n
 * ve d�nd�r�ls�n.
 * 
 */
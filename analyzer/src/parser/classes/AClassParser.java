package parser.classes;

import models.classes.AClass;

public abstract class AClassParser {
	public abstract AClass parse();
}

/*
 * sahte kod
 * 
 * findClass() alt metotlar sonucunda oluþan AClass nesnesini döndürür.
 * 
 * find() regex ile bulunan satýrdaki '{' ile baþlayarak karakter karakter '{'
 * ve '}' aransýn.
 * 
 * 
 * köþeli parantez algoritmasýna göre sýnýf sonu tespit edilsin.
 * 
 * Sýnýf baþý ve sonu satýr numaralarý baz alýnarak JavaClass nesnesi yaratýlsýn
 * ve döndürülsün.
 * 
 */
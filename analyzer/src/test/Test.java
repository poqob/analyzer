package test;

import models.classes.java.JavaClass;
import parser.java.JavaParser;
import util.Debug;

public class Test {

	public Test() {

		String path = "C:\\Users\\mmerm\\git\\repository\\analyzer\\src\\test\\test.txt";
		JavaParser parser = new JavaParser(path);
		JavaClass clss = parser.parse();
		Debug.Writer(clss.toString());
	}
}

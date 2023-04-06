package test;

import models.classes.java.JavaClass;
import parser.java.JavaParser;
import writer.javaWriter.JavaWriter;

public class Test {

	public Test(String path) {

		// String path =
		// "C:\\Users\\mmerm\\git\\repository\\analyzer\\src\\test\\test.txt";
		JavaParser parser = new JavaParser(path);
		JavaClass clss = parser.parse();
		JavaWriter writer = new JavaWriter(clss);

		writer.writeToConsole();
		writer.writeToFile();
		// Debug.Writer(clss.getStatics());

	}
}

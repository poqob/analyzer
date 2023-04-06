package test;

import analyzer.writer.java.JavaWriter;
import models.classes.java.JavaClass;
import parser.java.JavaParser;

public class Test {

	public Test() {

		String path = "C:\\Users\\mmerm\\git\\repository\\analyzer\\src\\test\\test.txt";
		JavaParser parser = new JavaParser(path);
		JavaClass clss = parser.parse();
		JavaWriter writer = new JavaWriter(clss);

		writer.writeToConsole();

	}
}

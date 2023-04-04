package analyzer;

import java.io.IOException;

import models.classes.JavaClass;
import parser.classes.JavaClassParser;
import util.Debug;
import util.Todo;

@Todo("todo")

public class Program {

	public static void main(String[] args) throws IOException {
		// Test t = new Test();
		// String text = "{j{}s}{}";
		// CurlyBraces b = new CurlyBraces(text);
		// System.out.print(b.toString());

		String path = "C:\\Users\\mmerm\\git\\repository\\analyzer\\src\\test\\test.txt";

		JavaClassParser cp = new JavaClassParser(path);
		JavaClass clss = (JavaClass) cp.parse();
		Debug.Writer(clss.toString());
	}

}

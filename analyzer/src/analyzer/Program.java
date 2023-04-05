package analyzer;

import java.io.IOException;

import models.classes.JavaClass;
import parser.classes.JavaClassParser;
import parser.function.JavaMethodParser;
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
		// Debug.Writer(clss.toString());

		// JavaConstructorParser cop = new JavaConstructorParser(clss);
		// cop.parse().forEach(f -> Debug.Writer(f.getContent() + "\n"));

		JavaMethodParser mep = new JavaMethodParser(clss);
		// Debug.Writer(mep.parse().size() + "\n");
		// mep.parse().forEach(m -> Debug.Writer(m.getName()));
		mep.parse();
	}

}

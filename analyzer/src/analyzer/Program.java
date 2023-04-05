package analyzer;

import java.io.IOException;
import java.util.ArrayList;

import models.classes.JavaClass;
import models.function.AFunction;
import parser.classes.JavaClassParser;
import parser.function.JavaConstructorParser;
import parser.function.JavaMethodParser;
import util.Debug;
import util.Todo;

@Todo("todo")

public class Program {

	public static void main(String[] args) throws IOException {
		// Test t = new Test();
		// String text = "{j{}s}{}";
		// CurlyBraces b = new CurlyBraces(text);
		// System.out.print(b.toString());

		// in funcs, we have afunctions typed consturctors and methods
		// a function contains it's name, function text, function type (like constructor
		// or method),
		// it's location from head to end of the function in its class as int array.
		ArrayList<AFunction> funcs = new ArrayList<AFunction>();

		String path = "C:\\Users\\mmerm\\git\\repository\\analyzer\\src\\test\\test.txt";

		JavaClassParser cp = new JavaClassParser(path);
		JavaClass clss = (JavaClass) cp.parse();
		Debug.Writer(clss.getType().concat(" ") + clss.getName() + "\n");

		JavaConstructorParser cop = new JavaConstructorParser(clss);
		cop.parse().forEach(f -> {
			Debug.Writer(f.getType().concat(" ") + f.getName() + " " + f.getRange()[0] + "," + f.getRange()[1] + "\n");
			funcs.add(f);
		});

		JavaMethodParser mep = new JavaMethodParser(clss);
		// Debug.Writer(clss.getName() + "\n");
		mep.parse().forEach(m -> {
			Debug.Writer(m.getType().concat(" ") + m.getName() + " " + m.getRange()[0] + "," + m.getRange()[1] + "\n");
			funcs.add(m);
		});

		// TODO: knk þimdi yorum tespiti yapacaðýz tasarýma bir bakacaðým olmadý
		// deðiþikliðe gidebilirlm.

	}

}

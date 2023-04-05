package analyzer;

import java.io.IOException;
import java.util.ArrayList;

import models.classes.JavaClass;
import models.comment.AComment;
import models.function.AFunction;
import parser.classes.JavaClassParser;
import parser.comment.JavaCommentParser;
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
		ArrayList<AComment> comms = new ArrayList<AComment>();

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

		// attempting functions
		clss.setFunctions(funcs);

		// JavaCommentParser(clss)

		// TODO: knk þimdi yorum tespiti yapacaðýz tasarýma bir bakacaðým olmadý
		// deðiþikliðe gidebilirlm.

		// ACommentParser üzerinden gidip plana sadýk kalacaðýz.
		//

		// atempting comments
		clss.setComments(comms);

		// clss.getFunComms(); funcomlarý döndürecek

		JavaCommentParser jcp = new JavaCommentParser(clss);
		jcp.parse();
		/*
		 * comment dedect and classifice test ok.
		 * 
		 * int[] virt = jcp.parse().get(4).getRange(); String ttt =
		 * clss.toString().substring(virt[0], virt[1]); Debug.Writer(ttt);
		 */

	}

}

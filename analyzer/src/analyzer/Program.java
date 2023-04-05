package analyzer;

import java.io.IOException;
import java.util.ArrayList;

import models.classes.java.JavaClass;
import models.comment.AComment;
import models.function.AFunction;
import models.functionAndComments.AFunctionWithComments;
import parser.classes.java.JavaClassParser;
import parser.comment.java.JavaCommentParser;
import parser.function.java.JavaConstructorParser;
import parser.function.java.JavaMethodParser;
import util.Debug;
import util.Todo;

@Todo("i'm gonna sum all operations sub of JavaParser class. End of the day usage scenario will be like this:")
//the usage scenario.
/*
 * JavaClass clss=new JavaClass(path~file);
 * 
 * clss has itself parser that is JavaParser includes all parse methods int it.
 * 
 * parsing will take place immediately after the constructor function is
 * executed.
 * 
 * then we write another class which responsible printing to screen and writing
 * to files.
 * 
 * 
 */
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
		ArrayList<AComment> comms;
		ArrayList<AFunctionWithComments> funcomms = new ArrayList<AFunctionWithComments>();

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

		JavaCommentParser jcp = new JavaCommentParser(clss);
		comms = jcp.parse();
		clss.setComments(comms);

		// comment dedect and classifice test ok.
		// int[] virt = jcp.parse().get(4).getRange();
		// String ttt = clss.toString().substring(virt[0], virt[1]);
		// Debug.Writer(ttt);

		// Debug.Writer(jcp.parse().get(4).getContent());

		// clss.getComments().forEach(c -> Debug.Writer(c.getContent() + "\n"));

		clss.getFunComs().forEach(fc -> fc.getSingleComments().forEach(fsc -> Debug.Writer(fsc.getContent() + "\n")));

	}

}

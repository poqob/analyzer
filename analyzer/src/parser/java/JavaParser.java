/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 06.04.23
* @JavaParser
* JavaParser is a AParser based java-specified class. it parses class
* after constructor call. you can get parsed class by calling .parse()
* method. 
* 
*/

package parser.java;

import java.io.IOException;

import models.classes.java.JavaClass;
import parser.AParser;
import parser.classes.java.JavaClassParser;
import parser.comment.java.JavaCommentParser;
import parser.function.java.JavaConstructorParser;
import parser.function.java.JavaMethodParser;

public class JavaParser extends AParser {

	public JavaParser(String path) throws IOException {
		super(path);
		// parse class
		super.clssParser = new JavaClassParser(path);
		super.clss = clssParser.parseClass();

		// parse constructors
		super.constructorParser = new JavaConstructorParser((JavaClass) clss);
		constructorParser.parse().forEach(c -> super.funcs.add(c));

		// parse methods
		super.methodParser = new JavaMethodParser((JavaClass) clss);
		methodParser.parse().forEach(m -> super.funcs.add(m));

		// set parsed method-constructures
		super.clss.setFunctions(super.funcs);

		// parse comments
		super.commentParser = new JavaCommentParser((JavaClass) clss);

		// set parsed comments
		super.clss.setComments(commentParser.parse());

		// run getFunComms() inorder to create mixed method comment structure for
		// further process.
		super.clss.getFunComs();
	}

	// return parsed class
	@Override
	public JavaClass parse() {
		return (JavaClass) clss;
	}

}

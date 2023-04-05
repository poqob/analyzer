package parser;

import parser.classes.AClassParser;
import parser.comment.ACommentParser;
import parser.function.AFunctionParser;

public class JavaParser extends AParser {

	public JavaParser(AFunctionParser func, ACommentParser comm, AClassParser clss) {
		super(func, comm, clss);
	}

}

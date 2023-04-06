package parser;

import java.util.ArrayList;

import models.classes.AClass;
import models.function.AFunction;
import parser.classes.AClassParser;
import parser.comment.ACommentParser;
import parser.function.AFunctionParser;

public abstract class AParser {
	protected ArrayList<AFunction> funcs;

	protected AFunctionParser methodParser;
	protected AFunctionParser constructorParser;
	protected ACommentParser commentParser;
	protected AClassParser clssParser;
	protected AClass clss;

	public AParser(String path) {
		funcs = new ArrayList<AFunction>();

	};
}

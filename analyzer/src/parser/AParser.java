package parser;

import parser.classes.AClassParser;
import parser.comment.ACommentParser;
import parser.function.AFunctionParser;

public abstract class AParser {
	protected final AFunctionParser func;
	protected final ACommentParser comm;
	protected final AClassParser clss;

	public AParser(AFunctionParser func, ACommentParser comm, AClassParser clss) {
		this.clss = clss;
		this.func = func;
		this.comm = comm;
	};
}

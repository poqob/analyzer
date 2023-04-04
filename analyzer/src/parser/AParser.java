package parser;

import parser.classes.AClassParser;
import parser.comment.ACommentParser;
import parser.function.AFunctionParser;

public abstract class AParser {
	protected final AFunctionParser function;
	protected final ACommentParser comment;
	protected final AClassParser clss;

	public AParser(AFunctionParser func, ACommentParser comm, AClassParser clss) {
		this.clss = clss;
		this.function = func;
		this.comment = comm;
	};
}

package parser.comment;

import java.util.ArrayList;

import models.classes.AClass;
import models.comment.AComment;

//Detects, instantiates, and returns comments on a class object.
public abstract class ACommentParser {
	protected final AClass clss;
	protected ArrayList<AComment> comments;

	public ACommentParser(AClass clss) {
		this.clss = clss;
		comments = new ArrayList<AComment>();
	}

	public ArrayList<AComment> parse() {
		return comments;
	}
}
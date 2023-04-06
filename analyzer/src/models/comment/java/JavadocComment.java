package models.comment.java;

import models.comment.ADocumentComment;

public class JavadocComment extends ADocumentComment {

	public JavadocComment(int[] range, String content) {
		super(range, content, "JAVADOC COMMENT");
	}

}

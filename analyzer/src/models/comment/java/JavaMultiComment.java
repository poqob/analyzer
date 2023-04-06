package models.comment.java;

import models.comment.AMultiComment;

public class JavaMultiComment extends AMultiComment {

	public JavaMultiComment(int[] range, String content) {
		super(range, content, "MULTI-LINE-COMMENT");
	}

}

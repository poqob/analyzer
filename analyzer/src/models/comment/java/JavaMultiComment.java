/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 06.04.23
* @JavaMultiComment
* JavaMultiComment is model for multi-line style comments which derived from AMultiComment.
*/

package models.comment.java;

import models.comment.AMultiComment;

public class JavaMultiComment extends AMultiComment {
	// constructor
	public JavaMultiComment(int[] range, String content) {
		super(range, content, "MULTI-LINE-COMMENT");
	}

}

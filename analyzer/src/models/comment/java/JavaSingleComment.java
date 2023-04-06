/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 06.04.23
* @JavaSingleComment
* JavaSingleComment is model for single-line style comments which derived from ASingleComment.
*/
package models.comment.java;

import models.comment.ASingleComment;

public class JavaSingleComment extends ASingleComment {
	// constructor
	public JavaSingleComment(int[] range, String content) {
		super(range, content, "SINGLE-COMMENT");
	}
}

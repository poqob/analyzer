/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 06.04.23
* @JavadocComment
* JavadocComment is model for document style comments which derived from ADocumentComment.
*/

package models.comment.java;

import models.comment.ADocumentComment;

public class JavadocComment extends ADocumentComment {

	// constructor
	public JavadocComment(int[] range, String content) {
		super(range, content, "JAVADOC COMMENT");
	}

}

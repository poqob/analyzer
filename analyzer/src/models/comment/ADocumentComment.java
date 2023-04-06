/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 05.04.23
* @ADocumentComment
* ADocumentComment is a abstract model for document style comments which derived from AComment. 
* it works exactly same with AComment. Difference is it has type.
*/

package models.comment;

public abstract class ADocumentComment extends AComment {

	// constructor
	public ADocumentComment(int[] range, String content, String type) {
		super(range, content, type);
	}

}

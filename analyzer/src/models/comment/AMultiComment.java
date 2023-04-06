/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 05.04.23
* @AMultiComment
* AMultiComment is a abstract model for multi-line style comments which derived from AComment. 
* it works exactly same with AComment. Difference is it has type.
*/

package models.comment;

public abstract class AMultiComment extends AComment {

	// constructor
	public AMultiComment(int[] range, String content, String type) {
		super(range, content, type);
	}

}

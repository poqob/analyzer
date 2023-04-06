/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 05.04.23
* @ASingleComment
* ASingleComment is a abstract model for single-line style comments which derived from AComment. 
* it works exactly same with AComment. Difference is it has type.
*/

package models.comment;

public abstract class ASingleComment extends AComment {

	// constructor
	public ASingleComment(int[] range, String content, String type) {
		super(range, content, type);
	}

}

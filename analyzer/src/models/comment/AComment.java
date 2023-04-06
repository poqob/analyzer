/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 05.04.23
* @AComment
* AComment is a abstract model for comments. it stores comment's itself
* comment type (single-multi-special) and comment's bound in class.
*/

package models.comment;

// range: comment's bound in class. {startIndex,stopIndex}
//if you take substring of the class according to the range, you can get comment.
public abstract class AComment {
	protected final int[] range;
	protected final String type;// single-multi-specified
	protected final String content;

	public AComment(int[] range, String content, String type) {
		this.range = range;
		this.content = content;
		this.type = type;
	}

	// getters
	public int[] getRange() {
		return range;
	};

	public String getContent() {
		return content;
	};

	public String getType() {
		return type;
	}

	public String toString() {
		return content + "\n{" + range[0] + "," + range[1] + "}\n";
	}
}

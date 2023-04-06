package models.comment;

public abstract class AMultiComment extends AComment {

	public AMultiComment(int[] range, String content, String type) {
		super(range, content, type);
	}

}

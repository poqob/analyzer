package models.comment;

public abstract class ADocumentComment extends AComment {

	public ADocumentComment(int[] range, String content, String type) {
		super(range, content, type);
	}

}

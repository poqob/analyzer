package models.comment;

public abstract class AComment {
	protected final int startIndex;
	protected final int finishIndex;
	protected final String content;

	public AComment(int startIndex, int finishIndex, String content) {
		this.startIndex = startIndex;
		this.finishIndex = finishIndex;
		this.content = content;
	}

	public int[] getRange() {
		return new int[] { startIndex, finishIndex };
	};

	public String getContent() {
		return content;
	};
}

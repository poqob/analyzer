package models.comment;

public abstract class AComment {
	protected final int[] range;
	protected final String type;
	protected final String content;

	public AComment(int[] range, String content, String type) {
		this.range = range;
		this.content = content;
		this.type = type;
	}

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

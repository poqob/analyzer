package models.function;

public abstract class AFunction {
	protected final String name;
	protected final String content;
	protected final int startIndex;
	protected final int finalIndex;

	public AFunction(String name, int startIndex, int finalIndex, String content) {
		this.name = name;
		this.startIndex = startIndex;
		this.finalIndex = finalIndex;
		this.content = content;
	}

	public int[] getRange() {
		return new int[] { startIndex, finalIndex };
	}

	public String getContent() {
		return content;
	};

	public String getName() {
		return name;
	};

}

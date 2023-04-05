package models.function;

public abstract class AFunction {
	protected final String name;
	protected final String content;
	protected final int[] range;

	public AFunction(String name, int[] range, String content) {
		this.name = name;
		this.range = range;
		this.content = content;
	}

	public int[] getRange() {
		return range;
	}

	public String getContent() {
		return content;
	};

	public String getName() {
		return name;
	};

}

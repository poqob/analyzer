package models.function;

public abstract class AFunction {
	protected final String name;
	protected final String content;
	protected String functionType = "FUNCTION";
	protected final int[] range;

	public AFunction(String name, int[] range, String content) {
		this.name = name;
		this.range = range;
		this.content = content;
	}

	protected void setType(String type) {
		this.functionType = type;
	}

	public String getType() {
		return functionType;
	}

	public int[] getRange() {
		return range;
	}

	public String toString() {
		return content;
	};

	public String getName() {
		return name;
	};

}

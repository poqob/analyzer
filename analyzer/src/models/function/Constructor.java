package models.function;

public class Constructor extends AFunction {

	public Constructor(String name, int[] range, String content) {
		super(name, range, content);
		super.setType("CONSTRUCTOR");
	}

}

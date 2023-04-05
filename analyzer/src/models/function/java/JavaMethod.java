package models.function;

public class Method extends AFunction {
	public Method(String name, int[] range, String content) {
		super(name, range, content);
		super.setType("METHOD");
	}

}

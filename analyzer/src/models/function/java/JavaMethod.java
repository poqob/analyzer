package models.function.java;

import models.function.AFunction;

public class JavaMethod extends AFunction {
	public JavaMethod(String name, int[] range, String content) {
		super(name, range, content);
		super.setType("METHOD");
	}

}

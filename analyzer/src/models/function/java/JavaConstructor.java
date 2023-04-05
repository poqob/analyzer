package models.function.java;

import models.function.AFunction;

public class JavaConstructor extends AFunction {

	public JavaConstructor(String name, int[] range, String content) {
		super(name, range, content);
		super.setType("CONSTRUCTOR");
	}

}

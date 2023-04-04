package models.classes;

import java.util.ArrayList;

import models.functionAndComments.AFunctionWithComments;

public abstract class AClass {
	protected final String name;

	protected final String text;
	protected ArrayList<AFunctionWithComments> processes;

	public AClass(String name, String text) {
		this.name = name;

		this.text = text;
		processes = new ArrayList<AFunctionWithComments>();
	};

	public String getName() {
		return name;
	};

	public String toString() {
		return text;
	}
}

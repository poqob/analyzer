package models.classes;

import java.io.BufferedReader;
import java.util.ArrayList;

import models.functionAndComments.AFunctionWithComments;

public abstract class AClass {
	protected final String name;
	protected final int startIndex;
	protected final int finalIndex;
	protected final BufferedReader br;
	protected ArrayList<AFunctionWithComments> processes;

	public AClass(String name, int startIndex, int finalIndex, BufferedReader br) {
		this.name = name;
		this.startIndex = startIndex;
		this.finalIndex = finalIndex;
		this.br = br;
		processes = new ArrayList<AFunctionWithComments>();
	};

	public int[] getRange() {
		return new int[] { startIndex, finalIndex };
	};

	public String getName() {
		return name;
	};

	public BufferedReader getBufferedReader() {
		return br;
	};

	public String toString() {
		return br.toString();
	}
}

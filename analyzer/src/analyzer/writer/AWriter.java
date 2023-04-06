package analyzer.writer;

import models.classes.AClass;

public abstract class AWriter {
	protected final AClass clss;

	public AWriter(AClass clss) {
		this.clss = clss;
	}

	protected abstract void cleanFiles();

	public abstract void writeToFile();

	public abstract void writeToConsole();
}

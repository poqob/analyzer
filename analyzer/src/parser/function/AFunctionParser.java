package parser.function;

import java.util.ArrayList;

import models.classes.AClass;
import models.function.AFunction;

public abstract class AFunctionParser {
	protected AClass clss;
	protected ArrayList<AFunction> funList;

	public AFunctionParser(AClass clss) {
		this.clss = clss;
	}

	public abstract ArrayList<AFunction> parse();
}

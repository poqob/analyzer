/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 05.04.23
* @AFunction
* AFunction is a model for function structures. AFunction class provides 
* a function's name, function as a text, function type (method-constructor),
* and function's bounds. In further updates i will add more detailed fields
* like function parameters, return type and etc.
*/

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

	// type setter (only constructor and method supported nowly)
	protected void setType(String type) {
		this.functionType = type;
	}

	// getters

	public String getType() {
		return functionType;
	}

	public int[] getRange() {
		return range;
	}

	public String getName() {
		return name;
	};

	public String toString() {
		return content;
	};

}

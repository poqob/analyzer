/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 06.04.23
* @JavaMethod
* JavaMethod is a model for java method. it is derived from 
* AFunction and works exactly same.
*/
package models.function.java;

import models.function.AFunction;

public class JavaMethod extends AFunction {
	// constructor
	public JavaMethod(String name, int[] range, String content) {
		super(name, range, content);
		super.setType("METHOD");
	}

}

/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 06.04.23
* @JavaConstructor
* JavaConstructor is a model for java constructors. it is derived from 
* AFunction and works exactly same.
*/
package models.function.java;

import models.function.AFunction;

public class JavaConstructor extends AFunction {

	// constructor
	public JavaConstructor(String name, int[] range, String content) {
		super(name, range, content);
		super.setType("CONSTRUCTOR");
	}

}

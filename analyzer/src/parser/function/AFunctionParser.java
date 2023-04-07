/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 07.04.23
* @AFunctionParser
* AFunctionParser is a template class for all languages function parsers. it requires a class to run.
* parse() was planned to be parses all type of functions (only methods and constructors nowly :'') 
* from class and returns them in a primitive type function list.
* 
*/

package parser.function;

import java.util.ArrayList;

import models.classes.AClass;
import models.function.AFunction;

public abstract class AFunctionParser {
	protected AClass clss;
	protected ArrayList<AFunction> funList;

	// constructor.
	public AFunctionParser(AClass clss) {
		this.clss = clss;
	}

	// parse method which returns parsed functions.
	public abstract ArrayList<AFunction> parse();
}

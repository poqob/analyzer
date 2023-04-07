/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 06.04.23
* @AParser
* AParser is a abstract attic for a group of parsing class like 
* class parser, function parser, comment parser.
* parse method returns whole class as a object with parsed components.
* 
*/

package parser;

import java.util.ArrayList;

import models.classes.AClass;
import models.function.AFunction;
import parser.classes.AClassParser;
import parser.comment.ACommentParser;
import parser.function.AFunctionParser;

public abstract class AParser {
	// fields
	protected ArrayList<AFunction> funcs;
	protected AFunctionParser methodParser;
	protected AFunctionParser constructorParser;
	protected ACommentParser commentParser;
	protected AClassParser clssParser;
	protected AClass clss;
	protected String path;

	// parse method returns totally parsed class.
	public abstract AClass parse();

	// constructor
	public AParser(String path) {
		funcs = new ArrayList<AFunction>();
		this.path = path;
	};
}

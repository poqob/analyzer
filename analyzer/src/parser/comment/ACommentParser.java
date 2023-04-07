/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 07.04.23
* @ACommentParser
* ACommentParser is a template class for all languages comment parser. it requires a class to run.
* parse() was planned to be parses all type of comments from class and returns them in a primitive 
* type comment list.
* 
*/

package parser.comment;

import java.util.ArrayList;

import models.classes.AClass;
import models.comment.AComment;

//Detects, instantiates, and returns comments on a class object.
public abstract class ACommentParser {
	protected final AClass clss;
	protected ArrayList<AComment> comments;

	// constructor.
	public ACommentParser(AClass clss) {
		this.clss = clss;
	}

	// parse and return parsed comments as a list.
	public ArrayList<AComment> parse() {
		// do something
		return comments;
	}
}
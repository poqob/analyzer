/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 06.04.23
* @AClassParser
* AClassParser is a base class parser for every language's class parsers.
* 
*/

package parser.classes;

import models.classes.AClass;

public abstract class AClassParser {
	// abstract parse command
	public abstract AClass parseClass();
}

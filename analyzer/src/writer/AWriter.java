/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 07.04.23
* @AWriter
* AWriter is a template for all languages writer classes. it is expandable. 
* AWriter planned to monitor class's datas and write them to files or anywhere else.
* 
*/
package writer;

import java.io.IOException;

import models.classes.AClass;

public abstract class AWriter {
	protected final AClass clss;

	// constructor
	public AWriter(AClass clss) {
		this.clss = clss;
	}

	protected abstract void cleanFiles();

	// write to file with given path via arguments
	public abstract void writeToFile(String path) throws IOException;

	// write to file execute location.
	public abstract void writeToFile();

	// prints all the content to console
	public abstract void writeToConsole();
}

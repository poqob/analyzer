/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 07.04.23
* @JavaConstructorParser
* JavaConstructorParser can parse all Java constructors with its body and returns class's 
* all constructors as a AFunction List.
* 
*/

package parser.function.java;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.classes.java.JavaClass;
import models.function.AFunction;
import models.function.java.JavaConstructor;
import parser.function.AFunctionParser;
import parser.patterns.java.GetPatern;
import parser.patterns.java.Paterns;
import parser.util.java.CurlyBraces;

public class JavaConstructorParser extends AFunctionParser {

	// head of constructor from access modifier to first curly bracket.
	private String _head;

	// contructor requires a Java class object to run.
	public JavaConstructorParser(JavaClass clss) {
		super(clss);
		super.funList = new ArrayList<AFunction>();
	}

	private void _find() {

		// GetPatern.className = _getName();
		Paterns p = Paterns.constructor;
		Pattern pa = GetPatern.getPatern(p);
		Matcher matcher = pa.matcher(clss.toString());
		CurlyBraces cb;

		int _headIndex = 0;
		int[] range;
		// loop
		while (matcher.find()) {
			// attemt head
			_head = matcher.group();
			_headIndex = clss.toString().indexOf(_head);
			// find function body -blocks-
			cb = new CurlyBraces(clss.toString().substring(_headIndex));

			// function body (between brackets)range in class
			range = new int[] { _headIndex, cb.getBody().length() + _headIndex + _head.length() };

			// Debug.Writer(_getHead() + cb.getBody() + "\n");
			// attemt to funList as new created AFunction
			super.funList.add(new JavaConstructor(_getName(), range, _getHead() + cb.getBody()));

		}
	}

	// returns constructor definition line
	private String _getHead() {
		return _head.substring(0, _head.length() - 1);
	}

	// returns constructor name
	private String _getName() {
		return super.clss.getName();
	}

	// parse and return parsed AFunctions
	@Override
	public ArrayList<AFunction> parse() {
		_find();
		return super.funList;
	}

}

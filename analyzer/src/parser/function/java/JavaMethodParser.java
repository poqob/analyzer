/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 07.04.23
* @JavaMethodParser
* JavaMethodParser can parse all Java methods with its body. parse() method Returns 
* class's all methods as a AFunction List.
* 
*/

package parser.function.java;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.classes.java.JavaClass;
import models.function.AFunction;
import models.function.java.JavaMethod;
import parser.function.AFunctionParser;
import parser.patterns.java.GetPatern;
import parser.patterns.java.Paterns;
import parser.util.java.CurlyBraces;

public class JavaMethodParser extends AFunctionParser {

	// head of method from access modifier to first curly bracket.
	private String _head;

	// constructor
	public JavaMethodParser(JavaClass clss) {
		super(clss);

		super.funList = new ArrayList<AFunction>();
	}

	private void _find() {
		// variables
		Paterns p = Paterns.method;
		Pattern pa = GetPatern.getPatern(p);
		Matcher matcher = pa.matcher(clss.toString());
		CurlyBraces cb;

		int _headIndex = 0;
		int[] range;
		// loop
		while (matcher.find()) {
			// attemt head
			this._head = matcher.group();
			_headIndex = clss.toString().indexOf(_head);

			if (super.clss.getName().contains(_getName()))
				continue;
			// find body
			cb = new CurlyBraces(clss.toString().substring(_headIndex));

			// range
			range = new int[] { _headIndex, cb.getBody().length() + _headIndex + _head.length() };

			// Debug.Writer(_getName() + "\n");
			// attemt to funList as new created AFunction
			super.funList.add(new JavaMethod(_getName(), range, _getHead() + cb.getBody()));

		}
	}

	// returns method definition line
	private String _getHead() {
		return _head.substring(0, _head.length() - 1);
	}

	// returns method's name
	private String _getName() {
		String head = _head;

		int _start = 0;
		int _stop = head.indexOf("()");
		for (int i = _stop; i > 0; i--) {
			_start = i;
			if (head.charAt(i) == ' ')
				break;
		}
		// Debug.Writer(head);

		return head.substring(_start, _stop).trim();
	}

	// parse and return parsed AFunctions
	@Override
	public ArrayList<AFunction> parse() {
		_find();
		return super.funList;
	}
}

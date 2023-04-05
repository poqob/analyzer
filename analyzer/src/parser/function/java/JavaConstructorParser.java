package parser.function.java;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.classes.AClass;
import models.function.AFunction;
import models.function.java.JavaConstructor;
import parser.function.AFunctionParser;
import parser.patterns.java.GetPatern;
import parser.patterns.java.Paterns;
import parser.util.java.CurlyBraces;

public class JavaConstructorParser extends AFunctionParser {

	private String _head;

	public JavaConstructorParser(AClass clss) {
		super(clss);
		super.funList = new ArrayList<AFunction>();
	}

	private void _find() {
		// variables
		Paterns p = Paterns.constructor;
		// GetPatern.className = _getName();
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
			// find body
			cb = new CurlyBraces(clss.toString().substring(_headIndex));

			// range
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

	@Override
	public ArrayList<AFunction> parse() {
		_find();
		return super.funList;
	}

}

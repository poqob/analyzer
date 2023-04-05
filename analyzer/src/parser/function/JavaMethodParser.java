package parser.function;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.classes.JavaClass;
import models.function.AFunction;
import models.function.Method;
import parser.patterns.java.GetPatern;
import parser.patterns.java.Paterns;
import parser.util.java.CurlyBraces;
import util.Todo;

@Todo("method parser only parses first method of class (non constructor)")
public class JavaMethodParser extends AFunctionParser {

	private String _head;

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
			range = new int[] { _headIndex, cb.getBody().length() + _headIndex };

			// Debug.Writer(_getName() + "\n");
			// attemt to funList as new created AFunction
			super.funList.add(new Method(_getName(), range, _getHead() + cb.getBody()));

		}
	}

	// returns constructor definition line
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

	@Override
	public ArrayList<AFunction> parse() {
		_find();
		return super.funList;
	}
}

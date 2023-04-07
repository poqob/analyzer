/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 06.04.23
* @JavaClassParser
* JavaClassParser is a Java-based class-parser class. this class takes related file's 
* path as parameter from constructor and firstly dedects classes name inorder to assign
* constructors as constructor not method. both of them simular types. JavaClassParser
* 
*/

package parser.classes.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.classes.AClass;
import models.classes.java.JavaClass;
import parser.classes.AClassParser;
import parser.patterns.java.GetJavaPattern;
import parser.patterns.java.JavaPatterns;
import parser.util.java.JavaCurlyBraces;

public class JavaClassParser extends AClassParser {
	// fields
	private JavaClass clss;
	private String _name;
	private static String __name;
	private final String _pure;
	private static String _head;

	public JavaClassParser(String path) {
		this._name = _getName(path);
		_pure = find(path).toString();

	}

	// fnds related character sets like definition line of class.
	private static StringBuilder find(String dir) {

		// requested java class patern (pattern)
		JavaPatterns p = JavaPatterns.classes;

		GetJavaPattern.className = __name;
		Pattern pa = GetJavaPattern.getPatern(p);
		Matcher matcher = null;
		StringBuilder sb = new StringBuilder();
		// line counter
		int lineCount = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(dir))) {
			String line;

			// dedect which line is start of our scope
			while ((line = br.readLine()) != null) {
				lineCount++;
				matcher = pa.matcher(line);
				if (matcher.find()) {
					// attemt head line of class
					_head = matcher.group();
					break;
				}
			}

			br.close();
			// new buffer to read from scratch
			BufferedReader br0 = new BufferedReader(new FileReader(dir));

			while ((line = br0.readLine()) != null) {

				if (lineCount <= 1)
					sb.append(line + "\n");
				else
					lineCount--;

			}
			br0.close();
		} catch (

		IOException e) {
			e.printStackTrace();
		}

		return sb;
	}
	// getters

	// returns first line of clas definition without curly brace
	private static String getHead() {
		return _head.substring(0, _head.length() - 1);
	}

	// returns class name
	private static String _getName(String _dir) {
		StringBuilder _allClass = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(_dir))) {
			String line;

			// dedect which line is start of our scope
			while ((line = br.readLine()) != null) {
				_allClass.append(line);
			}

			br.close();

		} catch (

		IOException e) {
			e.printStackTrace();
		}

		String head = _allClass.toString();
		int _start = head.indexOf("class") + 6;
		int _stop = head.indexOf("{");
		__name = head.substring(_start, _stop).trim();
		return __name;
	}

	// takes input file, pure text then turns into AClass object
	@Override
	public AClass parseClass() {
		JavaCurlyBraces brc = new JavaCurlyBraces(_pure);

		String struct = getHead() + brc.getBody();

		clss = new JavaClass(_name, struct);
		return clss;
	}

}

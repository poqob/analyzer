/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 07.04.23
* @JavaCommentParser
* JavaCommentParser is a child class of ACommentParser. 
* JavaCommentParser requires JavaClass object to run. JavaCommentParser
* parses various typed comments from JavaClass. 
* 
*/
package parser.comment.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.classes.java.JavaClass;
import models.comment.AComment;
import models.comment.java.JavaMultiComment;
import models.comment.java.JavaSingleComment;
import models.comment.java.JavadocComment;
import parser.comment.ACommentParser;
import parser.patterns.java.GetJavaPattern;
import parser.patterns.java.JavaPatterns;

public class JavaCommentParser extends ACommentParser {

	public JavaCommentParser(JavaClass clss) {
		super(clss);
	}

	private void _find() {
		_single();
		_multiComment();
		_javadocComment();
	};

	// line by line is neccessary to dedect single-line comments.
	// multi-line and javadoc comments can dedected by whole JavaClass (as String)
	private void _single() {
		String str = super.clss.toString();
		BufferedReader reader = new BufferedReader(new StringReader(str));
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				// send lines to single line comment dedector.
				_singleComment(line);
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	// dedects single-line comments according to JavaPatterns.
	private void _singleComment(String line) {

		// parsing with regex.
		JavaPatterns p = JavaPatterns.single;
		Pattern pa = GetJavaPattern.getPatern(p);
		Matcher matcher = pa.matcher(line);

		// regex exprassion start location in JavaClass (character based location)
		int _startIndex = 0;
		// exprassion match
		String match = "";

		// if exprassion exists then this while creates new JavaSingleComment object and
		// adds it to super classes AComment List. Remember JavaSingleComment is a sub
		// class of ASingleComment that is sub class of AComment!

		while (matcher.find()) {
			match = matcher.group();
			_startIndex = super.clss.toString().indexOf(match);
			super.comments.add(new JavaSingleComment(new int[] { _startIndex, match.length() + _startIndex }, match));
		}

	}

	// dedects multi line java comments
	private void _multiComment() {
		// parsing with regex.
		JavaPatterns p = JavaPatterns.multi;
		Pattern pa = GetJavaPattern.getPatern(p);
		Matcher matcher = pa.matcher(clss.toString());

		// regex exprassion start location in JavaClass (character based location)
		int _startIndex = 0;
		String match = "";

		// if exprassion exist creates new JavaMultiComment which is sub class of
		// AMultiComment and also AComment. Then adds the object to its parent's
		// AComment
		// list.
		while (matcher.find()) {
			match = matcher.group();
			_startIndex = super.clss.toString().indexOf(match);
			super.comments.add(new JavaMultiComment(new int[] { _startIndex, match.length() + _startIndex }, match));
		}
	}

	// dedects javadoc comments
	private void _javadocComment() {

		// parsing with regex.
		JavaPatterns p = JavaPatterns.javadoc;
		Pattern pa = GetJavaPattern.getPatern(p);
		Matcher matcher = pa.matcher(clss.toString());

		// regex exprassion start location in JavaClass (character based location)
		int _startIndex = 0;
		String match = "";

		// if exprassion exist creates new JavadocComment which is sub class of
		// ADocumentComment and also AComment. Then adds the object to its parent's
		// AComment
		// list.
		while (matcher.find()) {
			match = matcher.group();
			_startIndex = super.clss.toString().indexOf(match);
			super.comments.add(new JavadocComment(new int[] { _startIndex, match.length() + _startIndex }, match));
		}
	}

	// The only accesible method, calls all work and as result of that returns
	// AComment list.
	@Override
	public ArrayList<AComment> parse() {
		_find();
		return super.comments;
	}

}

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
import java.util.LinkedList;
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

	// it keeps only single-lined comments of the class to compare them if they are
	// in other comments range.
	private ArrayList<JavaSingleComment> _singles = new ArrayList<JavaSingleComment>();

	// some methods in class does remove procces from list that contains dedected
	// comments. i wanted to use linked list instead array list inorder to increase
	// performance. it is hard to remove data from array list, if you want to remove
	// somewhere at middles after removing process whole list shifts one unit to
	// fill the space which was created by removed object.
	private LinkedList<AComment> _localComments = new LinkedList<AComment>();

	public JavaCommentParser(JavaClass clss) {
		super(clss);
	}

	// trigger method
	private void _find() throws IOException {
		_single();
		_multiComment();
		_javadocComment();
		_correctSingles();
		super.comments = new ArrayList<AComment>(_localComments);
	};

	// line by line is neccessary to dedect single-line comments.
	// multi-line and javadoc comments can dedected by whole JavaClass (as String)
	private void _single() throws IOException {
		String str = super.clss.toString();
		BufferedReader reader = new BufferedReader(new StringReader(str));
		String line;

		while ((line = reader.readLine()) != null) {
			// send lines to single line comment dedector.
			_singleComment(line);
		}

	}

	// dedects single-line comments according to JavaPatterns.
	private void _singleComment(String line) {

		// thanks to this variable we can only take first match of the line
		// this provides me ability to prevent chance of dedect more than one single
		// comment at the same line
		// _lineSearched value turns true after first match.
		boolean _lineSearched = false;

		// parsing with regex.
		JavaPatterns p = JavaPatterns.single;
		Pattern pa = GetJavaPattern.getPatern(p);
		Matcher matcher = pa.matcher(line);

		// regex exprassion start location in JavaClass (character based location)
		int _startIndex = 0;
		// exprassion match
		String match = "";

		// temp comment
		JavaSingleComment javacomment;

		// if exprassion exists then this while creates new JavaSingleComment object and
		// adds it to super classes AComment List. Remember JavaSingleComment is a sub
		// class of ASingleComment that is sub class of AComment!

		if (matcher.find() && _lineSearched == false) {
			_lineSearched = true;
			match = matcher.group();
			_startIndex = super.clss.toString().indexOf(match);

			// creating new java comment
			javacomment = new JavaSingleComment(new int[] { _startIndex, match.length() + _startIndex }, match);
			_singles.add(javacomment);
			_localComments.add(javacomment);
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
			_localComments.add(new JavaMultiComment(new int[] { _startIndex, match.length() + _startIndex }, match));
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
			_localComments.add(new JavadocComment(new int[] { _startIndex, match.length() + _startIndex }, match));
		}
	}

	/*
	 * _correctSingles() and _containsAnySingle() methods controlls if a single-line
	 * comment is in another type comment's bounds-rannge-. if it is, the dedected
	 * single comment will be removed from _localComment(LinkedList).
	 */
	private void _correctSingles() {
		ArrayList<AComment> _temp = new ArrayList<AComment>();
		_localComments.forEach(c -> _temp.add(c));
		_temp.forEach(comm -> {
			_containsAnySingle(comm);
		});
	}

	private void _containsAnySingle(AComment comm) {
		_singles.forEach(single -> {
			if (!single.equals(comm)) {
				if (single.getRange()[0] >= comm.getRange()[0] && single.getRange()[1] <= comm.getRange()[1]) {
					// if program reaches this line,
					// that means: we have a single-lined function which // in range of another
					// multi-line or special comment. lets remove this single // comment that
					// already in another comment: :')
					_localComments.remove(single);
				}
			}

		});
	}

	// The only accesible method, calls all work and as result of that returns
	// AComment list.
	@Override
	public ArrayList<AComment> parse() throws IOException {
		_find();
		return super.comments;
	}

}

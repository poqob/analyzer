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
import util.Todo;

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
	private LinkedList<AComment> _comments = new LinkedList<AComment>();

	public JavaCommentParser(JavaClass clss) {
		super(clss);
	}

	// trigger method
	private void _find() throws IOException {
		_single();
		_multiComment();
		_javadocComment();

		_correctSingles();
		_correctOthers();
		super.comments = new ArrayList<AComment>(_comments);

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

	private void _correctSingles() {
		ArrayList<AComment> _temp = new ArrayList<AComment>();
		_localComments.forEach(c -> _temp.add(c));
		_temp.forEach(comm -> {
			_containsAnySingle(comm);
		});
	}

	@Todo(" javadoc icinde cok, cok icinde javadoc yorumlari tespit edip silmeliyiz.")
	// TODO: taktik su; tum javadoclari bul, icindeki cok yorumlari bul ve cok
	// yorumlari _comments'e ekleme

	// TODO: cok yorumlari bul, icindeki javadoclari bul ve bunlari _comments'e
	// ekleme
	int _index;

	private void _correctOthers() {
		_index = -1;
		ArrayList<AComment> _tempMultiple = new ArrayList<AComment>();
		ArrayList<AComment> _tempJavadoc = new ArrayList<AComment>();
		/*
		 * getting multipe and javadocument comments from _localComments list variable.
		 * purpose of that, to compare these comments inorder to one is in another
		 * situation.
		 */
		_localComments.forEach(y -> {
			if (y instanceof JavadocComment)
				_tempJavadoc.add(y);
			else if (y instanceof JavaMultiComment)
				_tempMultiple.add(y);
			else // add single lined comments to _comments
				_comments.add(y);
		});

		ArrayList<Integer> _multiplesWillBeRemoved = new ArrayList<Integer>();
		ArrayList<Integer> _javadocsWillBeRemoved = new ArrayList<Integer>();

		// controlling if there is a javadocument comment in range of any multiple
		// comment.
		_tempMultiple.forEach(m -> {
			// to reset index because temp javadoc comment list gonna be iterated again.
			_index = -1;
			_tempJavadoc.forEach(j -> {
				_index++;
				if (j.getRange()[0] > m.getRange()[0] && j.getRange()[1] <= m.getRange()[1]) {
					_javadocsWillBeRemoved.add(_index);
				}
			});
		});

		// controlling if there is a multipe comment in range of any javadoc
		// comment.
		_tempJavadoc.forEach(j -> {
			// to reset index because temp multiple comment list gonna be iterated again.
			_index = -1;
			_tempMultiple.forEach(m -> {
				_index++;
				if (m.getRange()[0] > j.getRange()[0] && m.getRange()[1] <= j.getRange()[1]) {
					_multiplesWillBeRemoved.add(_index);
				}
			});
		});

		// delete found indexes from temp lists.
		_multiplesWillBeRemoved.forEach(mi -> _tempMultiple.remove(mi.intValue()));
		_javadocsWillBeRemoved.forEach(ji -> _tempJavadoc.remove(ji.intValue()));

		// add correct comments to the _comments variable
		_tempMultiple.forEach(m -> _comments.add(m));
		_tempJavadoc.forEach(j -> _comments.add(j));

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

/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 05.04.23
* @AClass
* an abstract model of class, i made it abstract to develop my oop skills.
* i can derivate various type class from AClass. This ability gives me to parse 
* different programming languages scripts. like: dart, python, java, c#
* in this situation(homework) our scope is JavaClass : AClass
*/

package models.classes;

import java.util.ArrayList;

import models.comment.AComment;
import models.function.AFunction;
import models.functionAndComments.AFunctionWithComments;
import util.Todo;

@Todo("i'm planning to add packages and imports as type and monitoring them with AClass.toString()")

public abstract class AClass {
	// class name
	private final String name;
	// hole class as String
	private final String text;
	// class's programming language, attempt in derivated class.
	private final String lang;

	/*
	 * according to my limited knowledge classes has functions(methods,
	 * constructors) and comments i designed functions and comments seperate from
	 * each other. Some situations require these structs to be together. To satisfy
	 * these needs i created a third mixed class which contains function and the
	 * function's comments(single,multi,special)
	 */
	protected ArrayList<AFunction> functions;
	protected ArrayList<AComment> comments;
	protected ArrayList<AFunctionWithComments> funcomms;

	// a variable that keeps some informations about AClass.
	private String statics = "";

	/*
	 * purpose of that method is binding functions and their comments together under
	 * AFunctionWithComments abstract type.
	 */
	protected abstract void pairFunComms();

	// constructor, name and text(class as a string) must be parsed, lang must be
	// initialized in subclass
	public AClass(String name, String text, String lang) {
		this.name = name;
		this.text = text;
		this.lang = lang;
	};

	// setters for functions and comments
	public void setFunctions(ArrayList<AFunction> functions) {
		this.functions = functions;
	}

	public void setComments(ArrayList<AComment> comments) {
		this.comments = comments;
	}

	// getters for all fields :D
	public ArrayList<AFunction> getFunctions() {
		return functions;
	}

	public ArrayList<AComment> getComments() {
		return comments;
	}

	public ArrayList<AFunctionWithComments> getFunComs() {

		if (funcomms == null)
			pairFunComms();
		return this.funcomms;
	}

	public String getName() {
		return name.trim();
	};

	public String getType() {
		return "CLASS";
	}

	public String getLanguage() {
		return lang;
	}

	// out of homework it was a debug method but still usefull for later updates
	// (python parser, dart parser)
	public String getStatics() {
		statics += (getLanguage().concat("-LANGUAGE\n") + getType() + " " + getName() + " 0," + toString().length()
				+ "\n");

		functions.forEach(f -> {
			statics += ((f.getType().concat(" ") + f.getName() + " " + f.getRange()[0] + "," + f.getRange()[1] + "\n"));
		});

		statics += "COMMENTS " + comments.size() + "\n";
		return statics;
	}

	@Todo("packages and imports not supported :( , i'll add that support :))")
	// returns class head and body with its functions & methods.
	public String toString() {
		return text;
	}
}

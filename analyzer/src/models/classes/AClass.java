package models.classes;

import java.util.ArrayList;

import models.comment.AComment;
import models.function.AFunction;
import models.functionAndComments.AFunctionWithComments;

public abstract class AClass {
	protected final String name;
	protected final String text;

	private ArrayList<AFunction> functions;
	private ArrayList<AComment> comments;
	private ArrayList<AFunctionWithComments> funcoms;

	public AClass(String name, String text) {
		this.name = name;
		this.text = text;
	};

	public void setFunctions(ArrayList<AFunction> functions) {
		this.functions = functions;
	}

	public void setComments(ArrayList<AComment> comments) {
		this.comments = comments;
	}

	public ArrayList<AFunction> getFunctions() {
		return functions;
	}

	public ArrayList<AComment> getComments() {
		return comments;
	}

	public ArrayList<AFunctionWithComments> getFunComs() {
		return funcoms;// null
	}

	public String getName() {
		return name.trim();
	};

	public String getType() {
		return "CLASS";
	}

	public String toString() {
		return text;
	}
}

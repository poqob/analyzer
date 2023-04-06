package models.classes;

import java.util.ArrayList;

import models.comment.AComment;
import models.function.AFunction;
import models.functionAndComments.AFunctionWithComments;

public abstract class AClass {
	protected final String name;
	protected final String text;

	protected ArrayList<AFunction> functions;
	protected ArrayList<AComment> comments;
	protected ArrayList<AFunctionWithComments> funcomms;
	private String statics = "";

	protected abstract void pairFunComms();

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

		if (funcomms == null)
			pairFunComms();
		return this.funcomms;// null
	}

	public String getName() {
		return name.trim();
	};

	public String getType() {
		return "CLASS";
	}

	public String getStatics() {
		statics += (getType() + " " + getName() + " 0," + toString().length() + "\n");

		functions.forEach(f -> {
			statics += ((f.getType().concat(" ") + f.getName() + " " + f.getRange()[0] + "," + f.getRange()[1] + "\n"));
		});

		statics += "COMMENTS " + comments.size() + "\n";
		return statics;
	}

	public String toString() {
		return text;
	}
}

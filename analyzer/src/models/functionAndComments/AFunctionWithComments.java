package models.functionAndComments;

import java.util.ArrayList;

import models.comment.AComment;
import models.comment.JavadocComment;
import models.comment.JavaMultiComment;
import models.comment.JavaSingleComment;
import models.function.AFunction;

public abstract class AFunctionWithComments extends AFunction {

	protected final AFunction function;
	protected ArrayList<JavaSingleComment> sComments;
	protected ArrayList<JavaMultiComment> mComments;
	protected ArrayList<JavadocComment> jComments;

	public AFunctionWithComments(AFunction function) {
		super(function.getName(), function.getRange(), function.getContent());
		this.function = function;
		sComments = new ArrayList<JavaSingleComment>();
		mComments = new ArrayList<JavaMultiComment>();
		jComments = new ArrayList<JavadocComment>();
	}

	public void addComment(AComment comment) {
		if (comment instanceof JavaSingleComment) {
			sComments.add((JavaSingleComment) comment);
		} else if (comment instanceof JavaMultiComment) {
			mComments.add((JavaMultiComment) comment);
		} else {
			jComments.add((JavadocComment) comment);
		}
	}

	public ArrayList<JavaSingleComment> getSingleComments() {
		return sComments;
	};

	public ArrayList<JavaMultiComment> getMultiComments() {
		return mComments;
	};

	public ArrayList<JavadocComment> getJavadocComments() {
		return jComments;
	};
}

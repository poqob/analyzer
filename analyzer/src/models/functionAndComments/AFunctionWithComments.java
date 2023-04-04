package models.functionAndComments;

import java.util.ArrayList;

import models.comment.AComment;
import models.comment.JavadocComment;
import models.comment.MultiComment;
import models.comment.SingleComment;
import models.function.AFunction;

public abstract class AFunctionWithComments extends AFunction {

	protected final AFunction function;
	protected ArrayList<SingleComment> sComments;
	protected ArrayList<MultiComment> mComments;
	protected ArrayList<JavadocComment> jComments;

	public AFunctionWithComments(AFunction function) {
		super(function.getName(), function.getRange()[0], function.getRange()[1], function.getContent());
		this.function = function;
		sComments = new ArrayList<SingleComment>();
		mComments = new ArrayList<MultiComment>();
		jComments = new ArrayList<JavadocComment>();
	}

	public void addComment(AComment comment) {
		if (comment instanceof SingleComment) {
			sComments.add((SingleComment) comment);
		} else if (comment instanceof MultiComment) {
			mComments.add((MultiComment) comment);
		} else {
			jComments.add((JavadocComment) comment);
		}
	}

	public ArrayList<SingleComment> getSingleComments() {
		return sComments;
	};

	public ArrayList<MultiComment> getMultiComments() {
		return mComments;
	};

	public ArrayList<JavadocComment> getJavadocComments() {
		return jComments;
	};
}

package models.functionAndComments;

import java.util.ArrayList;

import models.comment.AComment;
import models.comment.ADocumentComment;
import models.comment.AMultiComment;
import models.comment.ASingleComment;
import models.function.AFunction;

public abstract class AFunctionWithComments extends AFunction {

	protected final AFunction function;
	protected ArrayList<ASingleComment> sComments;
	protected ArrayList<AMultiComment> mComments;
	protected ArrayList<ADocumentComment> dComments;

	public AFunctionWithComments(AFunction function) {
		super(function.getName(), function.getRange(), function.toString());
		this.function = function;
		sComments = new ArrayList<ASingleComment>();
		mComments = new ArrayList<AMultiComment>();
		dComments = new ArrayList<ADocumentComment>();
	}

	public void addComment(AComment comment) {
		if (comment instanceof ASingleComment) {
			sComments.add((ASingleComment) comment);
		} else if (comment instanceof AMultiComment) {
			mComments.add((AMultiComment) comment);
		} else {
			dComments.add((ADocumentComment) comment);
		}
	}

	public AFunction getFunction() {
		return this.function;
	};

	public ArrayList<ASingleComment> getSingleComments() {
		return sComments;
	};

	public ArrayList<AMultiComment> getMultiComments() {
		return mComments;
	};

	public ArrayList<ADocumentComment> getJavadocComments() {
		return dComments;
	};
}

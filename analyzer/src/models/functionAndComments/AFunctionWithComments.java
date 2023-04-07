/**
*
* @author Mustafa BÝÇER, mustafa.bicer1@ogr.sakarya.edu.tr
* @since 06.04.23
* @AFunctionWithComments
* AFunctionWithComments is a type function and type comment mixed class.
* contains a function based process(method~constructor) type and its 
* various typed comments.
*/

package models.functionAndComments;

import java.util.ArrayList;

import models.comment.AComment;
import models.comment.ADocumentComment;
import models.comment.AMultiComment;
import models.comment.ASingleComment;
import models.function.AFunction;

public abstract class AFunctionWithComments extends AFunction {

	// fields
	protected final AFunction function;
	protected ArrayList<ASingleComment> sComments;
	protected ArrayList<AMultiComment> mComments;
	protected ArrayList<ADocumentComment> dComments;

	// constructor
	public AFunctionWithComments(AFunction function) {
		super(function.getName(), function.getRange(), function.toString());
		this.function = function;
		sComments = new ArrayList<ASingleComment>();
		mComments = new ArrayList<AMultiComment>();
		dComments = new ArrayList<ADocumentComment>();
	}

	// This method adds a comment to the corresponding list, after checking the type
	// of the comment parameter through instanceof operator
	public void addComment(AComment comment) {
		if (comment instanceof ASingleComment) {
			sComments.add((ASingleComment) comment);
		} else if (comment instanceof AMultiComment) {
			mComments.add((AMultiComment) comment);
		} else {
			dComments.add((ADocumentComment) comment);
		}
	}

	// getters
	public AFunction getFunction() {
		return this.function;
	};

	@Override
	public String getType() {
		return this.function.getType();
	}

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

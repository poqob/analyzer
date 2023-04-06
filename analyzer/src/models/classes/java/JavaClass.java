package models.classes.java;

import java.util.ArrayList;

import models.classes.AClass;
import models.comment.AComment;
import models.function.AFunction;
import models.functionAndComments.AFunctionWithComments;
import models.functionAndComments.java.JavaConstructorWithComments;
import models.functionAndComments.java.JavaMethodWithComments;

public class JavaClass extends AClass {
	// constructor
	public JavaClass(String name, String text) {
		super(name, text, "JAVA");
	}

	@Override
	protected void pairFunComms() {
		super.funcomms = new ArrayList<AFunctionWithComments>();
		int _count = -1;
		int _start = 0, _stop = 0;
		int _cstart = 0, _cstop = 0;

		for (AFunction f : functions) {
			_count++;
			// _stop value equals lastly readed functions last brackets location in its
			// class.

			_stop = f.getRange()[1];
			// works good
			// Debug.Writer(_start + " " + _stop + "\n");

			// JavaMethodWithComments about to have some comments or not.
			if (f.getType() == "CONSTRUCTOR")
				super.funcomms.add(new JavaConstructorWithComments(f));
			else
				super.funcomms.add(new JavaMethodWithComments(f));

			// controling is there any comment in _start,_stop bounds.
			for (AComment c : super.comments) {
				// currently read comments range in class as character location.
				_cstart = c.getRange()[0];
				_cstop = c.getRange()[1];
				// controlls if the comment in range of current function
				if ((_cstart > _start) && (_stop > _cstop)) {
					super.funcomms.get(_count).addComment(c);
				}
			}
			_start = _stop;
		}

	}

}

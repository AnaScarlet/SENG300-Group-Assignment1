package src.Assign3;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class VisitInterfDec extends ASTVisitor {
	
	private static int num = 0;

	public boolean visit(TypeDeclaration node) {
		if (node.isInterface()) {
			num ++;
			System.out.println("Visited an Interface Decaration");
		} else
			System.out.println("Visited an Class Decaration");
		return false; // skip children of this node
	}
	
	public int getNum() {
		return num;
	}
	
}

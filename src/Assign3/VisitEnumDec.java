package src.Assign3;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.EnumDeclaration;

public class VisitEnumDec extends ASTVisitor {
	
	private static int num = 0;

	public boolean visit(EnumDeclaration node) {
		System.out.println("Visited a EnumDeclaration");
		num ++;
		return false; // skip children of this node
	}
	
	public int getNum() {
		return num;
	}

}

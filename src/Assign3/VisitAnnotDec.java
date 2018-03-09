package src.Assign3;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class VisitAnnotDec extends ASTVisitor {
	
	private static int num = 0;
	
	public boolean visit(AnnotationTypeDeclaration node) {
		System.out.println("Visited a AnnotationTypeDeclaration");
		num ++;
		return false; // skip children of this node
	}

	public int getNum() {
		return num;
	}
	
		
}

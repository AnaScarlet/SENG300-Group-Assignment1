package src.Assign3;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.SimpleName;

public class VisitSimpleType extends ASTVisitor{

	private String name;
	private int refCount = 0;
	private int decCount = 0;
	
	public VisitSimpleType(String name) {
		this.setName(name);
	}
	
	public boolean visit(SimpleType node) {
		QualifiedName myQName;
		SimpleName mySName;
		if (node.getName().getFullyQualifiedName().equals(name)) {
			if (node.getName().isQualifiedName()) {
				myQName = (QualifiedName) node.getName();
				mySName = myQName.getName();
			} else
				mySName = (SimpleName) node.getName();
			
			if (mySName.isDeclaration())
				decCount ++;
			else 
				refCount ++;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRefCount() {
		return refCount;
	}

	public int getDecCount() {
		return decCount;
	}

}

package src.Assign3;

import org.eclipse.jdt.core.dom.*;

public class VisitReferences extends ASTVisitor  {
//Simple type returns a good value
// QualifiedType Node does nothing in how we set it up
// NameQualifiedType Does not work. 
// 
	String QualName = "";
	
	public VisitReferences(String QualName) {
		this.QualName = QualName;
	}
	
	private static int num = 0;											//Total number of declarations found.
	
	
	
	/**
	 * This function searches through he AST given and counts the total number of declarations found
	 * of type class.
	 * 
	 * @param node		The AST to search though.
	 * @return			False, to skip the nodes children.
	 */
	
	public boolean visit(SimpleType node) {
		
		if(node.getName().toString().equals(QualName)) {
			System.out.println(QualName);
			num ++;								
		}
		return false; 			// skip children of this node
	}

	
	/**
	 * Getter for the total number of declarations found.
	 * 
	 * @return			The total number of declarations found.
	 */
	
	public int getNum() {
		return num;
	}
}

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
	
	private int num = 0;											//Total number of declarations found.
	
	
	
	/**
	 * This function searches through he AST given and counts the total number of declarations found
	 * of type class.
	 * 
	 * @param node		The AST to search though.
	 * @return			False, to skip the nodes children.
	 */
	
	public boolean visit(SimpleType node) {
		
		
		System.out.println(node.getName());
		if(node.getName().toString().equals(QualName)) {
			System.out.println(QualName);
			num ++;	
			return true;
		}
		return true; 			// go to children of this node
	}

	
	/**
	 * This function searches through he AST given and counts the total number of declarations found
	 * of type annotation.
	 * 
	 * @param node		The AST to search though.
	 * @return			False, to skip the nodes children.
	 */
	
	public boolean visit(MarkerAnnotation node) {
		if(node.getTypeName().toString().equals(QualName)) {//When finding a node of this type, print
			num ++;															//this message and increment the total.
			return true;				 // go to children of this node
		}
		return true;
	}
	
	
	/**
	 * This function searches through he AST given and counts the total number of declarations found
	 * of type annotation.
	 * 
	 * @param node		The AST to search though.
	 * @return			False, to skip the nodes children.
	 */
	
	public boolean visit(NormalAnnotation node) {
		if(node.getTypeName().toString().equals(QualName)) {//When finding a node of this type, print
			
		//System.out.println("Visited a AnnotationTypeDeclaration");		//When finding a node of this type, print
		num ++;
			return true;
		}	//this message and increment the total.
		return true;				 // skip children of this node
	}


	
	//this might mess up alongside Marker Annotations bindings don't seem to work. 
	public boolean visit(AbstractTypeDeclaration node) {

		if((node.getName().getFullyQualifiedName()).equals(QualName)){
			num ++;
			return true;
		}
		return true;	// go to children of this node
	}
	
	
	//TODO need to fix with resolve bindings.
	public boolean visit(TypeParameter node) {
		//System.out.println("2" + node.getName());
		if((node.getName().getFullyQualifiedName()).equals(QualName)){
			num ++;
			return true;
		}
		return true;	// go to children of this node
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

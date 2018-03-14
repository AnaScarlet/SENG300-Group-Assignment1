/**
 * @authors			    Anastasiya Lazarenko, Matthew Buhler, Zachary Hull
 * @team                1
 * @version             Group Assignment 1
 * @since               March 14th, 2018
 *
 * Course:              SENG300, University of Calgary
 * Instructor:          Prof. Robert Walker
 * 
 * This class uses the ASTVisitor to search for nodes of java language types
 * and counts the total number of references found.
 * <p>
 * Simple type returns a good value, QualifiedType Node does nothing in how we set it up
 * so NameQualifiedType Does not work.
 */

package src.Assign3;

import org.eclipse.jdt.core.dom.*;

public class VisitReferences extends ASTVisitor  {

	String QualName = "";										//Qualified name.
	
	public VisitReferences(String QualName) {
		this.QualName = QualName;
	}
	
	private int num = 0;										//Total number of declarations found.
	
	
	/**
	 * This function searches through he AST given and counts the total number of references found
	 * of SimpleType type.
	 * 
	 * @param node		The AST to search though.
	 * @return			True, to check the children.
	 */
	public boolean visit(SimpleType node) {
		if(node.getName().toString().equals(QualName)) {
			num ++;	
			return true;
		}
		return true;
	}

	
	/**
	 * This function searches through he AST given and counts the total number of references found
	 * of MarkerAnnotation type.
	 * 
	 * @param node		The AST to search though.
	 * @return			True, to check the children.
	 */
	public boolean visit(MarkerAnnotation node) {
		if(node.getTypeName().toString().equals(QualName)) {
			num ++;												//Type found and increment the total.
			return true;										//Check children of this node.
		}
		return true;
	}
	
	
	/**
	 * This function searches through he AST given and counts the total number of references found
	 * of NormalAnnotation type.
	 * 
	 * @param node		The AST to search though.
	 * @return			True, to check the children.
	 */
	public boolean visit(NormalAnnotation node) {
		if(node.getTypeName().toString().equals(QualName)) {
			num ++;						// increment total
			return true;
		}	
		return true;				 // don't skip children of this node
	}

	
	/**
	 * This function searches through he AST given and counts the total number of references found
	 * of TypeParameter type.
	 * 
	 * @param node		The AST to search though.
	 * @return			True, to check the children.
	 */
	public boolean visit(TypeParameter node) {
		if((node.getName().getFullyQualifiedName()).equals(QualName)){
			num ++;												//Type found and increment the total.
			return true;										//Check children of this node
		}
		return true;
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

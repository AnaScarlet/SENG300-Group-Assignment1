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
 * and counts the total number of declarations found.
 */

package src.Assign3;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.EnumConstantDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class VisitDeclarations extends ASTVisitor {
	
	String QualName = "";										//Qualified name
	
	public VisitDeclarations(String QualName) {
		this.QualName = QualName;
	}
	
	private int num = 0;										//Total number of declarations found.
	
	
	/**
	 * This function searches through he AST given and counts the total number of declarations found
	 * of type TypeDeclaration.
	 * 
	 * @param node		The AST to search though.
	 * @return			True, to check the children.
	 */
	public boolean visit(TypeDeclaration node) {
		if(node.getName().toString().equals(QualName)){  
			num ++;								
			return true;
		}
		return true; 	
	}

	/**
	 * This function searches through he AST given and counts the total number of declarations found
	 * of type AnnotationTypeDeclaration.
	 * 
	 * @param node		The AST to search though.
	 * @return			True, to check the children.
	 */
	public boolean visit(AnnotationTypeDeclaration node) {
		if(node.getName().toString().equals(QualName)){  		//Type found and increment the total.
			num ++;										
			return true;										//Check children of this node
		}
		return true;
	}

	/**
	 * This function searches through he AST given and counts the total number of declarations found
	 * of type EnumerationConstantDeclaration.
	 * 
	 * @param node		The AST to search though.
	 * @return			True, to check the children.
	 */
	public boolean visit(EnumConstantDeclaration node) {
		System.out.println("have an EnumConstantDeclaration: " + node.getName());
		if(node.getName().toString().equals(QualName)){ 	
			num ++;													// increment the total.
			return true;  // go to children of this node
		}
		return true;
	}
	
	public boolean visit(EnumDeclaration node) {
		System.out.println("have an EnumDeclaration: " + node.getName());
		if(node.getName().toString().equals(QualName)){ 	
			num ++;													//increment the total.
			return true;  // go to children of this node
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

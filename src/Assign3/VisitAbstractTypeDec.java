/**
 * @authors			    Anastasiya Lazarenko, Matthew Buhler, Zachary Hull
 * @team                1
 * @version             Group Assignment 1
 * @since               March 14th, 2018
 *
 * Course:              SENG300, University of Calgary
 * Instructor:          Prof. Robert Walker
 * 
 * This class uses the ASTVisitor to search for nodes of java language type EnumDeclaration
 * and counts the total number of declarations found.
 */

package src.Assign3;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.EnumConstantDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;

public class VisitAbstractTypeDec extends ASTVisitor {
	
	private static int num = 0;									//The total number of declarations found.

	
	/**
	 * This function searches through he AST given and counts the total number of declarations found
	 * of type enumeration.
	 * 
	 * @param node		The AST to search though.
	 * @return			False, to skip the nodes children.
	 */
	
	public boolean visit(AbstractTypeDeclaration node) {
		System.out.println("Visited an AbstractTypetDeclaration");		//When a class node is found print a message
		num ++;													//and increment the total.
		System.out.println(node.getName().getFullyQualifiedName());
		return false; 					// skip children of this node
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

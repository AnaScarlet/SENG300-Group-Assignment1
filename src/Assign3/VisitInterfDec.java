/**
 * @authors			    Anastasiya Lazarenko, Matthew Buhler, Zachary Hull
 * @team                1
 * @version             Group Assignment 1
 * @since               March 14th, 2018
 *
 * Course:              SENG300, University of Calgary
 * Instructor:          Prof. Robert Walker
 * 
 * This class uses the ASTVisitor to search for nodes of java language type TypeDeclaration (Interface)
 * and counts the total number of declarations found.
 */

package src.Assign3;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class VisitInterfDec extends ASTVisitor {
	
	private static int num = 0;										//The total number of declarations found.

	
	/**
	 * This function searches through he AST given and counts the total number of declarations found
	 * of type enumeration.
	 * 
	 * @param node		The AST to search though.
	 * @return			False, to skip the nodes children.
	 */
	
	public boolean visit(TypeDeclaration node) {
		if (node.isInterface()) {
			num ++;													//When a class node is found print a message
			System.out.println("Visited an Interface Decaration");	//and increment the total.
		} else														//This type also finds class declarations
			System.out.println("Visited an Class Decaration");		//so we must ignore them.
		return false; 						// skip children of this node
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

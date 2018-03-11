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
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class VisitClassInstCreation extends ASTVisitor {
	
	private static int num = 0;										//The total number of references found.
	
	
	/**
	 * This function searches through he AST given and counts the total number of references found
	 * of type class.
	 * 
	 * @param node		The AST to search though.
	 * @return			False, to skip the nodes children.
	 */
	
	public boolean visit(ClassInstanceCreation node) {
		System.out.println("Visited a ClassInstanceCreation");		//When a class node is found print a message
		num ++;														//and increment the total.
		return false; 				// skip children of this node			
	}
	
	
	/**
	 * Getter for the total number of references found.
	 * 
	 * @return			The total number of references found.
	 */
	
	public int getNum() {
		return num;
	}	
}

/**
 * @authors			    Anastasiya Lazarenko, Matthew Buhler, Zachary Hull
 * @team                1
 * @version             Group Assignment 1
 * @since               March 14th, 2018
 *
 * Course:              SENG300, University of Calgary
 * Instructor:          Prof. Robert Walker
 * 
 * This class uses the ASTVisitor to search for nodes of java language type TypeDeclaration (class)
 * and counts the total number of declarations found.
 */

package src.Assign3;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class VisitClassDec extends ASTVisitor {
	
	String QualName = "";
	
	public VisitClassDec(String QualName) {
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
	
	public boolean visit(TypeDeclaration node) {
		if (node.isInterface())
			System.out.println("Visited an Interface Decaration");		//This type also finds interface declarations
		else {				
			//so we must ignore them.
			//System.out.println(node.getName().toString() == "VisitAnnotDec");
						
			if(node.getName().toString().equals(QualName)){  
			System.out.println("Visited a Class Decaration");			//When a class node is found print a message
			num ++;								
			}//and increment the total.
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

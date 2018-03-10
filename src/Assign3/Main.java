/**
 * @authors			    Anastasiya Lazarenko, Matthew Buhler, Zachary Hull 
 * @team                1
 * @version             Group Assignment 1
 * @since               March 14th, 2018
 *
 * Course:              SENG300, University of Calgary
 * Instructor:          Prof. Robert Walker 
 *
 * 1. takes a pathname to indicate a directory of interest,
 * 2. takes a string to indicate a fully qualified name of a Java type,
 * 3. counts the number of declarations of that type within that directory (non-recursively!), and
 * 4. counts the number of references to each occurrence of that type within that directory (non-recursively!).
 *  Referenced code //https://www.programcreek.com/2011/11/use-jdt-astparser-to-parse-java-file/
 * aa
 */
package src.Assign3;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
 
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
 

public class Main {
	
	/* TODO: Looking for references to classes
		String s = (String) new Integer(); - CastExpression, ClassInstanceCreation
		String.CASE_INSENSITIVE_ORDER;
		String.class - TypeLiteral
	 */
	public static void main(String[] args) throws InvalidArgumentsException{
		String path = "";
		String typeDec = "";
		try {
			path = args[0];
			typeDec = args[1];
			
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println("You did not provide enough arguments!");
			System.out.println("Please try again ");
			Scanner reader = new Scanner(System.in);  
			System.out.println("Enter a path: ");
			path = reader.next(); 
			System.out.println("Enter a Java type declaration: ");
			typeDec = reader.next(); 
			reader.close();
			if (typeDec.equals(""))
				throw new InvalidArgumentsException();
				System.exit(0);
		}
		MyParser parser = new MyParser(path, typeDec);
		try {
			parser.ParseFilesInDir();
		} catch (IOException e) {
			System.out.println("An exception occurred while parsing the given directory.");
		}
		// TODO: get counts of references and of declarations from parser and return them to user
	} 
}
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
	
	/**
	 * This is the main method which takes in two command line arguments (A java language type to 
	 * search for and a path name for a directory to search inside of) when running the program.
	 * The method validates the number or arguments, making sure two where given and then creates an
	 * instance of MyParser with the arguments. It then calls ParseFilesInDir from parser to attempt 
	 * to read the files. If it cannot an exception is thrown and an error statement printed.
	 * Finally the method gets and prints the number of references and declarations of the given type.
	 * 
	 * @param args		A list of args containing the path name first then the java.lang. type.
	 * @throws InvalidArgumentsException
	 */
	
	public static void main(String[] args) throws InvalidArgumentsException{
		String path = "";
		String typeDec = "";
		try {
			path = args[0];														//The two given arguments.
			typeDec = args[1];

		} catch (java.lang.ArrayIndexOutOfBoundsException e) {					//If less than two arguments given
			System.out.println("You did not provide enough arguments!");		//an error is caught and corresponding
			System.out.println("Please try again ");							//messages printed to try again.
			Scanner reader = new Scanner(System.in);
			System.out.println("Enter a path: ");								//Second attempt at providing the 
			path = reader.next();												//arguments.
			System.out.println("Enter a Java type declaration: ");
			typeDec = reader.next();
			reader.close();	
			if (typeDec.equals(""))												//If type is an empty string throw
				throw new InvalidArgumentsException();							//an exception and exit the program.
				System.exit(0);
		}
		MyParser parser = new MyParser(path, getTypeName(typeDec));							//Create a new parser instance with
		try {																	//the given arguments.
			parser.ParseFilesInDir();											//Call the ParseFilesInDir method start
		} catch (IOException e) {												//reading files.
			System.out.println("An exception occurred while parsing the given directory.");
		}																		//Print an exception if there was a problem reading.

		System.out.println(typeDec + ". Declarations found: " + parser.getDeclarations() + 
			"; References found: " + parser.getReferences() + ".");		//Get and print the number of references and declarations in directory
	}			
	
	/**
	 * takes a full java type name and chops off everything but the type name 
	 * eg: java.lang.String to String
	 * @param fullTypeName
	 * @return typeName
	 */
	public static String getTypeName(String fullTypeName) {
		int len = fullTypeName.length();
		StringBuilder sb = new StringBuilder(fullTypeName);
		int lastIndx = sb.lastIndexOf(".", len);
		
		char[] fullTypeNameChar = fullTypeName.toCharArray();
		String typeName = "";
		
		for (int i=0; i<len; i++) {
			if (i > lastIndx) {
				typeName += fullTypeNameChar[i];
			}
		}
		return typeName;
	}
	
}

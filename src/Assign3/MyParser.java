/**
 * @authors			    Anastasiya Lazarenko, Matthew Buhler, Zachary Hull
 * @team                1
 * @version             Group Assignment 1
 * @since               March 14th, 2018
 *
 * Course:              SENG300, University of Calgary
 * Instructor:          Prof. Robert Walker
 * 
 * This class is the primary file reader. It searches through files in a directory and reads
 * everything within the files. It also decides what classes to use to search for the given
 * java language type and saves the number or declarations and references they found.
 */


package src.Assign3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ASTVisitor;

public class MyParser {


	private String typeDec = "init";
	public String dirPath = "init";
	private int	declarations = 0;
	private int	references = 0;


	public MyParser(String path, String typeDec) {
		this.typeDec = typeDec;					//Constructor used to take the directory path
		this.dirPath = path;									//and the language type.
	}

	/**
	 * Number of declarations getter.
	 * 
	 * @return			Number of declarations.
	 */
	public int getDeclarations(){

		return declarations;
	}

	
	/**
	 * Number of references getter.
	 * 
	 * @return			Number of references.
	 */
	public int getReferences(){

		return references;
	}


	/**
	 * Creates an AST using the given string and determines which type was given.
	 * It then calls the methods which searches and counts the number of declarations and
	 * references of that type within the AST.
	 * 
	 * @param filePath		A given string to convert into an AST.
	 */
	public void parse(String filePath) {

		ASTParser parser = ASTParser.newParser(AST.JLS8);					//Creating the AST with the given string.
		parser.setSource(filePath.toCharArray());
		parser.setResolveBindings(true);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setBindingsRecovery(false);
		
		final ASTNode node =  parser.createAST(null);						//AST node to be used to search through.
	    
		allDeclarations(node);
		allReferences(node);
				
	}
	
	/**
	 * This method is called to use VisitReferences to search for all 
	 * type references and change the number found in this class 
	 * to the number found in a.
	 * 
	 * @param node		The final AST created to be searched.
	 */
	
	public void allReferences(ASTNode node){
		VisitReferences a = new VisitReferences(typeDec);				//Create an instance of this class and use it
		node.accept(a);														//to search for references of classes. 
		references = a.getNum() + references;										//Set the number of references found.
	}

		
	/**
	 * This method is called to use VisitDeclarations to search for all 
	 * type declarations and change the number found in this class 
	 * to the number found in a.
	 * 
	 * @param node		The final AST created to be searched.
	 */
	
	public void allDeclarations(ASTNode node){
		VisitDeclarations a = new VisitDeclarations(typeDec);								//Create an instance of this class and use it
		node.accept(a);														//To search for declarations of classes.
		declarations = a.getNum() + declarations;											//Set the number of declarations found.

	}

			
	/**
	 * This class uses the dirPath variable to get the absolute path for the
	 * directory loops through all files in the directory calling readFileToString
	 * to have it read each file. The value being returned from readFileToString
	 * is used as the argument to call parse.
	 * 
	 * @throws IOException
	 */

	public void ParseFilesInDir() throws IOException{
		
		File root = new File(dirPath);									// Takes the string path, converts that to an abstract pathname
		if (!root.isDirectory())
			throw new IOException();
		File[] files = root.listFiles( );								// then breaks that pathname into each file.
		String filePath = "";
		
		 for (File f : files ) {										// Loop through each file
			 filePath = f.getAbsolutePath();
			 if(f.isFile()){
				 					// switch case here?
				 System.out.println(filePath);
				 parse(readFileToString(filePath));						//Parse with the string of the file read
			 } else
				 throw new IOException();
		 }
	}

	
	/**
	 * This class reads the contents of a file and returns it as a string
	 * 
	 * @param filePath		The path to the file being read.
	 * @return 				The string format of the file.
	 * @throws IOException	
	 */
	
	public String readFileToString(String filePath) throws IOException {

		StringBuilder fileData = new StringBuilder();							//Opening the file to read it
		BufferedReader reader = new BufferedReader(new FileReader(filePath));

		char[] buf = new char[10];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {							//Loop through the file appending 
			String readData = String.valueOf(buf, 0, numRead);					//the lines read to a total
			fileData.append(readData);
			buf = new char[1024];
		}

		reader.close();															//Closing the file
		return  fileData.toString();											//returning what was read as a string
	}
}

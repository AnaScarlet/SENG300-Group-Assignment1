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
package temp.src.Assign3;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
 
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
 

public class Main {
 	
	public static void parse(String str) {
						
		ASTParser parser = ASTParser.newParser(AST.JLS9);
		parser.setSource(str.toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
 
		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
 
		cu.accept(new ASTVisitor() {
 
			Set names = new HashSet();
  
			public boolean visit(VariableDeclarationFragment node) {
				SimpleName name = node.getName();
				this.names.add(name.getIdentifier());
				System.out.println("Declaration of '" + name + "' at line"
						+ cu.getLineNumber(name.getStartPosition()));
				return false; // do not continue 
			}
			
		});
 
	}

	public static void ParseFilesInDir(String Path) throws IOException{
				
		// Takes the string path, converts that to an abstract pathname 
		// then breaks that pathname into each file. 
		File root = new File(Path);			
		File[] files = root.listFiles( ); 
		String filePath = "";
		
		// Loop through each file
		 for (File f : files ) {
			 filePath = f.getAbsolutePath();
			 if(f.isFile()){
				 parse(readFileToString(filePath));
			 }
		 }
	}
	
	//read file content into a string
	public static String readFileToString(String filePath) throws IOException {
		StringBuilder fileData = new StringBuilder();
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
 
		char[] buf = new char[10];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}
 
		reader.close();
		return  fileData.toString();	
	}
 	
	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(System.in);  
		System.out.println("Enter a path: ");
		String path = reader.next(); 
		reader.close();
		File dirs = new File(".");
		String path2 = dirs.getCanonicalPath() + File.separator+"src/Assign3"+File.separator;

		ParseFilesInDir(path2);
	}
}
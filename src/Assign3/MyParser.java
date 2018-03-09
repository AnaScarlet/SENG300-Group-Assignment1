package src.Assign3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;

public class MyParser {


	private String typeDec = "init";
	private String dirPath = "init";
	
	public MyParser(String path, String typeDec) {
		this.typeDec = typeDec;
		this.dirPath = new File("src/Assign3").getAbsolutePath();
	}
 	
	public void parse(String filePath) {
						
		ASTParser parser = ASTParser.newParser(AST.JLS9);
		parser.setSource(filePath.toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
 
		final ASTNode node =  parser.createAST(null);
 
		// switch case
		node.accept(new VisitInterfDec());
 
	}

	public void ParseFilesInDir() throws IOException{
				
		// Takes the string path, converts that to an abstract pathname 
		// then breaks that pathname into each file. 
		File root = new File(dirPath);			
		File[] files = root.listFiles( ); 
		String filePath = "";
		
		// Loop through each file
		 for (File f : files ) {
			 filePath = f.getAbsolutePath();
			 if(f.isFile()){
				 // switch case here?
				 
				 parse(readFileToString(filePath));
			 }
		 }
	}
	
	//read file content into a string
	public String readFileToString(String filePath) throws IOException {
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
	
}
